package core.config.xml.areas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import core.config.xml.narrative.interaction.TextConfig;

/**
 * Created by Pete on 14/06/2016.
 */
@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.NONE)
public class LocationConfig {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlElement (name ="title")
    private TextConfig title;

    @XmlElement
    private TextConfig desc;

    @XmlElement(name="supplies")
    private SuppliesConfig suppliesConfig;

    @XmlElement(name="arrival-event")
    private String arrivalEvent;


    public TextConfig getDesc() {
        return desc;
    }

    public SuppliesConfig getSupplies() {
        return suppliesConfig;
    }

    public TextConfig getTitle() {
        return title;
    }

    public String getArrivalEvent() {
        return arrivalEvent;
    }

}
