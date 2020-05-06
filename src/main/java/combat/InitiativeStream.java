package combat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class InitiativeStream {

    private final List<Character> characters;

    public InitiativeStream(List<Character> characters){
        this.characters = characters;
    }


    public List<Character> calculateRecStream(int initiativeTurn,int maxTurns){
        return letsDoItRecursively(this.characters,new ArrayList<>(),maxTurns,initiativeTurn);
    }


    public Character getNext(){
        for (Character character : characters) {

        }
    }

    public List<Character> letsDoItRecursively(final List<Character> characters,
                                               final List<Character> order,
                                               final int maxTurns,
                                               final int currentSlot){
        if(maxTurns > 0){
            List<Character> nextCharacters = characters.stream().filter(p -> currentSlot % p.getInitiative()  == 0).collect(Collectors.toList());
            return letsDoItRecursively(
                    characters,
                    Stream.concat(order.stream(),nextCharacters.stream()).collect(Collectors.toList()),
                    maxTurns - nextCharacters.size(),
                    currentSlot + 1);
        }
        return order;
    }


    public List<Character> calculateStream(int startingInitiativeSlot,int maxTurns){
        var initiativeOrder = new ArrayList<Character>();
        var charactersInStream = 0;

        while(charactersInStream < maxTurns){
            for (Character character : characters) {
                if(startingInitiativeSlot % character.getInitiative()  == 0){
                    initiativeOrder.add(character);
                    charactersInStream++;
                }
            }
            startingInitiativeSlot++;
        }
        return initiativeOrder;
    }


    //didn't increament starting slot
    //mod operation wrong way round
}
