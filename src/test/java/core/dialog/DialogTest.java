package core.dialog;

import core.gamestate.GameStateMachine;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 24/07/2016.
 */
public class DialogTest {


    Dialog dialog;

    @Mock
    Interaction interaction;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dialog = new Dialog("id",interaction);
    }



}