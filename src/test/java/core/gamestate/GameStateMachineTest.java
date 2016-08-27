package core.gamestate;

import static org.fest.assertions.Assertions.assertThat;

import core.gamestate.states.StartState;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Pete on 29/07/2016.
 */
public class GameStateMachineTest {

    GameStateMachine gameStateMachine;

    @Mock
    StartState startState;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gameStateMachine = new GameStateMachine();
    }



}