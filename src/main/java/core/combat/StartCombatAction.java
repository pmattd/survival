package core.combat;

import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.CombatState;

/**
 * Created by Pete on 09/08/2016.
 */
public class StartCombatAction implements Action {
    private final GameStateMachine gameStateMachine;
    private final HostileGroup hostileGroup;
    private final CurrentHostileGroup currentHostileGroup;
    private final CombatState combatState;

    public StartCombatAction(GameStateMachine gameStateMachine, HostileGroup hostileGroup, CurrentHostileGroup currentHostileGroup, CombatState combatState){
        this.gameStateMachine = gameStateMachine;
        this.hostileGroup = hostileGroup;
        this.currentHostileGroup = currentHostileGroup;
        this.combatState = combatState;
    }

    @Override
    public void run() {
        gameStateMachine.setState(combatState);
        currentHostileGroup.setGroup(hostileGroup);
    }
}
