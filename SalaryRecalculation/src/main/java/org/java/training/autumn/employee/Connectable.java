package org.java.training.autumn.employee;

import org.java.training.autumn.exceptions.AlreadyConnectedException;

import java.util.ArrayList;

public interface Connectable {
    public ArrayList<Connectable> getConnections();
    public void connectTo(Connectable item) throws AlreadyConnectedException;
    public void disconnectFrom(Connectable item);

}
