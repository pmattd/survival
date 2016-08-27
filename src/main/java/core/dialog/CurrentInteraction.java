package core.dialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import core.gamestate.GameStateMachine;
import core.gamestate.states.DialogState;
import core.gamestate.states.LocationState;

import java.util.Optional;

/**
 * Created by Pete on 02/08/2016.
 */
@Singleton
public class CurrentInteraction {

    private Interaction currentInteraction;

    public void setCurrentInteraction(Interaction interaction){
        this.currentInteraction = interaction;
    }

    public OptionList<ExecutableOption> getInteractionOptions(){
        return currentInteraction.getInteractionOptions();
    }
}
