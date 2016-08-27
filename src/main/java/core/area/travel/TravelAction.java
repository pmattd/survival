package core.area.travel;

import core.area.CurrentLocation;
import core.area.Location;
import core.gamestate.GameStateMachine;
import core.gamestate.actions.Action;
import core.gamestate.states.TravelState;

/**
 * Created by Pete on 29/07/2016.
 */
public class TravelAction implements Action {

    private final GameStateMachine gameStateMachine;
    private final CurrentLocation currentLocation;
    private final Direction direction;
    private final TravelState travelState;


    public TravelAction(GameStateMachine gameStateMachine, CurrentLocation currentLocation, Direction direction, TravelState travelState) {
        this.gameStateMachine = gameStateMachine;
        this.currentLocation = currentLocation;
        this.direction = direction;
        this.travelState = travelState;
    }

    public void run() {
        gameStateMachine.setState(travelState);
        Location destination = direction.travel();
        currentLocation.setLocation(destination);
    }
}
