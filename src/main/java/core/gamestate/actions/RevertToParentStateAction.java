package core.gamestate.actions;

import core.gamestate.GameStateMachine;
import core.gamestate.states.GameState;

/**
 * Created by Pete on 23/08/2016.
 */
public class RevertToParentStateAction implements Action {

    private final GameStateMachine gameStateMachine;

    public RevertToParentStateAction(GameStateMachine gameStateMachine) {
        this.gameStateMachine = gameStateMachine;
    }

    @Override
    public void run() {
        gameStateMachine.revertToParentState();
    }
}
