package core.config.builder;

import core.config.xml.narrative.DialogConfig;
import core.config.xml.narrative.interaction.InteractionConfig;
import core.dialog.Dialog;
import core.dialog.Interaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 21/05/2016.
 */
public class DialogFactoryTest {
    DialogFactory builder;

    @Mock
    InteractionFactory interactionFactory;

    @Mock
    DialogConfig dialogConfig;


    @Mock
    InteractionConfig interactionConfig;

    @Mock
    Interaction interaction;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(dialogConfig.getId()).thenReturn("id");
        when(dialogConfig.getStart()).thenReturn(interactionConfig);

        builder = new DialogFactory(interactionFactory);
        when(interactionFactory.build(interactionConfig)).thenReturn(interaction);
    }

    @Test
    public void build(){

        Dialog dialog = builder.build(dialogConfig);
        assertThat(dialog.getFirstInteraction()).isEqualTo(interaction);
    }

}