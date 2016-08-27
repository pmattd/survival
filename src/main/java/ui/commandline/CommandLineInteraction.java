package ui.commandline;

import java.util.Optional;

import com.google.inject.Inject;

import core.boundary.options.DisplayableOption;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import ui.framework.InputNotAcceptableException;
import ui.framework.OptionBindings;
import ui.framework.OptionNotAvailableException;

/**
 * Created by Pete on 31/05/2016.
 */
public class CommandLineInteraction {


	private final CommandLineOptionsDisplay commandLineOptionsDisplay;

	@Inject
	public CommandLineInteraction(CommandLineOptionsDisplay commandLineOptionsDisplay) {
		this.commandLineOptionsDisplay = commandLineOptionsDisplay;
	}

	public <T extends DisplayableOption> OptionBindings<T> proposeOptions(OptionList<T> optionList) {
		OptionBindings<T> dialogOptions = new OptionBindings<>(optionList.getOptions());

		commandLineOptionsDisplay.displayOptions(dialogOptions,optionList.getHeader());
		return dialogOptions;
	}

	public void processExecutableOption(OptionBindings<ExecutableOption> dialogOptions, String userInput) {
		Optional<ExecutableOption> executableOption = getOptionCorrespondingToUserInput(dialogOptions, userInput);
		executableOption.ifPresent(ExecutableOption::execute);
	}

	public <T> Optional<T> getOptionCorrespondingToUserInput(OptionBindings<T> dialogOptions,String userInput) {
		try{
			return Optional.of(dialogOptions.getOption(userInput));
			//option.execute();
		}catch (InputNotAcceptableException e){
			System.out.println("command not recognised");
		}catch (OptionNotAvailableException e){
			System.out.println("this option is not available");
		}
		return Optional.empty();
	}
}
