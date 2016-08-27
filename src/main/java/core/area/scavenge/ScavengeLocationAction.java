package core.area.scavenge;

import core.area.Location;
import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.ScavengeState;
import core.hero.Party;

/**
 * Created by Pete on 29/07/2016.
 */
public class ScavengeLocationAction implements Action {

    private final GameStateMachine gameStateMachine;
    private final Location location;
    private final Party party;
    private final ScavengeState scavengeState;

    protected ScavengeLocationAction(GameStateMachine gameStateMachine, Location location, Party party, ScavengeState scavengeState) {
        this.gameStateMachine = gameStateMachine;
        this.location = location;
        this.party = party;
        this.scavengeState = scavengeState;
    }

    @Override
    public void run() {
        //todo possible dialog(event) state (note: should all scavenge location result in dialog for simplicity
        //because after dialog - going to have to come back to scavenge unless dialog.

        gameStateMachine.setState(scavengeState);
        party.setFoundSupplyCache(location.scavenge());

        //todo this shouldn't happen here and the party shouldn't create an action
        //party.transferFoundSuppliesToInventory();


    }


}
