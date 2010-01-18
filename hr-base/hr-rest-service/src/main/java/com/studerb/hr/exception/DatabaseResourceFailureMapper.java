package com.studerb.hr.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

@Component
@Provider
public class DatabaseResourceFailureMapper implements ExceptionMapper<DataAccessResourceFailureException> {

    @Override
    public Response toResponse(DataAccessResourceFailureException exception) {
        Response r = Response.status(Status.SERVICE_UNAVAILABLE).build();
        return r;
    }
}
