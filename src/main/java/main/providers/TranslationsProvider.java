package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import core.config.xml.Configuration;
import core.config.xml.translations.TranslationConfig;
import core.translations.Translations;

import java.util.HashMap;
import java.util.List;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Created by Pete on 28/05/2016.
 */
@Singleton
public class TranslationsProvider implements Provider<Translations> {

    private final Translations translations;

    @Inject
    public TranslationsProvider(Configuration configuration) {
        List<TranslationConfig> translationsConfigs = configuration.getAllTranslationsConfig().getTranslationConfigs();

        HashMap<String, String> translationsMap = newHashMap();

        for (TranslationConfig translationsConfig : translationsConfigs) {
            translationsMap.put(translationsConfig.getKey(), translationsConfig.getTranslation());
        }


        translations = new Translations(translationsMap);

    }

    public Translations get() {
        return translations;
    }

}
