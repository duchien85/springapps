package com.studerb.hr.ws;

import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

public class TimeServicePublisher {
    final static Logger logger = Logger.getLogger(TimeServicePublisher.class);
    final static String ENDPOINT = "http://127.0.0.1:9876/ts";

    public static void main(String[] args) {
        logger.info("publishing TimerService to " + ENDPOINT);
        Endpoint.publish(ENDPOINT, new TimeServiceImp());
    }
}
