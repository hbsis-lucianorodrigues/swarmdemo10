package com.matthewcasperson.swarmdemo;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.spi.api.ArtifactLookup;
import org.wildfly.swarm.spi.api.JARArchive;

import java.util.List;

/**
 * Created by matthewcasperson on 2/05/2016.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        final Container container = new Container();
        container.start();

        final Archive ejbArchive = new ArchiveBuilder().buildArchive();

        // Deploy your app
        container.deploy(ejbArchive);
    }
}
