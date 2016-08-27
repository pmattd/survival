package core.combat;

import java.util.List;

/**
 * Created by Pete on 03/08/2016.
 */
public class HostileGroup {


    private final String id;
    private final List<Hostile> hostiles;


    public HostileGroup(String id, List<Hostile> hostiles) {
        this.id = id;
        this.hostiles = hostiles;
    }

    public String getId() {
        return id;
    }
}
