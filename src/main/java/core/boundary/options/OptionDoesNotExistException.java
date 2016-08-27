package core.boundary.options;

/**
 * Created by Pete on 26/08/2016.
 */
public class OptionDoesNotExistException extends RuntimeException{
    public OptionDoesNotExistException(String msg) {
        super(msg);
    }
}
