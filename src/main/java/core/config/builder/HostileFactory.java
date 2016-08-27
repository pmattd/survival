package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.combat.Hostile;
import core.config.xml.hostiles.GroupMemberConfig;

import java.util.List;

import static com.google.inject.internal.util.$Lists.newArrayList;

/**
 * Created by Pete on 03/08/2016.
 */
@Singleton
public class HostileFactory {


    public List<Hostile> build(GroupMemberConfig config){
        int quantity = config.getQty();

        List<Hostile> hostiles = newArrayList();

        for(int i = 0; i<quantity; i++){
            hostiles.add(new Hostile(config.getHostileConfig().getHealth(),config.getHostileConfig().getDefaultName()));
        }
        return hostiles;
    }
}
