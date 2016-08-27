package core.config.xml.narrative.interaction;


import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 30/05/2016.
 */

@XmlRootElement(name="text")
@XmlAccessorType(XmlAccessType.NONE)
public class TextConfig {

    @XmlAttribute(name = "key")
    private String translationKey;

    @XmlValue
    private String defaultText;


    public String getTranslationKey() {
        return translationKey;
    }

    public String getDefaultText() {
        return defaultText;
    }
}
