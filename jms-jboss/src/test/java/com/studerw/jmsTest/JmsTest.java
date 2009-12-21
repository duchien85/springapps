package com.studerw.jmsTest;

import static org.junit.Assert.*;

import java.util.Enumeration;

import javax.jms.ConnectionMetaData;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JmsTest {

    final Logger log = Logger.getLogger(JmsTest.class);
    QueueConnectionFactory qcf;
    QueueConnection conn;
    InitialContext iniCtx;

    @Before
    public void setup() throws Exception {
        iniCtx = new InitialContext();
        qcf = (QueueConnectionFactory)iniCtx.lookup("QueueConnectionFactory");
        assertNotNull(qcf);
        conn = qcf.createQueueConnection();
    }

    @After
    public void teardown() {
        qcf = null;
        try {
            conn.stop();
            conn.close();

        }
        catch (JMSException e) {
            e.printStackTrace();
        }
        finally {
            conn = null;
        }
    }

    @Test
    public void connect() throws Exception {
        assertNotNull(conn);
        conn.start();
        conn.stop();
    }

    @Test
    public void metadata() throws Exception {
        ConnectionMetaData meta = conn.getMetaData();
        log.info("JMS Major.Minor: " + meta.getJMSMajorVersion() + "." + meta.getJMSMinorVersion());
        log.info("JMS PROVIDER: " + meta.getJMSProviderName() + " : " + meta.getProviderVersion());
        log.info("JMSX Properties Supported");
        Enumeration e = meta.getJMSXPropertyNames();
        while(e.hasMoreElements()){
            log.info("\t" + e.nextElement());
        }
    }

    @Test
    public void createSession() throws Exception {
        //conn.cre
    }
}
