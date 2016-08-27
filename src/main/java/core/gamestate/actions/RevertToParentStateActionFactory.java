package core.gamestate.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.gamestate.GameStateMachine;

/**
 * Created by Pete on 23/08/2016.
 */
@Singleton
public class RevertToParentStateActionFactory {

    private final GameStateMachine gameStateMachine;

    @Inject
    public RevertToParentStateActionFactory(GameStateMachine gameStateMachine) {
        this.gameStateMachine = gameStateMachine;
    }

    public RevertToParentStateAction build(){
        return new RevertToParentStateAction(gameStateMachine);
    }
}
