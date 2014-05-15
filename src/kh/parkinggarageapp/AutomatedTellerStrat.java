/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;
import java.util.Objects;

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
    private DateTimeStrat dts;
    
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
    public void issueTicket(Car c, Calendar start, DateTimeStrat dts){
        if(c.getTicket() == null){
            Ticket t = new Ticket();
            t.punchIn(start);
            t.setDts(dts);
            c.setTicket(t);
        }
    }
    
    /**
     * claims the ticket from a departing car and collects the amount owed.
     * @param c Car object that is exiting
     * @param end Calendar object of when the car exited
     * @param fee the FeeStrategy being used to calculate the fee
     */
    public void claimTicket(Car c, Calendar end, FeeStrategy fee){
        c.getTicket().punchOut(end);
        PunchTime p = c.getTicket().getTimePunched();
        double collected = fee.calculateFee(p);
        if(collected == -1){
            sendTowedMessage();
            return;
        }
        runningTotalCharged += collected;
        runningTotalTime += fee.getTimeParked(p);
        outputStrat.makeTicketOutput(c.getId(), fee.getName(), collected, fee.getTimeParked(p));
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
    
    /**
     * 
     * @return tunningTotalCharged
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

    /**
     * 
     * @return runningTotalTime
     */
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.outputStrat);
        hash = 83 * hash + Objects.hashCode(this.dts);
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
        final AutomatedTellerStrat other = (AutomatedTellerStrat) obj;
        if (!Objects.equals(this.outputStrat, other.outputStrat)) {
            return false;
        }
        if (!Objects.equals(this.dts, other.dts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AutomatedTellerStrat{" + "outputStrat=" + outputStrat + ", dts=" + dts + '}';
    }
    
    
    
}
