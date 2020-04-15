package core.config.builder;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import core.boundary.options.ExecutableOption;
import core.config.xml.narrative.interaction.TextConfig;
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

    @Mock
    private TextConfig textConfig;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        combatInteractionFactory = new CombatInteractionFactory(textFactory,hostileGroupStore, startCombatOptionFactory);
    }

    @Test
    public void testBuild() throws Exception {
        when(combatConfig.getHostileGroupReference()).thenReturn("id");
        when(combatConfig.getText()).thenReturn(textConfig);
        when(textFactory.build(textConfig)).thenReturn("default");
        when(hostileGroupStore.getById("id")).thenReturn(hostileGroup);
        when(startCombatOptionFactory.build(hostileGroup)).thenReturn(asList(executableOption));
        Interaction interaction = combatInteractionFactory.build(combatConfig);
        assertThat(interaction.getInteractionOptions().getOptions().get(0)).isEqualTo(executableOption);
        assertThat(interaction.isFinal()).isFalse();

    }
}