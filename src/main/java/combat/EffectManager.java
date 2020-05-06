package combat;

public class EffectManager {

    public Character applyEffect(CombatAction action, Character character) {
        return character.doDamage(action.getDamage());

    }

}
