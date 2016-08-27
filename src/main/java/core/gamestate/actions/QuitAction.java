package core.gamestate.actions;

import com.google.inject.Singleton;

/**
 * Created by Pete on 26/08/2016.
 */
@Singleton
public class QuitAction implements Action{


    @Override
    public void run() {
        System.exit(0);
    }
}
