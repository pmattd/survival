package core.config.xml.areas;

import core.config.xml.narrative.interaction.TextConfig;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 06/06/2016.
 */
@XmlRootElement(name = "direction")
@XmlAccessorType(XmlAccessType.NONE)
public class DirectionConfig {

    @XmlIDREF
    @XmlAttribute(name="area-id")
    AreaConfig location;

    @XmlElement
    TextConfig text;

    public AreaConfig getArea() {
        return location;
    }

    public TextConfig getText() {
        return text;
    }
}
