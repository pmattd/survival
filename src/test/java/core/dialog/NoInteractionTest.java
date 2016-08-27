package core.dialog;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Pete on 07/06/2016.
 */
public class NoInteractionTest {

    NoInteraction noInteraction;

    @Before
    public void setup(){
        noInteraction = new NoInteraction();
    }

    @Test
    public void testGetOptions() throws Exception {
        assertThat(noInteraction.getInteractionOptions().getOptions()).isEmpty();
        assertThat(noInteraction.getInteractionOptions().getHeader().isPresent()).isFalse();
    }

    @Test
    public void testIsFinal() throws Exception {
        assertThat(noInteraction.isFinal()).isTrue();
    }
}