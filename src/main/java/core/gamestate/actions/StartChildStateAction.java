package core.gamestate.actions;

import core.gamestate.GameStateMachine;
import core.gamestate.states.GameState;

/**
 * Created by Pete on 24/08/2016.
 */
public class StartChildStateAction implements Action{

    private final GameState gameState;
    private final GameStateMachine gameStateMachine;

    public StartChildStateAction(GameState gameState, GameStateMachine gameStateMachine) {
        this.gameState = gameState;
        this.gameStateMachine = gameStateMachine;
    }


    @Override
    public void run() {
        gameStateMachine.setChildState(gameState);
    }
}
