package core.area.scavenge;

import core.area.supplies.Supplies;
import core.area.supplies.SupplyCache;
import core.gamestate.GameStateMachine;
import core.gamestate.states.LocationState;
import core.hero.Inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 01/08/2016.
 */
public class RetrieveSuppliesActionTest {

    RetrieveSuppliesAction retrieveSuppliesAction;

    @Mock
    GameStateMachine gameStateMachine;

    @Mock
    Inventory inventory;

    @Mock
    SupplyCache supplyCache;

    @Mock
    Supplies supplies;

    @Mock
    LocationState locationState;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        retrieveSuppliesAction = new RetrieveSuppliesAction(gameStateMachine,inventory,supplyCache, locationState);
    }

    @Test
    public void testRun() throws Exception {
        when(supplyCache.getAndRemoveSupplies()).thenReturn(supplies);
        retrieveSuppliesAction.run();
        verify(gameStateMachine,times(1)).setState(locationState);
    }
}