package com.matthewcasperson.swarmdemo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by matthewcasperson on 7/05/2016.
 */
@RunWith(Arquillian.class)
public class SwarmTest {
    @EJB
    private MyEJB myEjb;

    @Deployment
    public static Archive createDeployment() throws Exception {
        return new ArchiveBuilder().buildArchive();
    }

    @Test
    public void testDoingSomeEnterprisyThing() {
        Assert.assertTrue(myEjb.doSomeEnterprisyThing());
    }
}
