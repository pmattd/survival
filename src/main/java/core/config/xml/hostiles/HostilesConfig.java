package core.config.xml.hostiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Pete on 03/08/2016.
 */
@XmlRootElement(name = "hostiles")
@XmlAccessorType(XmlAccessType.NONE)
public class HostilesConfig {

    @XmlElement(name = "hostile-group")
    List<HostileGroupConfig> hostileGroups;


    @XmlElement(name = "hostile")
    List<HostileConfig> hostile;

    public List<HostileGroupConfig> getHostileGroups() {
        return hostileGroups;
    }

}
