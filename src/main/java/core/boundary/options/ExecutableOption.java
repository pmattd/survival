package core.boundary.options;

import core.gamestate.actions.Action;

public class ExecutableOption implements DisplayableOption {

	private final Action action;
	private final String text;

	public ExecutableOption(String text, Action action){
		this.action = action;
		this.text = text;
	}

	public void execute(){
		action.run();
	}

	public String getDescription() {
		return text;
	}
}
