package core.config.xml;

import com.google.inject.ProvidedBy;
import com.google.inject.Singleton;
import core.config.xml.areas.AreaMapConfig;
import core.config.xml.hostiles.HostilesConfig;
import core.config.xml.narrative.NarrativeConfig;
import core.config.xml.translations.AllTranslationsConfig;
import main.providers.ConfigurationProvider;

/**
 * Created by Pete on 21/05/2016.
 */

@Singleton
@ProvidedBy(ConfigurationProvider.class)
public class Configuration {
    private final NarrativeConfig narrativeConfig;
    private final AllTranslationsConfig allTranslationsConfig;
    private final AreaMapConfig areaMapConfig;
    private final HostilesConfig hostilesConfig;

    public Configuration(NarrativeConfig narrativeConfig,
                         AllTranslationsConfig coreTranslationsConfig,
                         AllTranslationsConfig allTranslationsConfig,
                         AreaMapConfig areaMapConfig,
                         HostilesConfig hostilesConfig){
        this.narrativeConfig = narrativeConfig;
        this.allTranslationsConfig = allTranslationsConfig;
        this.hostilesConfig = hostilesConfig;
        allTranslationsConfig.getTranslationConfigs().addAll(coreTranslationsConfig.getTranslationConfigs());
        this.areaMapConfig = areaMapConfig;
    }


    public NarrativeConfig getNarrativeConfig() {
        return narrativeConfig;
    }

    public AllTranslationsConfig getAllTranslationsConfig() {
        return allTranslationsConfig;
    }

    public AreaMapConfig getAreaMapConfig() {
        return areaMapConfig;
    }

    public HostilesConfig getHostilesConfig() {
        return hostilesConfig;
    }
}
