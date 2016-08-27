package core.boundary.options;

import com.google.inject.Inject;
import core.gamestate.actions.Action;
import core.gamestate.actions.NoAction;

import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Created by Pete on 23/08/2016.
 */
public class CategorisedOptionsBuilder {

    private final InterfaceOptionsStore interfaceOptionsStore;

    HashMap<OptionCategory,OptionList<ExecutableOption>> options;

    public CategorisedOptionsBuilder(InterfaceOptionsStore interfaceOptionsStore) {
        this.interfaceOptionsStore = interfaceOptionsStore;
        this.options = newHashMap();
    }

    public CategorisedOptionsBuilder withOptions(OptionCatagoryEnum category,OptionList<ExecutableOption> optionList){

        if(optionList == null || !optionList.isEmpty()) {
            options.put(interfaceOptionsStore.getOption(category), optionList);
        }
        return this;
    }

    public CategorisedOptionsBuilder withSpecializedInterfaceOption(OptionCatagoryEnum catagoryEnum){
        options.put(interfaceOptionsStore.getOption(catagoryEnum),new OptionList.Builder().build());
        return this;
    }

    public CategorisedOptionsBuilder withSingleOptionCategory(OptionCatagoryEnum catagoryEnum, String actionText, Action action){
        return this.withOptions(catagoryEnum, new OptionList.Builder().withOption(actionText,action).build());
    }

    public CategorisedOptions build(){
        return new CategorisedOptions(options);

    }

    public CategorisedOptions buildSpecializedStateOptions(OptionCatagoryEnum specializedOption){
        options.put(interfaceOptionsStore.getOption(specializedOption),new OptionList.Builder().withOption("dummy",new NoAction()).build());
       return new CategorisedOptions(options);

    }
}
