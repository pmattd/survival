package core.config.xml.hostiles;

import core.combat.Hostile;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Pete on 03/08/2016.
 */

@XmlRootElement(name = "hostile-group")
@XmlAccessorType(XmlAccessType.NONE)
public class HostileGroupConfig {

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name="group-member")
    List<GroupMemberConfig> groupMember;

    public List<GroupMemberConfig> getGroupMembers() {
        return groupMember;
    }

    public String getId() {
        return id;
    }
}
