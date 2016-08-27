package core.config.builder;

import com.google.inject.Inject;
import core.config.xml.narrative.interaction.InteractionConfig;
import core.config.xml.narrative.interaction.OptionConfig;
import core.dialog.InteractionOption;
import core.translations.Translations;

import java.util.List;
import java.util.stream.Collectors;

import static core.translations.TranslationConstants.INTERACTION_NEXT;
import static java.util.Arrays.asList;

/**
 * Created by Pete on 09/08/2016.
 */
public class InteractionOptionFactory {

    private final TextFactory textFactory;

    private final Translations translations;

    @Inject
    public InteractionOptionFactory(TextFactory textFactory, Translations translations) {
        this.textFactory = textFactory;
        this.translations = translations;
    }


    public List<InteractionOption> build(List<OptionConfig> options, InteractionFactory interactionFactory) {
        List<InteractionOption> interactionOptions = options.stream()
                .map(optionConfig -> new InteractionOption(
                        textFactory.build(optionConfig.getText()),
                        interactionFactory.build(optionConfig.getNextInteraction()))).collect(Collectors.toList());

        return interactionOptions;
    }

    public List<InteractionOption> build(InteractionConfig interactionConfig,InteractionFactory interactionFactory) {
        InteractionOption theOption = new InteractionOption(
                translations.getTranslation(INTERACTION_NEXT),
                interactionFactory.build(interactionConfig));

        return asList(theOption);
    }


}
