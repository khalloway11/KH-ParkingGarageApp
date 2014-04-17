/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * interface for tellers
 * issues and claims tickets, and sends other special messages
 * @author Keiji
 */
public interface TellerStrategy {
    /**
     * issues a ticket to a car
     * @param c the Car object to give the ticket to
     * @param startHour the time the car entered the garage (hour)
     * @param startMin  the time the car entered the garage (minute)
     */
    public abstract void issueTicket(Car c, double startHour, double startMin);
    
    /**
     * claims a ticket from a car and collects a fee according to the FeeStrategy
     * @param c the Car object to take the ticket from
     * @param endHour the time the car exited the garage (hour)
     * @param endMin  the time the car exited the garage (minute)
     */
    public abstract void claimTicket(Car c, double endHour, double endMin, FeeStrategy fee);
    public void sendFullMessage();
    public void sendTowedMessage();
}
