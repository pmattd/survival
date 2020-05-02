package core.config.builder;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import core.config.builder.travel.DirectionBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.area.Area;
import core.area.travel.Direction;
import core.area.Location;
import core.area.travel.TravelInterceptor;
import core.config.xml.areas.AreaConfig;
import core.config.xml.areas.DirectionConfig;
import core.config.xml.narrative.interaction.TextConfig;

/**
 * Created by Pete on 07/06/2016.
 */
public class DirectionBuilderTest {


    DirectionBuilder directionBuilder;

    @Mock
    TextFactory textFactory;

    @Mock
    AreaFactory areaFactory;

    @Mock
    private DirectionConfig directionConfig;

    @Mock
    private TextConfig text;

    @Mock
    private Area area;

    @Mock
    private AreaConfig areaConfig;

    @Mock
    Location location;


    @Mock
    TravelInterceptor travelInterceptor;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        directionBuilder = new DirectionBuilder(textFactory, travelInterceptor);
    }

    @Test
    public void testBuild() throws Exception {
        when(directionConfig.getText()).thenReturn(text);
        when(textFactory.build(text)).thenReturn("hello");
        when(directionConfig.getArea()).thenReturn(areaConfig);
        when(areaFactory.build(areaConfig)).thenReturn(area);
        when(area.getArrivalLocation()).thenReturn(location);
        when(travelInterceptor.intercept(any(Direction.class))).thenReturn(Optional.empty());

        Direction direction = directionBuilder.build(directionConfig, areaFactory);
        assertThat(direction.getText()).isEqualTo("hello");

        assertThat(direction.travel()).isEqualTo(location);


    }
}