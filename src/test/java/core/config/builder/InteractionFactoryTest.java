package core.config.builder;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.config.xml.narrative.interaction.ChoiceConfig;
import core.config.xml.narrative.interaction.CombatConfig;
import core.config.xml.narrative.interaction.InteractionConfig;
import core.config.xml.narrative.interaction.SimpleTextConfig;
import core.dialog.BasicInteraction;
import core.dialog.Interaction;
import core.dialog.NoInteraction;


/**
 * Created by Pete on 26/05/2016.
 */
public class InteractionFactoryTest {

    InteractionFactory interactionFactory;

    @Mock
    InteractionConfig interactionConfig;

    @Mock
    ChoiceConfig choiceConfig;

    @Mock
    SimpleTextConfig simpleTextConfig;


    @Mock
    SimpleTextInteractionBuilder simpleTextInteractionBuilder;

    @Mock
    ChoiceInteractionFactory choiceInteractionFactory;

    @Mock
    BasicInteraction basicInteraction;

    @Mock
    CombatInteractionFactory combatInteractionFactory;

    @Mock
    private CombatConfig combatConfig;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        interactionFactory = new InteractionFactory(simpleTextInteractionBuilder, choiceInteractionFactory, new NoInteraction(), combatInteractionFactory);
    }

    @Test
    public void testNoInteraction() throws Exception {
        Interaction interaction = interactionFactory.build(null);
        assertThat(interaction).isInstanceOf(NoInteraction.class);

    }

    @Test
    public void testBuildEmptyInteraction() throws Exception {
        Assertions.assertThrows(ConfigBuildException.class,() ->{
        interactionFactory.build(interactionConfig);});
    }

    @Test
    public void testChoice_created() throws Exception {
        when(interactionConfig.getChoiceConfig()).thenReturn(choiceConfig);
        when(choiceInteractionFactory.build(choiceConfig, interactionFactory)).thenReturn(basicInteraction);

        Interaction interaction = interactionFactory.build(interactionConfig);
        assertThat(interaction).isEqualTo(basicInteraction);
    }


    @Test
    public void testSimpleText_created() throws Exception {
        when(interactionConfig.getSimpleTextConfig()).thenReturn(simpleTextConfig);
        when(simpleTextInteractionBuilder.build(simpleTextConfig, interactionFactory)).thenReturn(basicInteraction);
        Interaction interaction = interactionFactory.build(interactionConfig);
        assertThat(interaction).isEqualTo(basicInteraction);
    }


    @Test
    public void testCombat_created() throws Exception {
        when(interactionConfig.getCombatConfig()).thenReturn(combatConfig);
        when(combatInteractionFactory.build(combatConfig)).thenReturn(basicInteraction);
        Interaction interaction = interactionFactory.build(interactionConfig);
        assertThat(interaction).isEqualTo(basicInteraction);
    }



}