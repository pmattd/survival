package core.config.builder;

import core.combat.Hostile;
import core.config.xml.hostiles.GroupMemberConfig;
import core.config.xml.hostiles.HostileConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 03/08/2016.
 */
public class HostileFactoryTest {

    private HostileFactory hostileFactory;

    @Mock
    GroupMemberConfig config;
    @Mock
    private HostileConfig hostileConfig;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        hostileFactory = new HostileFactory();
    }

    @Test
    public void testBuild() throws Exception {
        when(config.getQty()).thenReturn(3);
        when(config.getHostileConfig()).thenReturn(hostileConfig);
        when(hostileConfig.getDefaultName()).thenReturn("defaultName");
        when(hostileConfig.getHealth()).thenReturn(12);
        List<Hostile> hostiles = hostileFactory.build(config);
        assertThat(hostiles).hasSize(3);
    }
}