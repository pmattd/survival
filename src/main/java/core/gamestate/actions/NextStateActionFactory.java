package core.gamestate.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.gamestate.GameStateMachine;
import core.gamestate.states.GameState;

/**
 * Created by Pete on 25/08/2016.
 */
@Singleton
public class NextStateActionFactory {

    private final GameStateMachine gameStateMachine;


    @Inject
    public NextStateActionFactory(GameStateMachine gameStateMachine) {
        this.gameStateMachine = gameStateMachine;
    }

    public NextStateAction build(GameState nextState){
        return new NextStateAction(gameStateMachine,nextState);
    }
}
