package core.area.relocation;

import core.area.CurrentLocation;
import core.area.Location;
import core.gamestate.actions.Action;

/**
 * Created by Pete on 18/08/2016.
 */
public class RelocationAction implements Action{
    private final CurrentLocation currentLocation;
    private final Location targetLocation;

    public RelocationAction(CurrentLocation currentLocation, Location targetLocation) {
        this.currentLocation = currentLocation;
        this.targetLocation = targetLocation;
    }

    @Override
    public void run() {
        this.currentLocation.setLocation(targetLocation);
    }
}
