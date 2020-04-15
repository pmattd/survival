package core.area;

import core.area.supplies.SupplyCache;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

/**
 * Created by Pete on 29/07/2016.
 */
class NoLocation implements Location {
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
        return OptionList.empty();
    }

    @Override
    public OptionList<ExecutableOption> getScavengeOptions() {
        return OptionList.empty();
    }

    @Override
    public OptionList<ExecutableOption> getRelocationOptions() {
        return OptionList.empty();
    }

    @Override
    public void arrive() {
        //todo throw exception
    }
}
