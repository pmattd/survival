package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import core.combat.HostileGroup;
import core.config.builder.HostileGroupFactory;
import core.config.builder.HostileGroupStore;
import core.config.xml.Configuration;
import core.config.xml.hostiles.HostileGroupConfig;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pete on 03/08/2016.
 */
@Singleton
public class HostileGroupStoreProvider implements Provider<HostileGroupStore> {

    private final HostileGroupStore hostileGroupStore;

    @Inject
    public HostileGroupStoreProvider(Configuration configuration, HostileGroupFactory hostileGroupFactory) {
        List<HostileGroupConfig> hostileGroupList = configuration.getHostilesConfig().getHostileGroups();
        List<HostileGroup> hostileGroups = hostileGroupList.stream().map((hostileGroupConfig) -> hostileGroupFactory.build(hostileGroupConfig)).collect(Collectors.toList());
        hostileGroupStore = new HostileGroupStore(hostileGroups);
    }

    @Override
    public HostileGroupStore get() {
        return hostileGroupStore;
    }
}
