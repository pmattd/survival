package core.area;

import static com.google.common.collect.Lists.newArrayList;

import core.area.supplies.SupplyCache;
import core.area.travel.ArrivalAction;
import core.area.travel.Direction;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

public class TemporaryLocation implements Location {

	private final String text;
	private final Direction back;
	private final Direction onwards;
	private final SupplyCache noSupplies;

	public TemporaryLocation(String text, Direction back, Direction onwards, SupplyCache supplyCache){
		this.onwards = onwards;
		this.back = back;
		this.text = text;
		this.noSupplies = supplyCache;
	}

	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public LocationDescription getDescription() {
		return new LocationDescription("",text);
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
