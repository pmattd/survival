package core.config.xml.narrative.interaction;

import javax.xml.bind.annotation.*;

/**
 * Created by Pete on 21/05/2016.
 */
@XmlRootElement(name="interaction")
@XmlAccessorType(XmlAccessType.NONE)
public class InteractionConfig {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlElement(name="choice")
    private ChoiceConfig choiceConfig;

    @XmlElement (name="simple-text")
    private SimpleTextConfig simpleTextConfig;

    @XmlElement (name="combat")
    private CombatConfig combatConfig;


    public String getId() {
        return id;
    }


    public ChoiceConfig getChoiceConfig() {
        return choiceConfig;
    }

    public SimpleTextConfig getSimpleTextConfig() {
        return simpleTextConfig;
    }

    public CombatConfig getCombatConfig() {
        return combatConfig;
    }
}
