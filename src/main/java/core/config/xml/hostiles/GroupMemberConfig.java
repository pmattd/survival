package core.config.xml.hostiles;

import core.combat.Hostile;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 03/08/2016.
 */
@XmlRootElement(name = "group-member")
@XmlAccessorType(XmlAccessType.NONE)
public class GroupMemberConfig {

    @XmlIDREF
    @XmlAttribute(name = "hostile-ref")
    private HostileConfig hostileConfig;

    @XmlAttribute(name = "qty")
    private int qty;

    public HostileConfig getHostileConfig() {
        return hostileConfig;
    }

    public int getQty() {
        return qty;
    }
}
