package core.config.builder;

import core.combat.Hostile;
import core.combat.HostileGroup;
import core.config.xml.hostiles.GroupMemberConfig;
import core.config.xml.hostiles.HostileGroupConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        hostileGroupFactory = new HostileGroupFactory(hostileFactory);
    }

    @Test
    public void testBuild() throws Exception {
/*        when(hostileGroupConfig.getGroupMembers()).thenReturn(List.of(groupMemberConfig));
        when(hostileFactory.build(groupMemberConfig)).thenReturn(List.of(hostile));
        when(hostileGroupConfig.getId()).thenReturn("id");
        HostileGroup hostileGroup = hostileGroupFactory.build(hostileGroupConfig);
        assertThat(hostileGroup.getId()).isEqualTo("id");*/

    }


}