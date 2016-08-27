package main.providers;

import static java.util.Arrays.asList;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.config.builder.DialogFactory;
import core.config.xml.Configuration;
import core.config.xml.narrative.DialogConfig;
import core.config.xml.narrative.NarrativeConfig;
import core.dialog.Dialog;
import core.dialog.DialogStore;
import core.dialog.Interaction;

/**
 * Created by Pete on 21/05/2016.
 */
public class DialogStoreProviderTest {


    DialogStoreProvider dialogStoreProvider;

    @Mock
    DialogFactory dialogFactory;

    @Mock
    Configuration configuration;

    @Mock
    NarrativeConfig narrativeConfig;

    @Mock
    DialogConfig dialogConfig;

    @Mock
    Dialog dialog;

    @Mock
    Interaction interaction;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        dialogStoreProvider = new DialogStoreProvider(dialogFactory, configuration);
    }

    @Test
    public void testBuildingDialogs(){

        when(configuration.getNarrativeConfig()).thenReturn(narrativeConfig);
        when(narrativeConfig.getDialogs()).thenReturn(asList(dialogConfig));
        when(dialogFactory.build(dialogConfig)).thenReturn(dialog);
        when(dialog.getFirstInteraction()).thenReturn(interaction);

        DialogStore dialogStore = dialogStoreProvider.get();


        //assertThat(dialogHandler.beginDialog()).isEqualTo(interaction);

    }

}