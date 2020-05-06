package combat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombatManager {


    private final List<Character> partyA;
    private final List<Character> partyB;
    private final InitiativeStream initiativeStream;

    private int turn;


    public CombatManager(List<Character> partyA, List<Character> partyB) {
        this.partyA = Collections.unmodifiableList(partyA);
        this.partyB = Collections.unmodifiableList(partyB);


        List<Character> characters = new ArrayList<>();
        characters.addAll(partyA);
        characters.addAll(partyB);

        initiativeStream = new InitiativeStream(characters);
    }

    public void doTurn(){

        Character character = initiativeStream.getNext();
        //build attack options
        //select Attack
        //select Target
        //do attack
        //book keeping;
            //recalculate initiative stream
            //add/remove characters


    }
}
