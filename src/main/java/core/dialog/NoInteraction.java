package core.dialog;

import static com.google.common.collect.Lists.newArrayList;

import com.google.inject.Singleton;

import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

import java.util.Optional;

/**
 * Created by Pete on 24/05/2016.
 */
@Singleton
public class NoInteraction implements Interaction {

    public OptionList<ExecutableOption> getInteractionOptions() {
        return new OptionList<>(Optional.empty(), newArrayList());
    }

    public boolean isFinal() {
        return true;
    }

}
