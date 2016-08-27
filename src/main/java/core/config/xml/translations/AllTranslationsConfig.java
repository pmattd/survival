package core.config.xml.translations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Pete on 28/05/2016.
 */

@XmlRootElement(name="translations")
@XmlAccessorType(XmlAccessType.NONE)
public class AllTranslationsConfig {

    @XmlElement(name="translation")
    List<TranslationConfig> translationConfigs;

    public List<TranslationConfig> getTranslationConfigs() {
        return translationConfigs;
    }
}
