package core.area;

import core.area.supplies.SupplyCache;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

/**
 * Created by Pete on 15/06/2016.
 */
public interface Location {

    String getTitle();

    LocationDescription getDescription();

    SupplyCache scavenge();

    OptionList<ExecutableOption> getTravelOptions();

    OptionList<ExecutableOption> getScavengeOptions();

    OptionList<ExecutableOption> getRelocationOptions();

    void arrive();
}
