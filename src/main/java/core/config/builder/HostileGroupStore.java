package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.ProvidedBy;
import core.combat.HostileGroup;
import main.providers.HostileGroupStoreProvider;

import java.util.List;

/**
 * Created by Pete on 03/08/2016.
 */
@ProvidedBy(HostileGroupStoreProvider.class)
public class HostileGroupStore {

    private final List<HostileGroup> hostileGroups;

    public HostileGroupStore(List<HostileGroup> hostileGroups) {
        this.hostileGroups = hostileGroups;
    }

    public HostileGroup getById(String id){
        return hostileGroups.stream().filter((group) -> group.getId().equals(id)).findFirst().orElseThrow(() -> new HostileGroupNotFoundException());
    }
}
