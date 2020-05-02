package core.area.scavenge;

import core.area.Location;
import core.boundary.options.ExecutableOption;
import core.gamestate.GameStateMachine;
import core.gamestate.states.specialized.InventorySpecializedState;
import core.hero.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    Inventory inventory;

    @Mock
    InventorySpecializedState inventorySpecializedState;

    @Mock
    private Location location;

    @Mock
    private Location location2;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        scavengeLocationOptionsFactory = new ScavengeLocationOptionsFactory(gameStateMachine, inventorySpecializedState, inventory);
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