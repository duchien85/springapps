package com.studerb.hr.ws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class TimeServiceClient {
    final static Logger log = Logger.getLogger(TimeServiceClient.class);

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9876/ts?wsdl");
            QName qname = new QName("http://ws.hr.studerb.com/", "TimeServiceImpService");
            Service service = Service.create(url, qname);
            TimerService eif = service.getPort(TimerService.class);
            log.info("TimerService.getTimeAsString(): " + eif.getTimeAsString());
            log.info("TimerService.getTimeElapsed(): " + eif.getTimeAsElapsed());
        }
        catch (Exception e) {
            log.warn(ExceptionUtils.getRootCauseMessage(e));
            System.exit(1);
        }
        System.exit(0);
    }
}
