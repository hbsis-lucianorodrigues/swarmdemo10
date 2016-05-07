package com.matthewcasperson.swarmdemo;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.wildfly.swarm.spi.api.ArtifactLookup;
import org.wildfly.swarm.spi.api.JARArchive;

import java.util.List;

/**
 * Created by matthewcasperson on 7/05/2016.
 */
public class ArchiveBuilder {
    public Archive buildArchive() throws Exception {
        final JARArchive ejbArchive = ShrinkWrap.create(JARArchive.class);
        ejbArchive.addClass(MyEJB.class);

        /*
            Merge in the dependencies that the warm build plugin included in the Swarm UberJar
            into an MyEJB UberJar. This gives us a self contained MyEJB JAR file that Swarm can then
            deploy and run.
         */
        final List<JavaArchive> artifacts = ArtifactLookup.get().allArtifacts(new String[]{"org.wildfly.swarm"});
        for (final JavaArchive javaArchive : artifacts) {
            ejbArchive.merge(javaArchive);
        }

        return ejbArchive;
    }
}
