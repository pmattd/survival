package core.config.xml.narrative.interaction;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 21/05/2016.
 */

@XmlRootElement(name = "option")
@XmlAccessorType(XmlAccessType.NONE)
public class OptionConfig {

    @XmlElement
    private TextConfig text;

    @XmlIDREF
    @XmlElement
    private InteractionConfig next;

    public TextConfig getText() {
        return text;
    }

    public InteractionConfig getNextInteraction() {
        return next;
    }
}
