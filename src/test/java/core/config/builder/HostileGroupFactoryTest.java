package core.config.builder;

import core.combat.Hostile;
import core.combat.HostileGroup;
import core.config.xml.hostiles.GroupMemberConfig;
import core.config.xml.hostiles.HostileGroupConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.inject.internal.util.$Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 03/08/2016.
 */
public class HostileGroupFactoryTest {

    HostileGroupFactory hostileGroupFactory;

    @Mock
    HostileGroupConfig hostileGroupConfig;

    @Mock
    private GroupMemberConfig groupMemberConfig;

    @Mock
    private HostileFactory hostileFactory;

    @Mock
    private Hostile hostile;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        hostileGroupFactory = new HostileGroupFactory(hostileFactory);
    }

    @Test
    public void testBuild() throws Exception {
        when(hostileGroupConfig.getGroupMembers()).thenReturn(newArrayList(groupMemberConfig));
        when(hostileFactory.build(groupMemberConfig)).thenReturn(newArrayList(hostile));
        when(hostileGroupConfig.getId()).thenReturn("id");
        HostileGroup hostileGroup = hostileGroupFactory.build(hostileGroupConfig);
        assertThat(hostileGroup.getId()).isEqualTo("id");

    }


}