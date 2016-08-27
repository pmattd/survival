package core.config.builder;

import static java.util.Arrays.asList;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.boundary.options.ExecutableOption;
import core.config.xml.narrative.interaction.InteractionConfig;
import core.config.xml.narrative.interaction.SimpleTextConfig;
import core.config.xml.narrative.interaction.TextConfig;
import core.dialog.Interaction;
import core.dialog.InteractionOption;

/**
 * Created by Pete on 30/05/2016.
 */
public class SimpleTextInteractionFactoryTest {

    SimpleTextInteractionBuilder simpleTextInteractionBuilder;

    @Mock
    TextFactory textFactory;

    @Mock
    SimpleTextConfig simpleTextConfig;

    @Mock
    InteractionConfig interactionConfig;

    @Mock
    Interaction interaction;

    @Mock
    TextConfig textConfig;

    @Mock
    InteractionFactory interactionFactory;

    @Mock
    DialogOptionsFactory dialogOptionsFactory;

    @Mock
    InteractionOptionFactory interactionOptionFactory;

    @Mock
    InteractionOption interactionOption;

    @Mock
    ExecutableOption executableOption;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        simpleTextInteractionBuilder = new SimpleTextInteractionBuilder(textFactory, dialogOptionsFactory, interactionOptionFactory);
    }

    @Test
    public void testBuild() throws Exception {


        when(simpleTextConfig.getText()).thenReturn(textConfig);
        when(simpleTextConfig.getNextInteraction()).thenReturn(interactionConfig);


        List<InteractionOption> interactionOptions = asList(interactionOption);

        when(interactionOptionFactory.build(interactionConfig, interactionFactory)).thenReturn(interactionOptions);
        when(textFactory.build(textConfig)).thenReturn("simpleText");
        List<ExecutableOption> executableOptions = asList(executableOption);
        when(dialogOptionsFactory.build(interactionOptions)).thenReturn(executableOptions);

        Interaction interaction = simpleTextInteractionBuilder.build(simpleTextConfig, interactionFactory);


        assertThat(interaction.getInteractionOptions().getOptions()).isEqualTo(executableOptions);
    }


}