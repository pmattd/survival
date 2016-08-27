package core.boundary.options;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pete on 23/08/2016.
 */
public class CategorisedOptions {

    private final HashMap<OptionCategory,OptionList<ExecutableOption>> allOptions;

    public CategorisedOptions(HashMap<OptionCategory, OptionList<ExecutableOption>> allOptions) {
        this.allOptions = allOptions;
    }

    public OptionList<ExecutableOption> getOptionsByCategory(OptionCategory optionCategory){
        return allOptions.get(optionCategory);
    }

    public List<OptionCategory> getSortedCategories() {

        return allOptions.keySet().stream()
                .sorted((c1, c2) -> Integer.compare(c1.getOptionType().ordinal(), c2.getOptionType().ordinal()))
                .collect(Collectors.toList());
    }
}
