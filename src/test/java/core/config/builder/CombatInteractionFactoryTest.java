package core.config.builder;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import core.boundary.options.ExecutableOption;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.combat.HostileGroup;
import core.config.xml.narrative.interaction.CombatConfig;
import core.dialog.Interaction;

/**
 * Created by Pete on 03/08/2016.
 */
public class CombatInteractionFactoryTest {

    private CombatInteractionFactory combatInteractionFactory;

    @Mock
    private TextFactory textFactory;

    @Mock
    private HostileGroupStore hostileGroupStore;

    @Mock
    private CombatConfig combatConfig;

    @Mock
    private HostileGroup hostileGroup;

    @Mock
    private StartCombatOptionFactory startCombatOptionFactory;

    @Mock
    private ExecutableOption executableOption;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        combatInteractionFactory = new CombatInteractionFactory(textFactory,hostileGroupStore, startCombatOptionFactory);
    }

    @Test
    public void testBuild() throws Exception {
        when(combatConfig.getHostileGroupReference()).thenReturn("id");
        when(hostileGroupStore.getById("id")).thenReturn(hostileGroup);
        when(startCombatOptionFactory.build(hostileGroup)).thenReturn(asList(executableOption));
        Interaction interaction = combatInteractionFactory.build(combatConfig);
        assertThat(interaction.getInteractionOptions().getOptions().get(0)).isEqualTo(executableOption);
        assertThat(interaction.isFinal()).isFalse();

    }
}