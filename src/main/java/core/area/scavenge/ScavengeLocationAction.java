package core.area.scavenge;

import core.area.Location;
import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.specialized.InventorySpecializedState;
import core.hero.Inventory;

/**
 * Created by Pete on 29/07/2016.
 */
public class ScavengeLocationAction implements Action {

    private final GameStateMachine gameStateMachine;
    private final Location location;
    private final Inventory inventory;

    private final InventorySpecializedState inventorySpecializedState;

    protected ScavengeLocationAction(GameStateMachine gameStateMachine, Location location, Inventory inventory, InventorySpecializedState inventorySpecializedState) {
        this.gameStateMachine = gameStateMachine;
        this.location = location;
        this.inventory = inventory;
        this.inventorySpecializedState = inventorySpecializedState;

    }

    @Override
    public void run() {
        //todo possible dialog(event) state (note: should all scavenge location result in dialog for simplicity


        //always start a dialog, in the case there is no dialog referce then a simple dialog should have been created
        //with only one dialog starting the inventory state.

        //location.getScavenge -> returns next state? either inventorySpecializedState Or the Dialog to be run

        gameStateMachine.setState(inventorySpecializedState);
        inventory.setFoundSupplyCache(location.scavenge());


        //todo this shouldn't happen here and the party shouldn't create an action
        //party.transferFoundSuppliesToInventory();


    }


}
