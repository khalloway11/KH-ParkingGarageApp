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
public class AutomatedTellerStrat implements TellerStrategy {
    private static double runningTotal;
    private FeeStrategy feeStrat;
    private OutputStrategy outputStrat;
    
    public AutomatedTellerStrat(){
        runningTotal = 0;
    }

    /**
     * creates a new ticket, punches it in, and issues it to a car
     * @param c
     * @param t
     * @param startHour
     * @param startMin 
     */
    public void issueTicket(Car c, Ticket t, double startHour, double startMin, FeeStrategy fee){
        t = new Ticket(fee);
        t.punchIn(startHour, startMin);
        c.setTicket(t);
    }
    
    /**
     * claims the ticket from a departing car and collects the amount owed.
     * @param c
     * @param endHour
     * @param endMin 
     */
    public void claimTicket(Car c, double endHour, double endMin){
        c.getTicket().punchOut(endHour, endMin);
        double collected = feeStrat.calculateFee(c.getTicket().getStartHour(), c.getTicket().getStartMin(), endHour, endMin);
        runningTotal += collected;
        outputStrat.makeTicketOutput(c.getId(), collected, runningTotal);
    }
    
    /**
     * getters and setters
     */
    public static double getRunningTotal() {
        return runningTotal;
    }

    public static void setRunningTotal(double runningTotal) {
        AutomatedTellerStrat.runningTotal = runningTotal;
    }
    
    
}
