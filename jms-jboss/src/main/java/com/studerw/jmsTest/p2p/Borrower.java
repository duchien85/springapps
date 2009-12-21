package com.studerw.jmsTest.p2p;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;

public class Borrower implements MessageListener {
    final static Logger log  = Logger.getLogger(Borrower.class);
    private QueueConnection queueConn;
    private InitialContext initialContext;
    private QueueConnectionFactory  queueConnFactory;
    private QueueSession queueSession;
    private Queue requestQueue;
    private Queue receiveQueue;

    private final static String LEND_REQUEST = "queue/A";
    private final static String LEND_RECEIVE = "queue/B";

    public void onMessage(Message message)  {
        try {
            log.debug("received message: " + message.getJMSMessageID());
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public Borrower() throws Exception {
        log.info("creating borrower, context, queueConnFactory, and Connection");
        Properties env = new Properties( );
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        env.put(Context.PROVIDER_URL,"jnp://localhost:1099");
        env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");

        initialContext = new InitialContext(env);

        queueConnFactory = (QueueConnectionFactory)initialContext.lookup("/ConnectionFactory");
        queueConn = queueConnFactory.createQueueConnection();
        queueSession = queueConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        requestQueue = (Queue)initialContext.lookup(LEND_REQUEST);
        receiveQueue = (Queue)initialContext.lookup(LEND_RECEIVE);
        queueConn.start();
    }

    public void borrow(int loanAmt) throws Exception{
        log.debug("sending loan request for: $" + loanAmt + " to destination: " + LEND_REQUEST);
        QueueSender sender = queueSession.createSender(requestQueue);
        Message msg = queueSession.createTextMessage(String.valueOf(loanAmt));
        sender.send(msg);
        String filter = "JMSCorrelationID = '" + msg.getJMSMessageID() + "'";
        receiveResponse(filter);
    }

    protected void receiveResponse(String filter) throws JMSException{
        log.debug("waiting for response for loan using filter: " + filter);
        QueueReceiver receiver = queueSession.createReceiver(receiveQueue, filter);
        TextMessage msg = (TextMessage)receiver.receive();
        if (msg == null){
            log.warn("Error receiving message - timeout");
        }
        else {
            log.info("Received response: " + msg.getText());
        }
    }

    public void stop(){
        try {
            if (queueConn != null){
                queueConn.stop();
            }
        }
        catch (Exception e) {
            log.warn("Error stopping queue connection");
        }
    }

    public static void main(String[] args) {
        Borrower borrower = null;
        try {
            borrower = new Borrower();
            borrower.borrow(RandomUtils.nextInt(100));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        finally {
            borrower.stop();
        }
        System.exit(0);
    }

}
