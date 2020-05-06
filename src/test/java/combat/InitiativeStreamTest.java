package combat;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class InitiativeStreamTest {

    Character a = new Character(3);
    Character b = new Character(5);
    Character c = new Character(3);

    @Test
    public void testInitiativeStream() {
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a, b), 2);
        var stream = initiativeStream.getNextCharacters(2);
        assertThat(stream).containsExactly(a, b);
    }

    @Test
    public void testInitiativeStream_different_initiative() {
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a, b), 7);
        var stream = initiativeStream.getNextCharacters(7);
        assertThat(stream).containsExactly(a, b, a, a, b, a, a);
    }

    @Test
    public void testInitiativeStream_same_initiative() {
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a, c), 6);
        var stream = initiativeStream.getNextCharacters(6);
        assertThat(stream).containsExactly(a, c, a, c, a, c);
    }

    @Test
    public void testPop() {
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a, b), 3);
        var nextCharacter = initiativeStream.popNext();
        assertThat(nextCharacter).isEqualTo(a);
    }

    @Test
    public void testPop_resultingStream() {
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a, b), 3);
        initiativeStream.popNext();
        assertThat(initiativeStream.getNextCharacters(3)).containsExactly(b, a, a);
    }

}