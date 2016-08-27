package core.boundary.options;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.jar.Pack200;

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

    public Set<OptionCategory> getAllCategories(){
        return allOptions.keySet();
    }
}
