package core.area.scavenge;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.area.Location;
import core.boundary.options.ExecutableOption;
import core.gamestate.GameStateMachine;
import core.gamestate.states.ScavengeState;
import core.hero.Party;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pete on 29/07/2016.
 */
@Singleton
public class ScavengeLocationOptionsFactory {

    private final GameStateMachine gameStateMachine;
    private final Party party;
    private final ScavengeState scavengeState;

    @Inject
    public ScavengeLocationOptionsFactory(GameStateMachine gameStateMachine, Party party, ScavengeState scavengeState) {
        this.gameStateMachine = gameStateMachine;
        this.party = party;
        this.scavengeState = scavengeState;
    }

    public List<ExecutableOption> build(List<Location> locations){
        return locations.stream()
                .map(location -> scavengeAction(location))
                .collect(Collectors.toList());
    }

    private ScavengeLocationAction build(Location location){
        return new ScavengeLocationAction(gameStateMachine,location, party, scavengeState);
    }

    private ExecutableOption scavengeAction(Location location) {
        return new ExecutableOption(location.getTitle(), build(location));
    }



}
