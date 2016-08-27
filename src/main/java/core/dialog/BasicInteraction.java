package core.dialog;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

public class BasicInteraction implements Interaction {

	private final OptionList<ExecutableOption> optionList;
	private final boolean isFinal;

	public BasicInteraction(OptionList<ExecutableOption> optionList, boolean isFinal){
		this.optionList = optionList;
		this.isFinal = isFinal;
	}

	@Override
	public OptionList<ExecutableOption> getInteractionOptions() {
		return optionList;
	}

	@Override
	public boolean isFinal() {
		return isFinal;
	}
}
