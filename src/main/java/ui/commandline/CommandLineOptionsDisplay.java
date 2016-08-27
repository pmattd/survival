package ui.commandline;

import core.boundary.options.DisplayableOption;
import core.boundary.options.OptionCategory;
import ui.framework.OptionBindings;
import ui.framework.OptionMapping;
import ui.framework.OptionNotAvailableException;

import java.util.Optional;

public class CommandLineOptionsDisplay {

	public <T extends DisplayableOption> void displayOptions(OptionBindings<T> options, Optional<String> header) {
		header.ifPresent(x -> System.out.println(x));
		for (OptionMapping<T> optionMapping : options.getOptions()) {
			System.out.println(String.format("%d %s", optionMapping.getReference(), optionMapping.getOption().getDescription()));
		}
	}

}
