package com.divups.ead.Errors;

public class BusOwnerNotFound extends Exception{

    public BusOwnerNotFound(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public BusOwnerNotFound(String exMessage) {
        super(exMessage);
    }

}
