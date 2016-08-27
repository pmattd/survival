package core.gamestate.states;

import com.google.inject.Inject;
import core.boundary.options.*;

import java.util.HashMap;

/**
 * Created by Pete on 10/08/2016.
 */
public class TravelState implements GameState {

    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public TravelState(CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {
        return categorisedOptionsBuilderFactory.create().build();
    }
}
