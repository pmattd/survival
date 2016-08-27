package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.boundary.options.ExecutableOption;
import core.combat.CurrentHostileGroup;
import core.combat.HostileGroup;
import core.combat.StartCombatAction;
import core.gamestate.GameStateMachine;
import core.gamestate.states.CombatState;
import core.translations.TranslationConstants;
import core.translations.Translations;

import java.util.List;

import static com.google.common.collect.Lists.asList;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Pete on 09/08/2016.
 */
@Singleton
public class StartCombatOptionFactory {

    private final GameStateMachine gameStateMachine;
    private final CurrentHostileGroup currentHostileGroup;
    private final CombatState combatState;
    private final Translations translations;

    @Inject
    public StartCombatOptionFactory(GameStateMachine gameStateMachine, CurrentHostileGroup currentHostileGroup, CombatState combatState, Translations translations) {
        this.gameStateMachine = gameStateMachine;
        this.currentHostileGroup = currentHostileGroup;
        this.combatState = combatState;
        this.translations = translations;
    }


    public List<ExecutableOption> build(HostileGroup hostileGroup){
        return newArrayList(getCombatExecutableOptions(hostileGroup));
    }


    private ExecutableOption getCombatExecutableOptions(HostileGroup hostileGroup) {
        return new ExecutableOption(
                translations.getTranslation(TranslationConstants.OPTIONS_FIGHT), buildAction(hostileGroup)
        );
    }


    private StartCombatAction buildAction(HostileGroup hostileGroup){
        return new StartCombatAction(gameStateMachine, hostileGroup,currentHostileGroup, combatState);
    }
}
