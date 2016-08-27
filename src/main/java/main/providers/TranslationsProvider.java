package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import core.config.xml.Configuration;
import core.config.xml.translations.TranslationConfig;
import core.translations.Translations;


import java.util.HashMap;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

/**
 * Created by Pete on 28/05/2016.
 */
@Singleton
public class TranslationsProvider implements Provider<Translations> {

    private final Configuration configuration;

    @Inject
    public TranslationsProvider(Configuration configuration) {
        this.configuration = configuration;
    }

    public Translations get() {
        List<TranslationConfig> translationsConfigs = configuration.getAllTranslationsConfig().getTranslationConfigs();


        HashMap<String, String> translations = newHashMap();

        for (TranslationConfig translationsConfig : translationsConfigs) {
            translations.put(translationsConfig.getKey(),translationsConfig.getTranslation());
        }


        return new Translations(translations);
    }

}
