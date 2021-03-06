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

    private final Configuration configuration;
    private Logger logger = LoggerFactory.getLogger(ConfigurationProvider.class);

    @Inject
    public ConfigurationProvider(ConfigParser configParser) {
        File narratives = createFile("narrative/narrative.xml");
        File translations = createFile("translations/translations_en.xml");
        File coreTranslations = createFile("translations/core_translations_en.xml");
        File locationMap = createFile("area/area-map.xml");
        File hostilesConfig = createFile("npc/hostiles.xml");
        configuration = configParser.readConfiguration(narratives, coreTranslations, translations, locationMap, hostilesConfig);

    }

    public Configuration get() {
        return configuration;
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
