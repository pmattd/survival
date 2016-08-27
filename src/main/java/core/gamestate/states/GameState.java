package core.gamestate.states;

import core.boundary.options.CategorisedOptions;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionCategory;
import core.boundary.options.OptionList;

import java.util.HashMap;

/**
 * Created by Pete on 21/07/2016.
 */
public interface GameState {

    CategorisedOptions getCurrentOptions();
}
