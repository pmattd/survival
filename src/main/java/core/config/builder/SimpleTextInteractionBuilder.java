package core.config.builder;

import java.util.List;
import java.util.Optional;

import com.google.inject.Inject;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import core.config.xml.narrative.interaction.SimpleTextConfig;
import core.dialog.BasicInteraction;
import core.dialog.Interaction;
import core.dialog.InteractionOption;

/**
 * Created by Pete on 30/05/2016.
 */
public class SimpleTextInteractionBuilder {

    private final TextFactory textFactory;
    private final DialogOptionsFactory dialogOptionsFactory;
    private final InteractionOptionFactory interactionOptionFactory;


    @Inject
    public SimpleTextInteractionBuilder(TextFactory textFactory,
                                        DialogOptionsFactory dialogOptionsFactory,
                                        InteractionOptionFactory interactionOptionFactory) {
        this.textFactory = textFactory;
        this.dialogOptionsFactory = dialogOptionsFactory;
        this.interactionOptionFactory = interactionOptionFactory;
    }

    public Interaction build(SimpleTextConfig simpleTextConfig, InteractionFactory interactionFactory) {

        List<InteractionOption> interactionOptions = interactionOptionFactory.build(simpleTextConfig.getNextInteraction(), interactionFactory);

        OptionList<ExecutableOption> optionList = new OptionList<>(
                textFactory.build(simpleTextConfig.getText()), dialogOptionsFactory.build(interactionOptions)
        );

        return new BasicInteraction(optionList,false);

    }

}
