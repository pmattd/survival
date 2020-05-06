package combat;

public class Attack extends CombatAction {
    private final int damage;

    private Attack(int damage) {
        this.damage = damage;
    }

}
