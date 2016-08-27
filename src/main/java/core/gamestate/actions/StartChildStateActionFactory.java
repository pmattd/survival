package core.gamestate.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.gamestate.GameStateMachine;
import core.gamestate.states.specialized.SpecializedState;

/**
 * Created by Pete on 24/08/2016.
 */
@Singleton
public class StartChildStateActionFactory {

    private final GameStateMachine gameStateMachine;

    @Inject
    public StartChildStateActionFactory(GameStateMachine gameStateMachine) {
        this.gameStateMachine = gameStateMachine;
    }

    public StartChildStateAction build(SpecializedState specializedState){
        return new StartChildStateAction(specializedState,gameStateMachine);
    }

}
