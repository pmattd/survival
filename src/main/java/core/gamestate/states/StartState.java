package core.gamestate.states;

import com.google.inject.Inject;
import core.boundary.options.*;
import core.gamestate.actions.Action;
import core.gamestate.actions.NextStateActionFactory;
import core.gamestate.actions.QuitAction;
import core.gamestate.states.specialized.CreateHeroSpecializedState;

/**
 * Created by Pete on 21/07/2016.
 */
public class StartState implements GameState {

    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;
    private final CreateHeroSpecializedState createHeroSpecializedState;
    private final NextStateActionFactory nextStateActionFactory;


    @Inject
    public StartState(CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory,
                      CreateHeroSpecializedState createHeroSpecializedState,
                      NextStateActionFactory nextStateActionFactory) {
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
        this.nextStateActionFactory = nextStateActionFactory;
        this.createHeroSpecializedState = createHeroSpecializedState;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {

        //todo could be an action injected
        //quitAction could be injected

        Action startCreateHeroAction = nextStateActionFactory.build(createHeroSpecializedState);
        return categorisedOptionsBuilderFactory.create()
                //todo use singleOptionBuilder

                .withOptions(
                        OptionCatagoryEnum.CREATEHERO,
                        new OptionList.Builder().withOption("enter the create hero action",startCreateHeroAction).build())
                .withOptions(
                        OptionCatagoryEnum.QUIT,
                        new OptionList.Builder().withOption("quit",new QuitAction()).build())
                .build();


    }
}
