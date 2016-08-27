package core.gamestate.states;

import com.google.inject.Inject;
import core.boundary.options.CategorisedOptions;
import core.boundary.options.CategorisedOptionsBuilderFactory;
import core.boundary.options.OptionCatagoryEnum;
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

        //todo quitAction could be injected

        Action startCreateHeroAction = nextStateActionFactory.build(createHeroSpecializedState);
        return categorisedOptionsBuilderFactory.create()
                .withSingleOptionCategory(
                        OptionCatagoryEnum.CREATEHERO,
                        "enter the create hero action",
                        startCreateHeroAction)
                .withSingleOptionCategory(
                        OptionCatagoryEnum.QUIT,
                        "quit",
                        new QuitAction()
                )
                .build();


    }
}
