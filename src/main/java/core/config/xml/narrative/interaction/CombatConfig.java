package core.config.xml.narrative.interaction;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 03/08/2016.
 */


@XmlRootElement(name="combat")
@XmlAccessorType(XmlAccessType.NONE)
public class CombatConfig {

    @XmlElement
    private TextConfig text;

    @XmlElement(name ="hostile-group-ref")
    private String hostileGroupReference;

    public TextConfig getText() {
        return text;
    }

    public String getHostileGroupReference() {
        return hostileGroupReference;
    }


}
