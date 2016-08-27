package core.config.builder;

import static com.google.common.collect.Maps.newHashMap;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import core.config.xml.narrative.interaction.InteractionConfig;
import core.dialog.Interaction;
import core.dialog.NoInteraction;

/**
 * Created by Pete on 21/05/2016.
 */

public class InteractionFactory {

    private final SimpleTextInteractionBuilder simpleTextInteractionBuilder;
    private final ChoiceInteractionFactory choiceInteractionFactory;
    private final NoInteraction noInteraction;
    private final CombatInteractionFactory combatInteractionFactory;
    private HashMap<String, Interaction> builtInteractions;

    private Logger logger = LoggerFactory.getLogger(InteractionFactory.class);

    @Inject
    public InteractionFactory(SimpleTextInteractionBuilder simpleTextInteractionBuilder, ChoiceInteractionFactory choiceInteractionFactory, NoInteraction noInteraction, CombatInteractionFactory combatInteractionFactory) {
        this.simpleTextInteractionBuilder = simpleTextInteractionBuilder;
        this.choiceInteractionFactory = choiceInteractionFactory;
        this.noInteraction = noInteraction;
        this.combatInteractionFactory = combatInteractionFactory;
        builtInteractions = newHashMap();
    }

    public Interaction build(InteractionConfig interactionConfig) {

        if (interactionConfig == null) {
            return noInteraction;
        }

        if(builtInteractions.containsKey(interactionConfig.getId())){
            return builtInteractions.get(interactionConfig.getId());
        }

        Interaction interaction = buildInteraction(interactionConfig);
        builtInteractions.put(interactionConfig.getId(),interaction);
        return interaction;
    }

    private Interaction buildInteraction(InteractionConfig interactionConfig) {

        if (interactionConfig.getChoiceConfig() != null) {
            return choiceInteractionFactory.build(interactionConfig.getChoiceConfig(), this);
        }
        if (interactionConfig.getSimpleTextConfig() != null) {
            return simpleTextInteractionBuilder.build(interactionConfig.getSimpleTextConfig(), this);
        }
        if(interactionConfig.getCombatConfig() != null){
            return combatInteractionFactory.build(interactionConfig.getCombatConfig());
        }

        ConfigBuildException e =  new ConfigBuildException("an interactionConfig must contain a choice or a simple text : [" + interactionConfig.getId() + "]");
        logger.error(e.toString());
        throw e;
    }

}
