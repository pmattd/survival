package core.gamestate.states;

import com.google.inject.Inject;
import core.boundary.options.*;
import core.dialog.CurrentInteraction;

/**
 * Created by Pete on 21/07/2016.
 */
public class DialogState implements GameState {

    private final CurrentInteraction currentInteraction;
    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public DialogState(CurrentInteraction currentInteraction, CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.currentInteraction = currentInteraction;
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {

        return categorisedOptionsBuilderFactory.create().withOptions(
                OptionCatagoryEnum.DIALOG,
                currentInteraction.getInteractionOptions()).build();

    }


}
