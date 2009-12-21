package com.studerw.jmsTest.p2p;

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
import javax.naming.InitialContext;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;

public class Lender implements MessageListener {
    final static Logger log  = Logger.getLogger(Lender.class);
    private QueueConnection queueConn;
    private InitialContext initialContext;
    private QueueConnectionFactory  queueConnFactory;
    private QueueSession queueSession;
    private Queue receiveQueue;
    private Queue respondQueue;

    private final static String LEND_RECEIVE= "queue/A";
    private final static String LEND_RESPOND = "queue/B";

    public void onMessage(Message message)  {
        try {
            log.debug("received message: " + message.getJMSMessageID());
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public Lender() throws Exception {
        log.info("creating lender, context, queueConnFactory, and Connection");
        initialContext = new InitialContext();
        queueConnFactory = (QueueConnectionFactory)initialContext.lookup("/ConnectionFactory");
        queueConn = queueConnFactory.createQueueConnection();
        queueSession = queueConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        receiveQueue = (Queue)initialContext.lookup(LEND_RECEIVE);
        respondQueue = (Queue)initialContext.lookup(LEND_RESPOND);
        queueConn.start();
    }

    public void lend(int minAmt) throws Exception{
        log.debug("Listening for loan request greater than: $" + minAmt + " from destination: " + LEND_RECEIVE);
        QueueReceiver receiver = queueSession.createReceiver(receiveQueue);
        TextMessage msg = (TextMessage)receiver.receive();
        String messageId = msg.getJMSMessageID();
        int amount = Integer.parseInt(msg.getText());
        String response;
        if (amount >= minAmt){
            log.info("Amount: " + amount +  " worthy of a loan");
            response = "YES";
        }
        else {
            log.info("Amount: " + amount + "too low");
            response = "NO";
        }
        sendResponse(messageId, response);
    }

    protected void sendResponse(String messageId, String response) throws JMSException{
        log.info("Sending response: " + response + " with coorelationID: " + messageId);
        QueueSender sender = queueSession.createSender(respondQueue);
        Message msg = queueSession.createTextMessage(response);
        msg.setJMSCorrelationID(messageId);
        sender.send(msg);
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
        Lender lender = null;
        try {
            lender = new Lender();
            lender.lend(RandomUtils.nextInt(100));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        finally {
            lender.stop();
        }
        System.exit(0);
    }

}
