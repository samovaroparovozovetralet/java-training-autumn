package org.java.training.autumn;

public class AlreadyConnectedException extends Exception{
    private Connectable thisOne;
    private Connectable otherOne;

    public AlreadyConnectedException(String message,
                                     Connectable thisOne, Connectable otherOne){
        super(message);
        this.thisOne = thisOne;
        this.otherOne = otherOne;
    }

    public AlreadyConnectedException(String message,
                                     Connectable thisOne){
        super(message);
        this.thisOne = thisOne;
        this.otherOne = thisOne;
    }

    public Connectable getThisOne(){return thisOne;}
    public Connectable getOtherOne(){return otherOne;}
}
