package core.combat;

import com.google.inject.Inject;

/**
 * Created by Pete on 09/08/2016.
 */
public class CurrentHostileGroup {
    private HostileGroup group;

    public void setGroup(HostileGroup group) {
        this.group = group;
    }


    @Inject
    public CurrentHostileGroup(){

    }
}
