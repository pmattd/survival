package core.gamestate.states;

import com.google.inject.Inject;
import core.area.CurrentLocation;
import core.boundary.options.*;

import static core.boundary.options.OptionCatagoryEnum.*;

/**
 * Created by Pete on 21/07/2016.
 */
public class LocationState implements GameState {

    private final CurrentLocation currentLocation;
    private final CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory;

    @Inject
    public LocationState(CurrentLocation currentLocation, CategorisedOptionsBuilderFactory categorisedOptionsBuilderFactory) {
        this.currentLocation = currentLocation;
        this.categorisedOptionsBuilderFactory = categorisedOptionsBuilderFactory;
    }

    @Override
    public CategorisedOptions getCurrentOptions() {

        return categorisedOptionsBuilderFactory.create()
                .withOptions(SCAVENGE, getScavengeOptions())
                .withOptions(TRAVEL, getTravelOptions())
                .withOptions(RELOCATE, getRelocationOptions())
                .build();

    }

    private OptionList<ExecutableOption> getScavengeOptions() {
        return currentLocation.getLocation().getScavengeOptions();
    }

    private OptionList<ExecutableOption> getTravelOptions() {
        return currentLocation.getLocation().getTravelOptions();
    }

    public OptionList<ExecutableOption> getRelocationOptions() {
        return currentLocation.getLocation().getRelocationOptions();
    }
}
