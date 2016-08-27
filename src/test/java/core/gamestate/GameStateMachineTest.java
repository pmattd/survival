package core.gamestate;

import core.gamestate.states.InitialiseState;
import core.gamestate.states.StartState;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Pete on 29/07/2016.
 */
public class GameStateMachineTest {

    @Mock
    InitialiseState initialiseState;
    @Mock
    StartState startState;
    private GameStateMachine gameStateMachine;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gameStateMachine = new GameStateMachine(initialiseState);
    }



}