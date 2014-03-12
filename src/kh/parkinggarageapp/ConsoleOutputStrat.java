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
    
    public void makeTicketOutput(String id, double collected, double total){
        System.out.print("Report for car: " + id + "\t");
        System.out.print("Amount collected: " + collected + "\t");
        System.out.println("Total collected so far: " + total);
    }
    
    public void makeOutput(String message){
        System.out.println(message);
    }
}
