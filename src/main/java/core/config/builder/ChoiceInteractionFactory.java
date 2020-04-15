package core.config.builder;

import java.util.List;
import java.util.Optional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import core.config.xml.narrative.interaction.ChoiceConfig;
import core.dialog.BasicInteraction;
import core.dialog.Interaction;
import core.dialog.InteractionOption;

/**
 * Created by Pete on 30/05/2016.
 */
@Singleton
public class ChoiceInteractionFactory {

    private final TextFactory textFactory;
    private final DialogOptionsFactory dialogOptionsFactory;
    private final InteractionOptionFactory interactionOptionFactory;


    @Inject
    public ChoiceInteractionFactory(TextFactory textFactory, DialogOptionsFactory dialogOptionsFactory, InteractionOptionFactory interactionOptionFactory) {
        this.textFactory = textFactory;
        this.dialogOptionsFactory = dialogOptionsFactory;
        this.interactionOptionFactory = interactionOptionFactory;
    }

    public Interaction build(ChoiceConfig choiceConfig, InteractionFactory interactionFactory) {

        List<InteractionOption> interactionOptions = interactionOptionFactory.build(choiceConfig.getOptions(), interactionFactory);

        List<ExecutableOption> options = dialogOptionsFactory.build(interactionOptions);

        OptionList<ExecutableOption> optionList = new OptionList<>(
                Optional.of(textFactory.build(choiceConfig.getText())), options);

        return new BasicInteraction(optionList,false);
    }


}
