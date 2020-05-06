package combat;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class InitiativeStreamTest {

    Character a = new Character(7);
    Character b = new Character(5);

    @Test
    public void testInitiativeStream(){
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a,b));
        var stream = initiativeStream.calculateStream(1,2);
        assertThat(stream).containsExactly(b,a);
    }


    @Test
    public void testInitiativeStreamRec(){
        InitiativeStream initiativeStream = new InitiativeStream(List.of(a,b));
        var stream = initiativeStream.calculateRecStream(1,2);
        assertThat(stream).containsExactly(b,a);
    }


}