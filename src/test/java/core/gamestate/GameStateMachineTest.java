package core.gamestate;

import core.boundary.options.CategorisedOptions;
import core.gamestate.states.DialogState;
import core.gamestate.states.InitialiseState;
import core.gamestate.states.StartState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.plugin.dom.exception.InvalidStateException;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 29/07/2016.
 */
public class GameStateMachineTest {

    @Mock
    InitialiseState initialiseState;

    @Mock
    StartState startState;


    @Mock
    DialogState dialogState;


    @Mock
    CategorisedOptions initialiseStateOptions;


    @Mock
    CategorisedOptions startStateOptions;


    @Mock
    CategorisedOptions dialogStateOptions;


    private GameStateMachine gameStateMachine;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gameStateMachine = new GameStateMachine(initialiseState);
        when(initialiseState.getCurrentOptions()).thenReturn(initialiseStateOptions);
        when(startState.getCurrentOptions()).thenReturn(startStateOptions);
        when(dialogState.getCurrentOptions()).thenReturn(dialogStateOptions);
    }

    @Test
    public void testConstruct() {
        assertThat(gameStateMachine.getAllOptions()).isEqualTo(initialiseStateOptions);
    }

    @Test
    public void testSetState() {
        gameStateMachine.setState(startState);
        assertThat(gameStateMachine.getAllOptions()).isEqualTo(startStateOptions);
    }


    @Test
    public void testSetChildState() {
        gameStateMachine.setChildState(startState);
        assertThat(gameStateMachine.getAllOptions()).isEqualTo(startStateOptions);
    }


    @Test
    public void testRevertToParentState() {
        gameStateMachine.setChildState(startState);
        gameStateMachine.revertToParentState();
        assertThat(gameStateMachine.getAllOptions()).isEqualTo(initialiseStateOptions);
    }


    @Test(expected = InvalidStateException.class)
    public void testRevertToParentStateNoParentStateThrowsException() {
        gameStateMachine.revertToParentState();
        gameStateMachine.revertToParentState();
    }





}