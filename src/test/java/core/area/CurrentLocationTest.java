package core.area;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Pete on 29/07/2016.
 */
public class CurrentLocationTest {

    @Mock
    Location location;
    @Mock
    LocationDescription locationDescription;
    private CurrentLocation currentLocation;
    private CurrentLocation currentLocation;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        currentLocation = new CurrentLocation();
    }

    @Test
    public void testGetLocationDescription() throws Exception {
        currentLocation.setLocation(location);
        when(location.getDescription()).thenReturn(locationDescription);

        LocationDescription locationDescription2 = currentLocation.getLocationDescription();
        assertThat(locationDescription2).isEqualTo(locationDescription);
        verify(location, times(1)).arrive();
    }
}