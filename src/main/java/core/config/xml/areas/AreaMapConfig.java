package core.config.xml.areas;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Pete on 05/06/2016.
 */

@XmlRootElement(name = "area-map")
@XmlAccessorType(XmlAccessType.NONE)
public class AreaMapConfig {

    @XmlIDREF
    @XmlAttribute(name="area-start")
    private AreaConfig locationStart;

    @XmlElement(name="area")
    private List<AreaConfig> areaConfigs;

    public List<AreaConfig> getAreaConfigs() {
        return areaConfigs;
    }

    public AreaConfig getLocationStart(){return locationStart;}
}
