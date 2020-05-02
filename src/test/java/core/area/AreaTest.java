package core.area;

import core.area.scavenge.ScavengeLocationAction;
import core.area.travel.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Pete on 01/08/2016.
 */
public class AreaTest {

    @Mock
    Direction direction;
    @Mock
    Location location;
    @Mock
    Location location2;
    @Mock
    ScavengeLocationAction scavengeLocationAction;
    private Area area;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        area = new Area("desc",asList(direction));
        area.setLocations(asList(location, location2));
    }

    @Test
    public void testGetOtherLocations() {
        assertThat(area.getOtherLocations(location)).containsOnly(location2);
    }

    @Test
    public void testGetArrivalLocation() {
        assertThat(area.getArrivalLocation()).isEqualTo(location);
    }


}