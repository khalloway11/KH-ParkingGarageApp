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
public class ConsoleOutputStrat implements OutputStrategy {
    
    public ConsoleOutputStrat(){}
    
    public void makeTicketOutput(String id, String garageName, double collected, double timeParked){
        System.out.print("Receipt for car: " + id + "\t");
        System.out.print(garageName + ":   ");
        System.out.print("Hours charged: " + timeParked + "\t");
        System.out.println("Amount collected: $" + collected + "\t");
    }
    
    public void makeReportOutput(String garageName, double totalCollected, double totalParked){
        System.out.print("Totals for garage today:   ");
        System.out.print(garageName + ":   ");
        System.out.print("Hours charged: " + totalParked + "\t");
        System.out.println("Total collected so far: $" + totalCollected);
    }
    
    public void makeOutput(String message){
        System.out.println(message);
    }
}
