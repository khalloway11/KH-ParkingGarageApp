/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 *
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
    
    
}
