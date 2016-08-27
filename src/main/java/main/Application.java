package main;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ui.commandline.GameCommandLine;

/**
 * Created by Pete on 21/05/2016.
 */
public class Application {
    public static void main(String[] args){
        Application application = new Application();
        application.startUp();
    }

    private void startUp() {

            Injector injector = Guice.createInjector(new ApplicationModule());
            GameCommandLine gameCommandLine = injector.getInstance(GameCommandLine.class);
            gameCommandLine.run();
    }




}
