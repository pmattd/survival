package core.config.xml.hostiles;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 03/08/2016.
 */

@XmlRootElement(name = "hostile")
@XmlAccessorType(XmlAccessType.NONE)
public class HostileConfig {

    @XmlID
    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="default-name")
    private String defaultName;

    @XmlElement(name="health")
    private int health;

    public String getId() {
        return id;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public int getHealth() {
        return health;
    }
}
