package com.studerb.hr.ws;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "com.studerb.hr.ws.TimerService")
public class TimeServiceImp implements TimerService {

    @Override
    public Long getTimeAsElapsed() {
        return new Date().getTime();
    }

    @Override
    public String getTimeAsString() {
        Date d = new Date();
        return d.toString();
    }

}
