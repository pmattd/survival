package core.area;

public class LocationDescription {

	private final String AreaDescription;
	private final String LocationDescription;

	public LocationDescription(String areaDescription, String locationDescription) {
		AreaDescription = areaDescription;
		LocationDescription = locationDescription;
	}

	public String getAreaDescription() {
		return AreaDescription;
	}

	public String getLocationDescription() {
		return LocationDescription;
	}
}
