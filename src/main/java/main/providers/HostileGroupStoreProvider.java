package main.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import core.combat.HostileGroup;
import core.config.builder.HostileGroupFactory;
import core.config.builder.HostileGroupStore;
import core.config.xml.Configuration;
import core.config.xml.hostiles.HostileGroupConfig;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.inject.internal.util.$Lists.newArrayList;

/**
 * Created by Pete on 03/08/2016.
 */
public class HostileGroupStoreProvider implements Provider<HostileGroupStore> {

    private final Configuration configuration;
    private final HostileGroupFactory hostileGroupFactory;

    @Inject
    public HostileGroupStoreProvider(Configuration configuration, HostileGroupFactory hostileGroupFactory) {
        this.configuration = configuration;
        this.hostileGroupFactory = hostileGroupFactory;
    }

    @Override
    public HostileGroupStore get() {
        List<HostileGroupConfig> hostileGroupList =  configuration.getHostilesConfig().getHostileGroups();
        List<HostileGroup> hostileGroups = hostileGroupList.stream().map((hostileGroupConfig) -> hostileGroupFactory.build(hostileGroupConfig)).collect(Collectors.toList());
        return new HostileGroupStore(hostileGroups);

    }
}
