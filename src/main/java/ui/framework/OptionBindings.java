package ui.framework;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pete on 10/06/2016.
 */
public class OptionBindings<T> {

    private List<OptionMapping<T>> optionsList;

    public OptionBindings(List<T> options){
        optionsList = options.stream().map(s -> new OptionMapping<T>(options.indexOf(s), s)).collect(Collectors.toList());
    }


    public List<OptionMapping<T>> getOptions(){
        return optionsList;
    }

    public T getOption(String input){
        try {
            Integer index = Integer.valueOf(input);
            return getOption(index);
        }catch (NumberFormatException i){
            throw new InputNotAcceptableException(input,i);
        }
    }

    private T getOption(Integer i) {
        return optionsList.stream()
                .filter(option -> option.getReference() == i).map(option -> option.getOption())
                .findFirst()
                .orElseThrow(() -> new OptionNotAvailableException("option " + i));
    }


}
