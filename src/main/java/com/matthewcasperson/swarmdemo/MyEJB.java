package com.matthewcasperson.swarmdemo;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple MyEJB that will log to the console when it is started up. Note that
 * we make use of o=some third party libraries (Apache Commons Lang in this case)
 * just to prove that we can build a self contained MyEJB JAR file.
 */
@Startup
@Singleton
public class MyEJB {
    private static final Logger LOGGER = Logger.getLogger(MyEJB.class.getName());

    @PostConstruct
    private void postConstruct() {
        LOGGER.log(Level.INFO, "MyEJB.postConstruct()");
    }

    public boolean doSomeEnterprisyThing() {
        LOGGER.log(Level.INFO, "Some Enterprisy Thing");
        return true;
    }
}
