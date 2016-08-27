package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.config.xml.narrative.interaction.TextConfig;
import core.translations.Translations;

/**
 * Created by Pete on 30/05/2016.
 */
@Singleton
public class TextFactory {


    private final Translations translations;

    @Inject
    public TextFactory(Translations translations) {
        this.translations = translations;
    }


    public String build(TextConfig textConfig){
        if(textConfig.getTranslationKey() == null){
            return textConfig.getDefaultText();
        }
        return translations.getTranslation(textConfig.getTranslationKey());
    }
}
