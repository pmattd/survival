package core.gamestate.states;

import core.boundary.options.CategorisedOptions;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Created by Pete on 10/08/2016.
 */
public class CombatState implements GameState{



    @Override
    public CategorisedOptions getCurrentOptions() {
        return new CategorisedOptions(newHashMap());
    }
}
