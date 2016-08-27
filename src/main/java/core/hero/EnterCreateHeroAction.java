package core.hero;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.specialized.CreateHeroSpecializedState;

/**
 * Created by Pete on 01/08/2016.
 */
@Singleton
public class EnterCreateHeroAction implements Action {

    private final GameStateMachine gameStateMachine;
    private final CreateHeroSpecializedState createHeroSpecializedState;

    @Inject
    public EnterCreateHeroAction(GameStateMachine gameStateMachine, CreateHeroSpecializedState createHeroSpecializedState) {
        this.gameStateMachine = gameStateMachine;
        this.createHeroSpecializedState = createHeroSpecializedState;
    }

    @Override
    public void run() {
        gameStateMachine.setState(createHeroSpecializedState);
    }
}
