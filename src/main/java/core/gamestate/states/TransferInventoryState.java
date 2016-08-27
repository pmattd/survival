package core.gamestate.states;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.boundary.options.*;
import core.gamestate.actions.RevertToParentStateActionFactory;

import java.util.HashMap;
import java.util.List;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.inject.internal.util.$Lists.newArrayList;

/**
 * Created by Pete on 23/08/2016.
 */
@Singleton
public class TransferInventoryState implements  GameState {

    private final RevertToParentStateActionFactory revertToParentStateActionFactory;
    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public TransferInventoryState(RevertToParentStateActionFactory revertToParentStateActionFactory, CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.revertToParentStateActionFactory = revertToParentStateActionFactory;
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {


        //todo clean up this can be injected and finish the class

        HashMap<OptionCategory, OptionList<ExecutableOption>> options = newHashMap();

        ExecutableOption option = new ExecutableOption("finished", revertToParentStateActionFactory.build());

        List<ExecutableOption> finishSubStateOptions = newArrayList(option);
        OptionList<ExecutableOption> optionList = new OptionList<>("", finishSubStateOptions);



        //optionHashMapBuilder.addOptions(OptionCatagoryEnum.FINISH_SUB_STATE,optionList,options);

        return null;
    }
}
