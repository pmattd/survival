package core.area;


import core.area.travel.Direction;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pete on 31/05/2016.
 */
public class Area {

    private final String description;
    private final List<Direction> directions;
    private List<Location> locations;
    private OptionList<ExecutableOption> scavengeOptions;


    public Area(String description,
                List<Direction> directions) {
        this.description = description;
        this.directions = directions;
    }

    public String getText() {
        return description;
    }

    public List<Direction> getDirections() {
        return directions;
    }


    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Location getArrivalLocation(){
        return locations.get(0);
    }

    public List<Location> getOtherLocations(Location location){
        return locations.stream().filter(loc -> !loc.equals(location)).collect(Collectors.toList());
    }

    public OptionList<ExecutableOption> getScavengeOptions() {
        return scavengeOptions;
    }

    public void setScavengeOptions(OptionList<ExecutableOption> scavengeOptions) {
        this.scavengeOptions = scavengeOptions;
    }

}
