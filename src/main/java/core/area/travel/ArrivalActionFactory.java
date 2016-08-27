package core.area.travel;

import com.google.inject.Inject;
import core.dialog.CurrentInteraction;
import core.dialog.Dialog;
import core.dialog.Interaction;
import core.gamestate.GameStateMachine;
import core.gamestate.states.DialogState;
import core.gamestate.states.LocationState;

import java.util.Optional;

/**
 * Created by Pete on 02/08/2016.
 */
public class ArrivalActionFactory {

    private final CurrentInteraction currentInteraction;
    private final GameStateMachine gameStateMachine;
    private final LocationState locationState;
    private final DialogState dialogState;


    @Inject
    private ArrivalActionFactory(CurrentInteraction currentInteraction, GameStateMachine gameStateMachine, LocationState locationState, DialogState dialogState) {
        this.currentInteraction = currentInteraction;
        this.gameStateMachine = gameStateMachine;
        this.locationState = locationState;
        this.dialogState = dialogState;
    }

    public ArrivalAction build(Optional<Interaction> arrivalEvent){
        return new ArrivalAction(currentInteraction, arrivalEvent, gameStateMachine, locationState, dialogState);
    }
}
