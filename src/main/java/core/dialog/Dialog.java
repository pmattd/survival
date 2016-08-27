package core.dialog;

/**
 * Created by Pete on 21/05/2016.
 */

public class Dialog {

    private final String id;
    private final Interaction start;

    public Dialog(String id, Interaction start){
        this.id=id;
        this.start = start;
    }

    public Interaction getFirstInteraction(){
        return start;
    }

    public String getId() {
        return id;
    }
}
