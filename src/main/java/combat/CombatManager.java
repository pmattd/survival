package combat;

import java.util.ArrayList;
import java.util.List;

public class CombatManager {

    private final CombatGroup partyA;
    private final CombatGroup partyB;
    private final InitiativeStream initiativeStream;

    private int turn;

    public CombatManager(CombatGroup partyA, CombatGroup partyB, InitiativeStream initiativeStream) {
        this.partyA = partyA;
        this.partyB = partyB;

        List<Character> characters = new ArrayList<>();
        characters.addAll(partyA.getCharacters());
        characters.addAll(partyB.getCharacters());

        this.initiativeStream = initiativeStream;
    }

    public CombatGroup getTargetGroup(Character character) {
        if (partyA.contains(character)) {
            return partyB;
        }
        return partyA;
    }

    public CombatManager doTurn() {

        Character character = initiativeStream.getNextCharacters(1).get(0);
        CombatAction combatAction = character.getCombatActions().get(0);
        Character target = getTargetGroup(character).getRandom();
        Character newTarget = target.doDamage(combatAction.getDamage());

        //replace the target with the new target
        return new CombatManager(partyA, partyB, initiativeStream.next());

        //get target

        //select Target
        //do attack
        //book keeping;
        //recalculate initiative stream
        //add/remove characters

    }
}
