package core.dialog;

/**
 * Created by Pete on 21/05/2016.
 */
public class InteractionOption {

    private final Interaction nextInteraction;
    private final String text;

    public InteractionOption(String text, Interaction nextInteraction) {
        this.nextInteraction = nextInteraction;
        this.text = text;
    }

    public Interaction getNextInteraction(){
        return nextInteraction;
    }

    public String getText() {
        return text;
    }
}
