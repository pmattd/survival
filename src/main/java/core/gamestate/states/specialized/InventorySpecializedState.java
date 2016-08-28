package core.gamestate.states.specialized;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.boundary.options.CategorisedOptions;
import core.boundary.options.CategorisedOptionsBuilderFactory;

import static core.boundary.options.OptionCatagoryEnum.SPECIALIZED_INVENTORY;

/**
 * Created by Pete on 27/08/2016.
 */
@Singleton
public class InventorySpecializedState implements SpecializedState {
    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public InventorySpecializedState(CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {
        return categorisedOptionsBuilderFactory.create().buildSpecializedStateOptions(SPECIALIZED_INVENTORY);
    }
}
