package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import core.config.builder.DialogFactory;
import core.config.xml.Configuration;
import core.config.xml.narrative.DialogConfig;
import core.dialog.Dialog;
import core.dialog.DialogStore;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


/**
 * Created by Pete on 21/05/2016.
 */
@Singleton
public class DialogStoreProvider implements Provider<DialogStore> {

    private final DialogStore dialogStore;

    @Inject
    public DialogStoreProvider(DialogFactory dialogFactory, Configuration configuration) {

        List<DialogConfig> dialogConfigs = configuration.getNarrativeConfig().getDialogs();
        List<Dialog> dialogs = newArrayList();

        for (DialogConfig dialogConfig : dialogConfigs) {
            dialogs.add(dialogFactory.build(dialogConfig));
        }

        dialogStore = new DialogStore(dialogs);

    }

    public DialogStore get() {
        return dialogStore;
    }
}
