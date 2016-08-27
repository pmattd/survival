package core.dialog;

import static org.fest.assertions.Assertions.assertThat;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Pete on 21/05/2016.
 */
public class DialogHandlerTest {

    DialogStore dialogStore;

    @Mock
    List<Dialog> subNarratives;

    @Mock
    Interaction currentInteraction;

    @Mock
    InteractionOption interactionOption;

    @Mock
    private Interaction nextInteraction;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        dialogStore = new DialogStore(subNarratives);
    }

}