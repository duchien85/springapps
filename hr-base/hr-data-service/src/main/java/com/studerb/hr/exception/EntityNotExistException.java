package com.studerb.hr.exception;

/**
 * Exception to be thrown when a service method is called on with an id of an
 * entity that does not exist in the persistant backend
 * 
 * @author studerb
 * 
 */
public class EntityNotExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityNotExistException(String string) {
        super(string);
    }

}
