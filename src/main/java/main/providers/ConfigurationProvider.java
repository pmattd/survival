package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import core.config.parser.ConfigParser;
import core.config.xml.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Pete on 03/08/2016.
 */

@Singleton
public class ConfigurationProvider implements Provider<Configuration> {

    Logger logger = LoggerFactory.getLogger(ConfigurationProvider.class);

    private final ConfigParser configParser;

    @Inject
    public ConfigurationProvider(ConfigParser configParser) {
        this.configParser = configParser;
    }

    public Configuration get() {
        File narratives = createFile("narrative/narrative.xml");
        File translations = createFile("translations/translations_en.xml");
        File coreTranslations = createFile("translations/core_translations_en.xml");
        File locationMap = createFile("area/area-map.xml");
        File hostilesConfig = createFile("npc/hostiles.xml");
        return configParser.readConfiguration(narratives, coreTranslations, translations, locationMap, hostilesConfig);

    }

    private File createFile(String resourcePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            return new File(classLoader.getResource(resourcePath).getFile());
        } catch (NullPointerException e) {
            logger.error(String.format("unable to load configFiles %s", resourcePath));
            throw e;
        }
    }

}
