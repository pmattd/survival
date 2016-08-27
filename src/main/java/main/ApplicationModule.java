package main;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import core.config.parser.ConfigParser;
import core.config.xml.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Pete on 21/05/2016.
 */
@Singleton
public class ApplicationModule extends AbstractModule {

    private Logger logger = LoggerFactory.getLogger(ApplicationModule.class);

    @Override
    protected void configure() {
    }

}
