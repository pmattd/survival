package core.area.travel;

import com.google.inject.Inject;
import core.area.CurrentLocation;
import core.gamestate.GameStateMachine;
import core.gamestate.states.TravelState;

/**
 * Created by Pete on 29/07/2016.
 */
public class TravelActionFactory {

    private final GameStateMachine gameStateMachine;
    private final CurrentLocation currentLocation;
    private final TravelState travelState;

    @Inject
    public TravelActionFactory(GameStateMachine gameStateMachine, CurrentLocation currentLocation, TravelState travelState) {
        this.gameStateMachine = gameStateMachine;
        this.currentLocation = currentLocation;
        this.travelState = travelState;
    }

    public TravelAction build(Direction direction){

        return new TravelAction(gameStateMachine,currentLocation,direction, travelState);
    }
}
