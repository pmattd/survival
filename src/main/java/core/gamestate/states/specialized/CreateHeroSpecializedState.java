package core.gamestate.states.specialized;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.boundary.options.CategorisedOptions;
import core.boundary.options.CategorisedOptionsBuilderFactory;

import static core.boundary.options.OptionCatagoryEnum.SPECIALIZED_HERO_CREATION;

/**
 * Created by Pete on 24/08/2016.
 */
@Singleton
public class CreateHeroSpecializedState implements SpecializedState {

    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public CreateHeroSpecializedState(CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {

        return categorisedOptionsBuilderFactory.create().buildSpecializedStateOptions(SPECIALIZED_HERO_CREATION);
    }
}
