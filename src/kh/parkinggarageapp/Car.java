/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Objects;

/**
 * a car class that contains an id and a ticket
 * @author Keiji
 */
public class Car {
    private Ticket t;
    private String id;
    
    /**
     * every car has an ID and can have a ticket
     * @param t
     * @param id 
     */
    public Car(String id){
        this.setTicket(null);
        this.setId(id);
    }

    public Ticket getTicket() {
        return t;
    }

    public void setTicket(Ticket t) {
        this.t = t;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.t);
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.t, other.t)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "t=" + t + ", id=" + id + '}';
    }
    
    
}
