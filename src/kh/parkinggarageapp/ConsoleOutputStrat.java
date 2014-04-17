/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * output strategy for console output
 * prints receipts, reports, and other messages to a console
 * @author Keiji
 */
public class ConsoleOutputStrat implements OutputStrategy {
    private FileManagerStrat fms;
    
    public ConsoleOutputStrat(FileManagerStrat fms){
        this.setFms(fms);
    }
    
    /**
     * creates a receipt output
     * @param id car id
     * @param garageName the name of the garage
     * @param collected amount of money collected
     * @param timeParked  amount of time parked
     */
    @Override
    public void makeTicketOutput(String id, String garageName, double collected, double timeParked){
        String out = "Receipt for car: " + id + "\t" + garageName + ":   " + "Hours charged: " + timeParked + "\t" + "Amount collected: $" + collected;
        System.out.println(out);
        fms.writeTicketRecord(out);
    }
    
    /**
     * creates a report output for the garage
     * @param garageName the name of the garage
     * @param totalCollected the running total collected
     * @param totalParked the running total of time parked
     */
    @Override
    public void makeReportOutput(String garageName, double totalCollected, double totalParked){
        String out = "Totals for garage today:   " + garageName + ":   " + "Hours charged: " + totalParked + "\t" + "Total collected so far: $" + totalCollected;
        System.out.println(out);
        fms.writeReportRecord(out);
    }
    
    /**
     * prints any miscellaneous messages
     * @param message a String containing a message
     */
    @Override
    public void makeOutput(String message){
        System.out.println(message);
    }

    public FileManagerStrat getFms() {
        return fms;
    }

    public void setFms(FileManagerStrat fms) {
        this.fms = fms;
    }
    
    
}
