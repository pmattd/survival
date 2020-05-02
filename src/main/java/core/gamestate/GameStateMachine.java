package core.gamestate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.boundary.options.CategorisedOptions;
import core.gamestate.states.GameState;
import core.gamestate.states.InitialiseState;
import org.slf4j.LoggerFactory;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Pete on 19/07/2016.
 */
@Singleton
public class GameStateMachine {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(GameStateMachine.class);

    private Deque<GameState> stateStack;

    @Inject
    public GameStateMachine(InitialiseState initialiseState) {
        stateStack = new ArrayDeque<>();
        stateStack.push(initialiseState);
    }

    public CategorisedOptions getAllOptions(){
        return stateStack.peek().getCurrentOptions();
    }

    public void setState(GameState state) {
        //todo validate transition?
        stateStack.pop();
        stateStack.push(state);
        logger.debug(String.format("state change: %s", state.getClass().getSimpleName()));
    }

    public void revertToParentState() {
        if (stateStack.isEmpty()) {
            throw new InvalidGameStateChangeException("cannot revert to parent no states in stack");
        }
        stateStack.pop();
    }

    public void setChildState(GameState childState) {
        stateStack.push(childState);
    }
}
