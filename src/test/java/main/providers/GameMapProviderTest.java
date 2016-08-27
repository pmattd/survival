package main.providers;

import static java.util.Arrays.asList;

import static org.mockito.Mockito.when;

import core.area.CurrentLocation;
import core.area.GameMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.area.Area;
import core.area.Location;
import core.config.builder.AreaFactory;
import core.config.builder.ConfigBuildException;
import core.config.xml.Configuration;
import core.config.xml.areas.AreaConfig;
import core.config.xml.areas.AreaMapConfig;

/**
 * Created by Pete on 07/06/2016.
 */
public class GameMapProviderTest {


    GameMapProvider gameMapProvider;

    @Mock
    Configuration configuration;

    @Mock
    AreaFactory areaFactory;

    @Mock
    private AreaMapConfig areaMapConfig;

    @Mock
    private AreaConfig startAreaConfig;


    @Mock
    private AreaConfig areaConfig2;

    @Mock
    private Area area;

    @Mock
    private Location location;

    @Mock
    private CurrentLocation currentLocation;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gameMapProvider = new GameMapProvider(configuration, areaFactory, currentLocation);
    }

    @Test(expected = ConfigBuildException.class)
    public void testGet_noStartLocation() throws Exception {
        when(configuration.getAreaMapConfig()).thenReturn(areaMapConfig);
        when(areaMapConfig.getAreaConfigs()).thenReturn(asList(startAreaConfig));
        when(areaMapConfig.getLocationStart()).thenReturn(null);
        gameMapProvider.get();
    }


    @Test
    public void testGet() throws Exception {
        when(configuration.getAreaMapConfig()).thenReturn(areaMapConfig);
        when(areaMapConfig.getAreaConfigs()).thenReturn(asList(startAreaConfig, areaConfig2));
        when(areaMapConfig.getLocationStart()).thenReturn(startAreaConfig);
        when(areaFactory.build(startAreaConfig)).thenReturn(area);
        when(area.getArrivalLocation()).thenReturn(location);

        GameMap gameMap = gameMapProvider.get();
        //assertThat(travelHandler.getCurrentLocation()).isEqualTo(location);

    }

}