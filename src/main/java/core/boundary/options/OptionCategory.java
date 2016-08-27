package core.boundary.options;

public class OptionCategory implements DisplayableOption {
	private final OptionCatagoryEnum optionType;
	private final String description;

	public OptionCategory(OptionCatagoryEnum optionCatagoryEnum, String description) {
		optionType = optionCatagoryEnum;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public OptionCatagoryEnum getOptionType() {
		return optionType;
	}

}
