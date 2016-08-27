package main.providers;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Provider;

import core.config.builder.DialogFactory;
import core.config.xml.Configuration;
import core.config.xml.narrative.DialogConfig;
import core.dialog.Dialog;
import core.dialog.DialogStore;


/**
 * Created by Pete on 21/05/2016.
 */
public class DialogStoreProvider implements Provider<DialogStore> {

    private final DialogFactory dialogFactory;
    private final Configuration configuration;

    @Inject
    public DialogStoreProvider(DialogFactory dialogFactory, Configuration configuration) {
        this.dialogFactory = dialogFactory;
        this.configuration = configuration;
    }

    public DialogStore get() {
        List<DialogConfig> dialogConfigs = configuration.getNarrativeConfig().getDialogs();
        List<Dialog> dialogs = newArrayList();

        for (DialogConfig dialogConfig : dialogConfigs) {
            dialogs.add(dialogFactory.build(dialogConfig));
        }

        return new DialogStore(dialogs);
    }
}
