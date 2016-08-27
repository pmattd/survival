package core.config.xml.narrative;

import core.config.xml.narrative.interaction.InteractionConfig;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Pete on 21/05/2016.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DialogConfig {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlIDREF
    @XmlAttribute(name="start")
    private InteractionConfig start;

    @XmlElement(name="interaction")
    private List<InteractionConfig> interactions;

    public String getId() {
        return id;
    }

    public InteractionConfig getStart() {
        return start;
    }

}
