package core.area.travel;

import core.area.Area;
import core.area.Location;
import core.area.travel.TravelInterceptor;

/**
 * Created by Pete on 06/06/2016.
 */
public class Direction {

    private final String text;
    private final Location destination;
    private final TravelInterceptor travelInterceptor;

    public Direction(String text, Location arrivalLocation, TravelInterceptor travelInterceptor) {
        this.text = text;
        this.destination = arrivalLocation;
        this.travelInterceptor = travelInterceptor;
    }

    public String getText() {
        return text;
    }

    public Location travel(){
        return travelInterceptor.intercept(this).orElse(destination);
    }

}
