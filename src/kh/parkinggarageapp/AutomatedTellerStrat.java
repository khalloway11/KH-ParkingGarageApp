/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * TellerStrategy for automated tellers.
 * has an output strategy for delivering output
 * @author Keiji
 */
public class AutomatedTellerStrat implements TellerStrategy {
    private static final String FULL_MESSAGE = "Garage filled to capacity.";
    private static final String TOWED_MESSAGE = "Car was towed for staying over 24 hours.";
    private static double runningTotalCharged;
    private static double runningTotalTime;
    private OutputStrategy outputStrat;
    
    public AutomatedTellerStrat(OutputStrategy output){
        runningTotalCharged = 0;
        runningTotalTime = 0;
        outputStrat = output;
    }

    /**
     * punches in a ticket and issues it to the car
     * @param c
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
     * @param fee
     */
    public void claimTicket(Car c, double endHour, double endMin, FeeStrategy fee){
        c.getTicket().punchOut(endHour, endMin);
        double collected = fee.calculateFee(c.getTicket().getStartHour(), c.getTicket().getStartMin(), endHour, endMin);
        if(collected == -1){
            sendTowedMessage();
            return;
        }
        runningTotalCharged += collected;
        runningTotalTime += fee.getTimeParked(c.getTicket().getStartHour(), c.getTicket().getStartMin(), endHour, endMin);
        outputStrat.makeTicketOutput(c.getId(), fee.getName(), collected, fee.getTimeParked(c.getTicket().getStartHour(), c.getTicket().getStartMin(), endHour, endMin));
        outputStrat.makeReportOutput(fee.getName(), runningTotalCharged, runningTotalTime);
        c.setTicket(null);
    }
    
    public void sendFullMessage(){
        outputStrat.makeOutput(FULL_MESSAGE);
    }
    
    public void sendTowedMessage(){
        outputStrat.makeOutput(TOWED_MESSAGE);
    }
    
    /**
     * getters and setters
     */
    public static double getRunningTotalCharged() {
        return runningTotalCharged;
    }

    /**
     * 
     * @param runningTotal set the current running total
     */
    public static void setRunningTotalCharged(double runningTotal) {
        AutomatedTellerStrat.runningTotalCharged = runningTotal;
    }

    public static double getRunningTotalTime() {
        return runningTotalTime;
    }

    /**
     * 
     * @param runningTotalTime set the running total of time charged
     */
    public static void setRunningTotalTime(double runningTotalTime) {
        AutomatedTellerStrat.runningTotalTime = runningTotalTime;
    }
    
    
    
}
