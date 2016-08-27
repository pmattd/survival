package core.config.builder;

import com.google.inject.Inject;
import core.config.xml.narrative.DialogConfig;
import core.config.xml.narrative.interaction.InteractionConfig;
import core.dialog.Dialog;
import core.dialog.Interaction;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Pete on 21/05/2016.
 */
public class DialogFactory {

    private final InteractionFactory interactionFactory;

    @Inject
    public DialogFactory(InteractionFactory interactionFactory) {
        this.interactionFactory = interactionFactory;
    }

    public Dialog build(DialogConfig dialogConfig) {
        InteractionConfig start = dialogConfig.getStart();
        Interaction interaction = interactionFactory.build(start);
        return new Dialog(dialogConfig.getId(), interaction);
    }
}
