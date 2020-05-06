package combat;

import java.util.List;

public class CombatGroup {

    private final List<Character> characters;

    public CombatGroup(List<Character> characters) {
        this.characters = characters;
    }

    public boolean contains(Character character) {
        return characters.contains(character);
    }

    public Character getRandom() {
        return characters.get(0);
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
