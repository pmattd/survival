package core.config.parser;

import core.config.xml.Configuration;
import core.config.xml.areas.AreaMapConfig;
import core.config.xml.hostiles.HostilesConfig;
import core.config.xml.narrative.NarrativeConfig;
import core.config.xml.translations.AllTranslationsConfig;


import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Pete on 21/05/2016.
 */
@Singleton
public class ConfigParser {

    public Configuration readConfiguration(File narrativesFile,
                                           File coreTranslations,
                                           File translationsFile,
                                           File locationMapFile,
                                           File hostilesFile){

        NarrativeConfig narrative = (NarrativeConfig) parseConfig(narrativesFile, NarrativeConfig.class);
        AllTranslationsConfig scenarioTranslationsConfig = (AllTranslationsConfig) parseConfig(translationsFile, AllTranslationsConfig.class);
        AllTranslationsConfig coreTranslationsConfig = (AllTranslationsConfig) parseConfig(coreTranslations, AllTranslationsConfig.class);
        AreaMapConfig areaMapConfig = (AreaMapConfig) parseConfig(locationMapFile, AreaMapConfig.class);
        HostilesConfig hostilesConfig = (HostilesConfig) parseConfig(hostilesFile, HostilesConfig.class);

        return new Configuration(
                narrative,
                coreTranslationsConfig,
                scenarioTranslationsConfig,
                areaMapConfig,
                hostilesConfig);

    }

    private Object parseConfig(File xmlFile, Class clazz) {
        Object configurationObj = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            configurationObj =  u.unmarshal(xmlFile);

        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("failed to parse configuration file" ,e);
        }
        return configurationObj;
    }
}
