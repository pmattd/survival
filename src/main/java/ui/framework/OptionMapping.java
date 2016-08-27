package ui.framework;

/**
 * Created by Pete on 10/06/2016.
 */
public class OptionMapping<T> {

    private final int reference;
    private final T option;

    public OptionMapping(int reference, T option) {
        this.reference = reference;
        this.option = option;
    }

    public int getReference() {
        return reference;
    }

    public T getOption() {
        return option;
    }
}
