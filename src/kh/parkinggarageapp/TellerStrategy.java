/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;

/**
 * interface for tellers
 * issues and claims tickets, and sends other special messages
 * @author Keiji
 */
public interface TellerStrategy {
    /**
     * issues a ticket to a car
     * @param c the Car object to give the ticket to
     * @param start a Calendar object with the starting time
     */
    public abstract void issueTicket(Car c, Calendar start, DateTimeStrat dts);
    
    /**
     * claims a ticket from a car and collects a fee according to the FeeStrategy
     * @param c the Car object to take the ticket from
     * @param end a Calendar object representing when the car exited
     * @param fee the FeeStrategy being used to calculate the fee
     */
    public abstract void claimTicket(Car c, Calendar end, FeeStrategy fee);
    public abstract void sendFullMessage();
    public abstract void sendTowedMessage();
}
