package core.dialog;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

import java.util.List;

/**
 * Created by Pete on 21/05/2016.
 */
public interface Interaction {

	OptionList<ExecutableOption> getInteractionOptions();

	boolean isFinal();
}
