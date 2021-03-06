package core.config.builder;

import core.area.Area;
import core.area.travel.Direction;
import core.area.travel.TravelActionFactory;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import core.config.builder.travel.TravelOptionsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 08/08/2016.
 */
public class TravelOptionsFactoryTest {

    @Mock
    TravelActionFactory travelActionFactory;
    @Mock
    Area area;
    @Mock
    Direction direction;
    private TravelOptionsFactory travelOptionsFactory;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        travelOptionsFactory = new TravelOptionsFactory(travelActionFactory);
    }


	@Test
	public void testBuildTravelOptions(){
		when(area.getDirections()).thenReturn(Arrays.asList(direction));
		when(direction.getText()).thenReturn("directionText");
		OptionList<ExecutableOption> options = travelOptionsFactory.buildTravelOptions(area);

        //assertThat(options.getHeader().get()).isEqualTo("");
        assertThat(options.getOptions()).hasSize(1);
        assertThat(options.getOptions().get(0).getDescription()).isEqualTo("directionText");
	}
}