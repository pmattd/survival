package combat;

import java.util.List;

public class Character {
    private final int initiative;
    private final List<CombatAction> combatActions;
    private final int health;

    public Character(int initiative, List<CombatAction> combatActions, int health) {
        this.initiative = initiative;
        this.combatActions = combatActions;
        this.health = health;
    }

    public int getInitiative() {
        return initiative;
    }

    ;

    public List<CombatAction> getCombatActions() {
        return combatActions;
    }

    ;

    public Character doDamage(int damage) {
        return new Character(initiative, combatActions, health - damage);
    }

}
