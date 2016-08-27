package core.config.xml.narrative.interaction;

import core.dialog.Interaction;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 21/05/2016.
 */
@XmlRootElement(name="simple-text")
@XmlAccessorType(XmlAccessType.NONE)
public class SimpleTextConfig {

    @XmlElement
    TextConfig text;

    @XmlIDREF
    @XmlElement
    InteractionConfig next;

    public TextConfig getText() {
        return text;
    }


    public InteractionConfig getNextInteraction() {
        return next;
    }
}
