package core.area.scavenge;

import core.area.supplies.Supplies;
import core.area.supplies.SupplyCache;
import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.LocationState;
import core.hero.Inventory;

/**
 * Created by Pete on 30/07/2016.
 */
public class RetrieveSuppliesAction implements Action{
    private final GameStateMachine gameStateMachine;
    private final Inventory inventory;
    private final SupplyCache supplyCache;
    private final LocationState locationState;

    public RetrieveSuppliesAction(GameStateMachine gameStateMachine, Inventory inventory, SupplyCache supplyCache, LocationState locationState) {
        this.gameStateMachine = gameStateMachine;
        this.inventory = inventory;
        this.supplyCache = supplyCache;
        this.locationState = locationState;
    }

    @Override
    public void run() {
        Supplies supplies = supplyCache.getAndRemoveSupplies();
        inventory.addFood(supplies.getFood());
        gameStateMachine.setState(locationState);
    }
}
