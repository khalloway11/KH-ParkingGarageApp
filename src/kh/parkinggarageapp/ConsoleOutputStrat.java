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
    public void makeTicketOutput(String id, String garageName, double collected, double timeParked){
        System.out.print("Receipt for car: " + id + "\t");
        System.out.print(garageName + ":   ");
        System.out.print("Hours charged: " + timeParked + "\t");
        System.out.println("Amount collected: $" + collected + "\t");
    }
    
    /**
     * creates a report output for the garage
     * @param garageName the name of the garage
     * @param totalCollected the running total collected
     * @param totalParked the running total of time parked
     */
    public void makeReportOutput(String garageName, double totalCollected, double totalParked){
        System.out.print("Totals for garage today:   ");
        System.out.print(garageName + ":   ");
        System.out.print("Hours charged: " + totalParked + "\t");
        System.out.println("Total collected so far: $" + totalCollected);
    }
    
    /**
     * prints any miscellaneous messages
     * @param message a String containing a message
     */
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
