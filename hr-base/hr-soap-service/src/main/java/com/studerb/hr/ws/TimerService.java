package com.studerb.hr.ws;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface TimerService {

    @WebMethod
    @WebResult(partName = "theResult")
    String getTimeAsString();

    @WebMethod
    @WebResult(partName = "theResult")
    Long getTimeAsElapsed();
}
