package core.translations;

import java.util.HashMap;

import com.google.inject.ProvidedBy;
import com.google.inject.Singleton;

import main.providers.TranslationsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pete on 28/05/2016.
 */
@Singleton
@ProvidedBy(TranslationsProvider.class)
public class Translations {
    Logger logger = LoggerFactory.getLogger(Translations.class);
    private final HashMap<String,String> translations;

    public Translations(HashMap<String, String> translations) {
        this.translations = translations;
    }

    public String getTranslation(String translationKey){
        if(!translations.containsKey(translationKey)){
            NoTranslationForKeyException e = new NoTranslationForKeyException(translationKey);
            logger.error(e.toString());
            throw e;
        }
        return translations.get(translationKey);
    }
}
