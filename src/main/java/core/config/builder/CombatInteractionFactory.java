package core.config.builder;

import com.google.inject.Inject;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import core.combat.HostileGroup;
import core.config.xml.narrative.interaction.CombatConfig;
import core.dialog.BasicInteraction;
import core.dialog.Interaction;

/**
 * Created by Pete on 03/08/2016.
 */
public class CombatInteractionFactory {

    private final TextFactory textFactory;
    private final HostileGroupStore hostileGroupStore;
    private final StartCombatOptionFactory startCombatOptionFactory;

    @Inject
    public CombatInteractionFactory(TextFactory textFactory,
                                    HostileGroupStore hostileGroupStore,
                                    StartCombatOptionFactory startCombatOptionFactory) {

        this.textFactory = textFactory;
        this.hostileGroupStore = hostileGroupStore;
        this.startCombatOptionFactory = startCombatOptionFactory;
    }

    public Interaction build(CombatConfig combatConfig) {
        HostileGroup hostileGroup = hostileGroupStore.getById(combatConfig.getHostileGroupReference());


        OptionList<ExecutableOption> optionList = new OptionList<>(
                textFactory.build(combatConfig.getText()), startCombatOptionFactory.build(hostileGroup)
        );

        return new BasicInteraction(optionList,false);
    }

}
