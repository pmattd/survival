package core.config.xml.narrative;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Pete on 21/05/2016.
 */
@XmlRootElement(name = "narrative")
@XmlAccessorType(XmlAccessType.NONE)
public class NarrativeConfig {

    @XmlElement(name = "dialog")
    private List<DialogConfig> dialogs;

    public List<DialogConfig> getDialogs() {
        return dialogs;
    }

}
