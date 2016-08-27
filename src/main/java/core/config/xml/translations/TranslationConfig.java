package core.config.xml.translations;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 28/05/2016.
 */

@XmlRootElement(name="translation")
@XmlAccessorType(XmlAccessType.NONE)
public class TranslationConfig {

    @XmlID
    @XmlAttribute
    private String key;

    @XmlValue
    private String translation;

    public String getKey() {
        return key;
    }

    public String getTranslation() {
        return translation;
    }
}
