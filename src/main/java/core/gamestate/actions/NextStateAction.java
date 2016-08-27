package core.gamestate.actions;

import com.google.inject.Inject;
import core.gamestate.GameStateMachine;
import core.gamestate.states.GameState;

/**
 * Created by Pete on 25/08/2016.
 */
public class NextStateAction implements Action {

    private final GameStateMachine gameStateMachine;
    private final GameState nextState;


    public NextStateAction(GameStateMachine gameStateMachine, GameState nextState) {
        this.gameStateMachine = gameStateMachine;
        this.nextState = nextState;
    }

    @Override
    public void run() {
        gameStateMachine.setState(nextState);
    }
}
