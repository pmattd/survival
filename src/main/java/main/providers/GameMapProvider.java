package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import core.area.Area;
import core.area.GameMap;
import core.config.builder.AreaFactory;
import core.config.builder.ConfigBuildException;
import core.config.xml.Configuration;
import core.config.xml.areas.AreaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pete on 06/06/2016.
 */
@Singleton
public class GameMapProvider implements Provider<GameMap> {

    private final GameMap gameMap;
    Logger logger = LoggerFactory.getLogger(GameMapProvider.class);

    @Inject
    public GameMapProvider(Configuration configuration, AreaFactory areaFactory) {

        AreaConfig startLocation = configuration.getAreaMapConfig().getLocationStart();
        if(startLocation == null){
            ConfigBuildException e =  new ConfigBuildException("no start location : add attribute to a location in the config");
            logger.error(e.toString());
            throw e;
        }

        Area area = areaFactory.build(startLocation);

        gameMap = new GameMap(area);
    }

    @Override
    public GameMap get() {
        return gameMap;
    }
}
