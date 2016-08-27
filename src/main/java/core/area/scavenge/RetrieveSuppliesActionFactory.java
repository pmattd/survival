package core.area.scavenge;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.area.supplies.SupplyCache;
import core.gamestate.GameStateMachine;
import core.gamestate.states.LocationState;
import core.hero.Inventory;

/**
 * Created by Pete on 30/07/2016.
 */
@Singleton
public class RetrieveSuppliesActionFactory {

    private final GameStateMachine gameStateMachine;
    private final LocationState locationState;

    @Inject
    public RetrieveSuppliesActionFactory(GameStateMachine gameStateMachine, LocationState locationState) {
        this.gameStateMachine = gameStateMachine;
        this.locationState = locationState;
    }

    public RetrieveSuppliesAction build(Inventory inventory, SupplyCache supplyCache){
        return new RetrieveSuppliesAction(gameStateMachine, inventory, supplyCache, locationState);
    }
}
