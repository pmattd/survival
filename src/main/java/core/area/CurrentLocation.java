package core.area;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by Pete on 29/07/2016.
 */
@Singleton
public class CurrentLocation {

    private Location location;

    @Inject
    public CurrentLocation(){
        this.location = new NoLocation();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        location.arrive();
    }

    public LocationDescription getLocationDescription() {
        return location.getDescription();
    }

}
