package core.area;

import core.area.relocation.RelocationOptionsFactory;
import core.area.supplies.SupplyCache;
import core.area.travel.ArrivalAction;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

public class BasicLocation implements Location{
	private final String description;
	private final Area area;
	private final SupplyCache supplyCache;
	private final String title;
	private final OptionList<ExecutableOption> travelOptions;
	private final ArrivalAction arrivalAction;
	private final RelocationOptionsFactory relocationOptionsFactory;

	public BasicLocation(String title,
						 String description,
						 Area area,
						 SupplyCache supplyCache,
						 ArrivalAction arrivalAction,
						 OptionList<ExecutableOption> travelOptions,
						 RelocationOptionsFactory relocationOptionsFactory) {
		this.description = description;
		this.area = area;
		this.supplyCache = supplyCache;
		this.title = title;
		this.travelOptions = travelOptions;
		this.arrivalAction = arrivalAction;
		this.relocationOptionsFactory = relocationOptionsFactory;
	}

	@Override
	public String getTitle() {
		return title;
	}

	public LocationDescription getDescription() {
		return new LocationDescription(area.getText(),description);
	}

	public SupplyCache scavenge(){
		return supplyCache;
	}

	@Override
	public OptionList<ExecutableOption> getTravelOptions(){
		return travelOptions;
	}

	@Override
	public OptionList<ExecutableOption> getScavengeOptions() {
		return area.getScavengeOptions();
	}


	@Override
	public OptionList<ExecutableOption> getRelocationOptions() {
		return new OptionList<>(relocationOptionsFactory.build(area.getOtherLocations(this)));
	}

	@Override
	public void arrive() {
		arrivalAction.run();
	}

}
