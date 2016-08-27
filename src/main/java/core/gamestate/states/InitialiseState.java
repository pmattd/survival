package core.gamestate.states;

import com.google.inject.Inject;
import core.boundary.options.CategorisedOptions;
import core.boundary.options.CategorisedOptionsBuilderFactory;

/**
 * Created by Pete on 27/08/2016.
 */
public class InitialiseState implements GameState {
    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public InitialiseState(CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {
        return categorisedOptionsBuilderFactory.create().build();
    }
}
