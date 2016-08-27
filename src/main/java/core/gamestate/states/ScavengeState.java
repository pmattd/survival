package core.gamestate.states;

import com.google.inject.Inject;
import core.area.scavenge.RetrieveSuppliesActionFactory;
import core.area.supplies.SupplyCache;
import core.boundary.options.*;
import core.gamestate.actions.Action;
import core.hero.Inventory;
import core.hero.Party;

import java.util.HashMap;

import static com.google.inject.internal.util.$Maps.newHashMap;
import static core.boundary.options.OptionCatagoryEnum.*;
import static java.util.Arrays.asList;

/**
 * Created by Pete on 21/07/2016.
 */

public class ScavengeState implements GameState {

    private final Party party;
    private final RetrieveSuppliesActionFactory retrieveSuppliesActionFactory;
    private final Inventory inventory;
    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public ScavengeState(Party party, RetrieveSuppliesActionFactory retrieveSuppliesActionFactory, Inventory inventory, CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.party = party;
        this.retrieveSuppliesActionFactory = retrieveSuppliesActionFactory;
        this.inventory = inventory;
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {

        //todo should found supply cache be under party or inventory or by itself?
        //implement another option for inventory management

        SupplyCache supplyCache = party.getFoundSupplyCache();
        Action action1 = retrieveSuppliesActionFactory.build(inventory, supplyCache);

        ExecutableOption option = new ExecutableOption("take all", action1);
        OptionList<ExecutableOption> inventoryTransferOptions = new OptionList<>(supplyCache.getScavengeText(), asList(option));

        return categorisedOptionsBuilderFactory.create().withOptions(SCAVENGE_COLLECT, inventoryTransferOptions).build();


    }
}
