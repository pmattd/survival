package core.dialog;

import core.gamestate.GameStateMachine;
import core.gamestate.states.LocationState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Created by Pete on 16/08/2016.
 */
public class DialogActionTest {

    DialogAction dialogAction;

    @Mock
    GameStateMachine gameStateMachine;

    @Mock
    CurrentInteraction currentInteraction;

    @Mock
    InteractionOption interactionOption;

    @Mock
    Interaction interaction;

    @Mock
    LocationState locationState;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dialogAction = new DialogAction(currentInteraction,interactionOption, gameStateMachine, locationState);
    }

    @Test
    public void testRun() throws Exception {
        when(interactionOption.getNextInteraction()).thenReturn(interaction);
        when(interaction.isFinal()).thenReturn(true);
        dialogAction.run();
    }
}