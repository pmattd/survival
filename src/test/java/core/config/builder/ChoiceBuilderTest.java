package core.config.builder;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import core.config.xml.narrative.interaction.ChoiceConfig;
import core.config.xml.narrative.interaction.OptionConfig;
import core.config.xml.narrative.interaction.TextConfig;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 30/05/2016.
 */
public class ChoiceBuilderTest {

    ChoiceInteractionFactory choiceInteractionFactory;

    @Mock
    TextFactory textFactory;

    @Mock
    ChoiceConfig choiceConfig;

    @Mock
    InteractionFactory interactionFactory;

    @Mock
    TextConfig textConfigChoice;

    @Mock
    OptionConfig optionConfig;

    @Mock
    TextConfig textConfig;

    @Mock
    DialogOptionsFactory dialogOptionsFactory;

    @Mock
    OptionList<ExecutableOption> optionList;

    @Mock
    InteractionOptionFactory interactionOptionFactory;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        choiceInteractionFactory = new ChoiceInteractionFactory(textFactory, dialogOptionsFactory, interactionOptionFactory);

        when(choiceConfig.getOptions()).thenReturn(asList(optionConfig));
        when(choiceConfig.getText()).thenReturn(textConfigChoice);
        when(textFactory.build(textConfigChoice)).thenReturn("choiceText");
        when(optionConfig.getText()).thenReturn(textConfig);
        when(textFactory.build(textConfig)).thenReturn("optionText");

    }

/*
    @Test
    public void testChoice_options() throws Exception {
        when(optionListBuilder.build(anyList(),anyString())).thenReturn(optionList);
        Interaction interaction = choiceBuilder.build(choiceConfig,interactionBuilder);

        assertThat(interaction.getInteractionOptions()).isEqualTo(optionList);

    }*/


}