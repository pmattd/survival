package core.config.xml.areas;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import core.config.xml.narrative.interaction.TextConfig;

/**
 * Created by Pete on 05/06/2016.
 */

@XmlRootElement(name = "area")
@XmlAccessorType(XmlAccessType.NONE)
public class AreaConfig {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlElement
    private TextConfig desc;


    @XmlElement
    private TextConfig title;

    @XmlElementWrapper(name="directions")
    @XmlElement(name="direction")
    List<DirectionConfig> directions;

    @XmlElement(name="location")
    List<LocationConfig> locations;

    public TextConfig getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public List<DirectionConfig> getDirections() {
        return directions;
    }

    public List<LocationConfig> getLocations() {
        return locations;
    }

    public TextConfig getTitle() {
        return title;
    }
}
