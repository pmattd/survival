package core.area;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by Pete on 02/08/2016.
 */
public class NoLocationTest {

    private NoLocation noLocation;

    @BeforeEach
    public void setUp() throws Exception {
        noLocation = new NoLocation();
    }

    @Test
    public void testGetTitle() throws Exception {
        assertThat(noLocation.getTitle()).isEmpty();
    }

    @Test
    public void testGetDescription() throws Exception {
        assertThat(noLocation.getDescription().getAreaDescription()).isEmpty();
        assertThat(noLocation.getDescription().getLocationDescription()).isEmpty();
    }

    @Test
    public void testScavenge() throws Exception {
        assertThat(noLocation.scavenge()).isNull();
    }

    @Test
    public void testGetTravelOptions() throws Exception {
        assertThat(noLocation.getTravelOptions().getOptions()).isEmpty();
        assertThat(noLocation.getTravelOptions().getHeader().isPresent()).isFalse();
    }

    @Test
    public void testGetScavengeOptions() throws Exception {
        assertThat(noLocation.getScavengeOptions().getHeader().isPresent()).isFalse();
        assertThat(noLocation.getScavengeOptions().getOptions()).isEmpty();
    }

    @Test
    public void testGetArrivalAction() throws Exception {

    }
}