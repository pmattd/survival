package core.gamestate;

import static com.google.common.collect.Maps.newHashMap;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.boundary.options.CategorisedOptions;
import core.gamestate.states.GameState;

/**
 * Created by Pete on 19/07/2016.
 */
@Singleton
public class GameStateMachine {

    private GameState gameState;

    //todo implement a stack of states
    private GameState childState;

    @Inject
    public GameStateMachine(){
        //todo make this no state
        this.gameState = null;
        this.childState = null;
    }

    public CategorisedOptions getAllOptions(){
        if(childState != null){
            return childState.getCurrentOptions();
        }
        return gameState.getCurrentOptions();
    }

    public void setState(GameState state) {
        //todo validate transition?
        this.gameState = state;
    }

    public void revertToParentState() {
        this.childState = null;
    }

    public void setChildState(GameState childState) {
        this.childState = childState;
    }
}
