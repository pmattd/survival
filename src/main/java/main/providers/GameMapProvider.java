package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import core.area.CurrentLocation;
import core.area.GameMap;
import core.config.builder.ConfigBuildException;
import core.config.builder.AreaFactory;
import core.config.xml.Configuration;
import core.config.xml.areas.AreaConfig;
import core.area.Area;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pete on 06/06/2016.
 */

public class GameMapProvider implements Provider<GameMap> {

    private final Configuration configuration;
    private final AreaFactory areaFactory;
    private CurrentLocation currentLocation;
    Logger logger = LoggerFactory.getLogger(GameMapProvider.class);


    @Inject
    public GameMapProvider(Configuration configuration, AreaFactory areaFactory, CurrentLocation currentLocation) {
        this.configuration = configuration;
        this.areaFactory = areaFactory;
        this.currentLocation = currentLocation;
    }

    @Override
    public GameMap get() {

        AreaConfig startLocation = configuration.getAreaMapConfig().getLocationStart();
        if(startLocation == null){
            ConfigBuildException e =  new ConfigBuildException("no start location : add attribute to a location in the config");
            logger.error(e.toString());
            throw e;
        }

        Area area = areaFactory.build(startLocation);
        //currentLocation.setLocation(area.getArrivalLocation());

        return new GameMap(area);
    }
}
