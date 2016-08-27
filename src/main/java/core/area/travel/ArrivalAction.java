package core.area.travel;

import core.dialog.CurrentInteraction;
import core.dialog.Dialog;
import core.dialog.Interaction;
import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.DialogState;
import core.gamestate.states.LocationState;

import java.util.Optional;

/**
 * Created by Pete on 02/08/2016.
 */
public class ArrivalAction implements Action {
    private final CurrentInteraction currentInteraction;
    private final Optional<Interaction> arrivalEvent;
    private final GameStateMachine gameStateMachine;
    private final LocationState locationState;
    private final DialogState dialogState;

    public ArrivalAction(CurrentInteraction currentInteraction,
                         Optional<Interaction> arrivalEvent,
                         GameStateMachine gameStateMachine,
                         LocationState locationState,
                         DialogState dialogState) {
        this.currentInteraction = currentInteraction;
        this.arrivalEvent = arrivalEvent;
        this.gameStateMachine = gameStateMachine;
        this.locationState = locationState;
        this.dialogState = dialogState;
    }


    @Override
    public void run() {
        //todo if we can reduce this to one state then its better no?
        gameStateMachine.setState(locationState);
        if(arrivalEvent.isPresent()){
            currentInteraction.setCurrentInteraction(arrivalEvent.get());
            gameStateMachine.setState(dialogState);
        }
    }
}
