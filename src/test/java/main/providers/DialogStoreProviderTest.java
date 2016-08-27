package main.providers;

import core.config.builder.DialogFactory;
import core.config.xml.Configuration;
import core.config.xml.narrative.DialogConfig;
import core.config.xml.narrative.NarrativeConfig;
import core.dialog.Dialog;
import core.dialog.DialogStore;
import core.dialog.Interaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 21/05/2016.
 */
public class DialogStoreProviderTest {


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
    private DialogStoreProvider dialogStoreProvider;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testBuildingDialogs(){

        when(configuration.getNarrativeConfig()).thenReturn(narrativeConfig);
        when(narrativeConfig.getDialogs()).thenReturn(asList(dialogConfig));
        when(dialogFactory.build(dialogConfig)).thenReturn(dialog);
        when(dialog.getFirstInteraction()).thenReturn(interaction);
        dialogStoreProvider = new DialogStoreProvider(dialogFactory, configuration);
        DialogStore dialogStore = dialogStoreProvider.get();


        //assertThat(dialogHandler.beginDialog()).isEqualTo(interaction);

    }

}