package main.providers;

import core.area.Area;
import core.area.Location;
import core.config.builder.AreaFactory;
import core.config.builder.ConfigBuildException;
import core.config.xml.Configuration;
import core.config.xml.areas.AreaConfig;
import core.config.xml.areas.AreaMapConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

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

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(configuration.getAreaMapConfig()).thenReturn(areaMapConfig);
        when(areaMapConfig.getAreaConfigs()).thenReturn(asList(startAreaConfig, areaConfig2));

        when(areaFactory.build(startAreaConfig)).thenReturn(area);
        when(area.getArrivalLocation()).thenReturn(location);

    }

    @Test(expected = ConfigBuildException.class)
    public void testGet_noStartLocation() throws Exception {
        when(areaMapConfig.getLocationStart()).thenReturn(null);

        gameMapProvider = new GameMapProvider(configuration, areaFactory);
    }


    @Test
    public void testGet() throws Exception {
        when(areaMapConfig.getLocationStart()).thenReturn(startAreaConfig);

        gameMapProvider = new GameMapProvider(configuration, areaFactory);
        //assertThat(travelHandler.getCurrentLocation()).isEqualTo(location);

    }

}