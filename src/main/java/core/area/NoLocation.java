package core.area;

import core.area.supplies.SupplyCache;
import core.area.travel.ArrivalAction;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Pete on 29/07/2016.
 */
public class NoLocation implements Location {
    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public LocationDescription getDescription() {
        return new LocationDescription("","");
    }

    @Override
    public SupplyCache scavenge() {
        return null;
    }

    @Override
    public OptionList<ExecutableOption> getTravelOptions() {
        return OptionList.emptyList();
    }

    @Override
    public OptionList<ExecutableOption> getScavengeOptions() {
        return OptionList.emptyList();
    }

    @Override
    public ArrivalAction getArrivalAction() {
        return null;
    }

    @Override
    public OptionList<ExecutableOption> getRelocationOptions() {
        return OptionList.emptyList();
    }
}
