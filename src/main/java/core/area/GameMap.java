package core.area;

import com.google.inject.Inject;
import com.google.inject.ProvidedBy;
import main.providers.GameMapProvider;

/**
 * Created by Pete on 29/07/2016.
 */
@ProvidedBy(GameMapProvider.class)
public class GameMap {

    private final Area startLocation;

    @Inject
    public GameMap(Area startLocation) {
        this.startLocation = startLocation;
    }

    public Area getStartLocation(){
        return startLocation;
    }

}
