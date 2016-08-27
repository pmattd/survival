package core.config.xml.narrative.interaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Pete on 21/05/2016.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ChoiceConfig {

    @XmlElement(name="option")
    private List<OptionConfig> options;

    @XmlElement(name="text")
    private TextConfig text;

    public List<OptionConfig> getOptions() {
        return options;
    }

    public TextConfig getText() {
        return text;
    }
}
