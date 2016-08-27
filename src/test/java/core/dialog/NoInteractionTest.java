package core.dialog;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Pete on 07/06/2016.
 */
public class NoInteractionTest {

    private NoInteraction noInteraction;

    @Before
    public void setup(){
        noInteraction = new NoInteraction();
    }

    @Test
    public void testGetOptions() throws Exception {
        assertThat(noInteraction.getInteractionOptions().getOptions()).hasSize(0);
    }

    @Test
    public void testIsFinal() throws Exception {
        assertThat(noInteraction.isFinal()).isTrue();
    }
}