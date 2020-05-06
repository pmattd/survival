package combat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitiativeStream {

    private final List<Character> characters;
    private final List<CharacterSlot> currentStream;

    public InitiativeStream(List<Character> characters, int turnsAhead) {
        this.characters = characters;
        currentStream = calculateInitiativeStream(1, turnsAhead);
    }

    private InitiativeStream(List<Character> characters, int turnsAhead, int currentSlot) {
        this.characters = characters;
        currentStream = calculateInitiativeStream(currentSlot + 1, turnsAhead);
    }

    public InitiativeStream next() {
        return new InitiativeStream(characters, currentStream.size(), currentStream.get(0).slot);
    }

    public List<Character> getNextCharacters(int maxTurns) {
        return currentStream.subList(0, maxTurns).stream().map(p -> p.character).collect(Collectors.toList());
    }

    private List<CharacterSlot> calculateInitiativeStream(int initiativeTurn, int maxTurns) {
        return calculateStream(new ArrayList<>(), maxTurns, initiativeTurn);
    }

    private List<CharacterSlot> calculateStream(final List<CharacterSlot> order,
                                                final int maxTurns,
                                                final int currentSlot) {
        if (maxTurns > 0) {
            List<CharacterSlot> nextCharacters = characters.stream()
                    .filter(p -> currentSlot % (p.getInitiative() * 100 + characters.indexOf(p)) == 0)
                    .map(p -> new CharacterSlot(p, currentSlot))
                    .collect(Collectors.toList());

            return calculateStream(
                    Stream.concat(order.stream(), nextCharacters.stream()).collect(Collectors.toUnmodifiableList()),
                    maxTurns - nextCharacters.size(),
                    currentSlot + 1);
        }
        return order;
    }

    private class CharacterSlot {
        public final Character character;
        public final int slot;

        CharacterSlot(Character character, int slot) {
            this.character = character;
            this.slot = slot;
        }
    }
}
