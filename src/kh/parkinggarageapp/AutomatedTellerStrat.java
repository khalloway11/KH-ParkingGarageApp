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
    private OutputStrategy outputStrat;
    
    public AutomatedTellerStrat(){
        runningTotal = 0;
    }

    /**
     * punches in a ticket and issues it to the car
     * @param c
     * @param t
     * @param startHour
     * @param startMin 
     */
    public void issueTicket(Car c, double startHour, double startMin){
        if(c.getTicket() == null){
            Ticket t = new Ticket();
            t.punchIn(startHour, startMin);
            c.setTicket(t);
        }
    }
    
    /**
     * claims the ticket from a departing car and collects the amount owed.
     * @param c
     * @param endHour
     * @param endMin 
     */
    public void claimTicket(Car c, double endHour, double endMin, FeeStrategy fee){
        c.getTicket().punchOut(endHour, endMin);
        double collected = fee.calculateFee(c.getTicket().getStartHour(), c.getTicket().getStartMin(), endHour, endMin);
        runningTotal += collected;
        outputStrat.makeTicketOutput(c.getId(), collected, runningTotal);
    }
    
    public void sendFullMessage(){
        outputStrat.makeOutput("No spaces available");
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
