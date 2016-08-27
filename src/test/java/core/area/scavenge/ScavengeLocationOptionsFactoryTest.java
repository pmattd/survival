package core.area.scavenge;

import core.area.Location;
import core.boundary.options.ExecutableOption;
import core.gamestate.GameStateMachine;
import core.gamestate.states.ScavengeState;
import core.hero.Party;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 19/08/2016.
 */
public class ScavengeLocationOptionsFactoryTest {
    ScavengeLocationOptionsFactory scavengeLocationOptionsFactory;

    @Mock
    GameStateMachine gameStateMachine;

    @Mock
    Party party;

    @Mock
    ScavengeState scavengeState;

    @Mock
    private Location location;

    @Mock
    private Location location2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        scavengeLocationOptionsFactory = new ScavengeLocationOptionsFactory(gameStateMachine, party,scavengeState);
    }


    @Test
    public void testBuild() throws Exception {
        when(location.getTitle()).thenReturn("location1");
        when(location2.getTitle()).thenReturn("location2");
        List<ExecutableOption> options = scavengeLocationOptionsFactory.build(asList(location,location2));

        assertThat(options).hasSize(2);
        assertThat(options.get(0).getDescription()).isEqualToIgnoringCase("location1");
    }
}