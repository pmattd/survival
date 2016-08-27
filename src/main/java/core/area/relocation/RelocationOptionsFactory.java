package core.area.relocation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.area.CurrentLocation;
import core.area.Location;
import core.boundary.options.ExecutableOption;
import core.gamestate.GameStateMachine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pete on 18/08/2016.
 */
@Singleton
public class RelocationOptionsFactory {
    private final GameStateMachine gameStateMachine;
    private final CurrentLocation currentLocation;

    @Inject
    public RelocationOptionsFactory(GameStateMachine gameStateMachine, CurrentLocation currentLocation) {
        this.gameStateMachine = gameStateMachine;
        this.currentLocation = currentLocation;
    }


    public List<ExecutableOption> build(List<Location> locations) {
        return locations.stream()
                        .map(location -> relocationAction(location))
                        .collect(Collectors.toList());
    }

    private ExecutableOption relocationAction(Location location) {
        return new ExecutableOption(location.getTitle(), build(location));
    }

    private RelocationAction build(Location location){
        return new RelocationAction(currentLocation,location);
    }
}
