package core.config.builder;

import com.google.inject.Inject;
import core.boundary.options.ExecutableOption;
import core.dialog.CurrentInteraction;
import core.dialog.DialogAction;
import core.dialog.InteractionOption;
import core.gamestate.GameStateMachine;
import core.gamestate.states.LocationState;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Pete on 02/08/2016.
 */
public class DialogOptionsFactory {
    private final CurrentInteraction currentInteraction;
    private final GameStateMachine gameStateMachine;
    private final LocationState locationState;

    @Inject
    public DialogOptionsFactory(CurrentInteraction currentInteraction, GameStateMachine gameStateMachine, LocationState locationState) {
        this.currentInteraction = currentInteraction;
        this.gameStateMachine = gameStateMachine;
        this.locationState = locationState;
    }


    public List<ExecutableOption> build(List<InteractionOption> interactionOptions){
        return interactionOptions.stream()
                        .map(i -> getDialogExecutableOptions(i))
                        .collect(Collectors.toList());
    }


    private ExecutableOption getDialogExecutableOptions(InteractionOption interactionOption) {
        return new ExecutableOption(interactionOption.getText(), build(interactionOption));
    }

    private DialogAction build(InteractionOption interactionOption){
        return new DialogAction(currentInteraction,interactionOption, gameStateMachine, locationState);
    }
}
