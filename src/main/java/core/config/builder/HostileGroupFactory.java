package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.combat.Hostile;
import core.combat.HostileGroup;
import core.config.xml.hostiles.GroupMemberConfig;
import core.config.xml.hostiles.HostileGroupConfig;

import java.util.List;

import static com.google.inject.internal.util.$Lists.newArrayList;

/**
 * Created by Pete on 03/08/2016.
 */
@Singleton
public class HostileGroupFactory {

    private final HostileFactory hostileFactory;

    @Inject
    public HostileGroupFactory(HostileFactory hostileFactory) {
        this.hostileFactory = hostileFactory;
    }

    public HostileGroup build(HostileGroupConfig config) {

        List<Hostile> hostiles =  newArrayList();

        for (GroupMemberConfig groupMemberConfig : config.getGroupMembers()) {
            hostiles.addAll(hostileFactory.build(groupMemberConfig));
        }

        return new HostileGroup(config.getId(), hostiles);
    }

}
