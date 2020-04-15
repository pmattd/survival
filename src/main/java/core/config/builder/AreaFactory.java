package core.config.builder;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.area.Area;
import core.area.scavenge.ScavengeLocationOptionsFactory;
import core.area.travel.Direction;
import core.area.Location;
import core.boundary.options.OptionList;
import core.config.builder.travel.DirectionBuilder;
import core.config.xml.areas.AreaConfig;
import core.config.xml.areas.DirectionConfig;
import core.config.xml.areas.LocationConfig;

/**
 * Created by Pete on 06/06/2016.
 */
@Singleton
public class AreaFactory {

    private final DirectionBuilder directionBuilder;
    private final TextFactory textFactory;
    private final LocationFactory locationFactory;
    private HashMap<String, Area> builtAreas;
    private final ScavengeLocationOptionsFactory scavengeLocationOptionsFactory;

    @Inject
    public AreaFactory(DirectionBuilder directionBuilder,
                       TextFactory textFactory,
                       LocationFactory locationFactory,
                       ScavengeLocationOptionsFactory scavengeLocationOptionsFactory) {
        this.directionBuilder = directionBuilder;
        this.textFactory = textFactory;
        this.locationFactory = locationFactory;
        this.scavengeLocationOptionsFactory = scavengeLocationOptionsFactory;
        builtAreas = newHashMap();
    }

    public Area build(AreaConfig areaConfig) {

        assertLocationsNotEmpty(areaConfig);

        if(builtAreas.containsKey(areaConfig.getId())){
            return builtAreas.get(areaConfig.getId());
        }


        Area area = new Area(
                textFactory.build(areaConfig.getDesc()),
                buildDirections(areaConfig.getDirections()));


        //area is passed in so that the locations can have the area as a parameter
        //perhaps pass in an area proxy which is replaced with the real area? so that
        //or set the area in the location afterwards.
        //this would allow the scavenge options to be set in the constructor.
        //todo figure this stuff out

        List<Location> locations = buildLocations(areaConfig.getLocations(),area);

        area.setLocations(locations);
        area.setScavengeOptions(new OptionList<>(scavengeLocationOptionsFactory.build(locations)));


        builtAreas.put(areaConfig.getId(), area);

        return area;
    }

    private void assertLocationsNotEmpty(AreaConfig areaConfig) {
        List<LocationConfig> locationConfigs = areaConfig.getLocations();
        if(locationConfigs == null || locationConfigs.isEmpty()){
            ConfigBuildException configBuildException = new ConfigBuildException(String.format("area must have at least one location : %s",areaConfig.getId()));
            System.out.println(configBuildException);
            throw configBuildException;
        }
    }

    private List<Direction> buildDirections(List<DirectionConfig> directions) {

        if(directions == null){
            return Collections.emptyList();
        }
        return directions.stream()
                    .map(direction -> directionBuilder.build(direction,this))
                    .collect(Collectors.toList());
    }

    private List<Location> buildLocations(List<LocationConfig> locationConfigs, Area area){
        return locationConfigs.stream().
                map(s -> locationFactory.build(s, area)).
                collect(Collectors.toList());
    }



}
