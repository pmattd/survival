package main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.commandline.GameCommandLine;

/**
 * Created by Pete on 21/05/2016.
 */
public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args){
        Application application = new Application();
        application.startUp();
    }

    private void startUp() {

            Injector injector = Guice.createInjector(new ApplicationModule());
            GameCommandLine gameCommandLine = injector.getInstance(GameCommandLine.class);
        try {
            gameCommandLine.run();
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }




}
