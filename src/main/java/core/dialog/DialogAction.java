package core.dialog;

import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.LocationState;

/**
 * Created by Pete on 30/07/2016.
 */
public class DialogAction implements Action {
    private final CurrentInteraction currentInteraction;
    private final InteractionOption interactionOption;
    private final GameStateMachine gameStateMachine;
    private final LocationState locationState;

    public DialogAction(CurrentInteraction currentInteraction,
                        InteractionOption interactionOption,
                        GameStateMachine gameStateMachine,
                        LocationState locationState){

        this.currentInteraction = currentInteraction;
        this.interactionOption = interactionOption;
        this.gameStateMachine = gameStateMachine;
        this.locationState = locationState;
    }

    @Override
    public void run() {
        currentInteraction.setCurrentInteraction(interactionOption.getNextInteraction());

        if(interactionOption.getNextInteraction().isFinal()){
            gameStateMachine.setState(locationState);
        }

    }
}
