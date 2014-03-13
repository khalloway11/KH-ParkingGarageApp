/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * main class simulates parking and exiting cars at two different garages
 * @author khalloway
 */
public class KHParkingGarageApp {

    /**
     * @param args the command line arguments
     * used military time for hours
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Garage BestValue = new Garage(new BestValueFeeStrat(), new AutomatedTellerStrat(new ConsoleOutputStrat()));
        BestValue.park(new Car("0001"), 10, 00);
        BestValue.exit("0001", 10, 30);
        BestValue.park(new Car("0002"), 23, 00);
        BestValue.park(new Car("0003"), 11, 00);
        BestValue.park(new Car("0004"), 11, 00);
        BestValue.exit("0002", 22, 30);
        BestValue.exit("0003", 13, 00);
        BestValue.exit("0004", 24, 20);
        
        Garage Thrifty = new Garage(new ThriftyFeeStrat(), new AutomatedTellerStrat(new ConsoleOutputStrat()));
        Thrifty.park(new Car("0001"), 10, 00);
        Thrifty.exit("0001", 10, 30);
        Thrifty.park(new Car("0002"), 23, 00);
        Thrifty.park(new Car("0003"), 11, 00);
        Thrifty.park(new Car("0004"), 11, 00);
        Thrifty.exit("0002", 22, 30);
        Thrifty.exit("0003", 13, 00);
        Thrifty.exit("0004", 24, 20);
    }
    
}
