package com.studerw.jmsTest;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionMetaData;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JndiTest {
    final Logger log = Logger.getLogger(JndiTest.class);
    QueueConnectionFactory qcf;
    InitialContext iniCtx;

    @Before
    public void setup() throws Exception{
        iniCtx = new InitialContext();
    }

    @After
    public void teardown(){
        iniCtx = null;
    }

    @Test
    public void listEnv() throws Exception {
        Hashtable<?, ?> env = iniCtx.getEnvironment();
        log.debug(env.toString());
        for(Object key: env.keySet()){
            Object value = env.get(key);
            log.debug("Key Class: " + key.getClass().getName() + "   :     " + value.getClass().getName());
            log.debug("key: " + key.toString() + " :  " + value.toString());
            log.debug("-------------------");
        }
    }

    @Test
    public void listChildren() throws Exception {
        log.debug("listing ROOT Context \"\" ");
        NamingEnumeration<NameClassPair> childEnum = iniCtx.list("");
        assertNotNull(childEnum);
        while(childEnum.hasMore()){
            NameClassPair ncPair = childEnum.next();
            log.debug(ncPair.getName(  ) + " (type " + ncPair.getClassName() + ")");
        }

    }

    @Test
    public void listJMX() throws Exception {
        log.debug("listing JMS");
        NamingEnumeration<NameClassPair> childEnum = iniCtx.list("jmx");
        assertNotNull(childEnum);
        while(childEnum.hasMore()){
            NameClassPair ncPair = childEnum.next();
            log.debug(ncPair.getName(  ) + " (type " + ncPair.getClassName() + ")");
        }

    }

    @Test
    public void listQueue() throws Exception {
        log.debug("listing Queue");
        NamingEnumeration<NameClassPair> childEnum = iniCtx.list("queue");
        assertNotNull(childEnum);
        while(childEnum.hasMore()){
            NameClassPair ncPair = childEnum.next();
            log.debug(ncPair.getName(  ) + " (type " + ncPair.getClassName() + ")");
        }

    }

}
