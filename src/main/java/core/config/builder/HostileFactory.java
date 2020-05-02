package core.config.builder;

import com.google.inject.Singleton;
import core.combat.Hostile;
import core.config.xml.hostiles.GroupMemberConfig;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Created by Pete on 03/08/2016.
 */
@Singleton
public class HostileFactory {


    public List<Hostile> build(GroupMemberConfig config){
        int quantity = config.getQty();

        List<Hostile> hostiles = new ArrayList<>();

        for(int i = 0; i<quantity; i++){
            hostiles.add(new Hostile(config.getHostileConfig().getHealth(),config.getHostileConfig().getDefaultName()));
        }
        return hostiles;
    }
}
