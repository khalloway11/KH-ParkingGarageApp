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
public interface TellerStrategy {
    /**
     * issues a ticket to a car
     * @param c
     * @param t 
     */
    public abstract void issueTicket(Car c, double startHour, double startMin);
    
    /**
     * claims a ticket from a car and collects the fee
     * @param c
     * @param t 
     */
    public abstract void claimTicket(Car c, double endHour, double endMin, FeeStrategy fee);
}
