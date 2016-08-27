package core.gamestate;

/**
 * Created by Pete on 29/07/2016.
 */

public class InvalidGameStateChangeException extends RuntimeException {

    public InvalidGameStateChangeException(String msg){
        super(msg);
    }

}
