package core.area;

import core.area.scavenge.ScavengeLocationAction;
import core.area.travel.Direction;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Pete on 01/08/2016.
 */
public class AreaTest {

    private Area area;

    @Mock
    Direction direction;


    @Mock
    Location location;

    @Mock
    Location location2;

    @Mock
    ScavengeLocationAction scavengeLocationAction;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        area = new Area("desc",asList(direction));

    }


}