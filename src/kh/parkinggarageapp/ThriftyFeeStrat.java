/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * fee strategy for Thrifty Parking Garage
 * contains constants, no instance variables
 * @author Keiji
 */
public class ThriftyFeeStrat implements FeeStrategy {
    //constants
    private static final double BASE_FEE = 1.5;
    private static final double BASE_HOURS = 2.0;
    private static final double HOUR_RATE = 0.75;
    private static final double MAX_HOURS = 24.0;
    private static final String GARAGE_NAME = "Thrifty Parking Garage";

    //constructor
    public ThriftyFeeStrat(){}


    /**
     * Calculates the fee owed
     * @param p PunchTime object containing the amount of time parked
     * @return the fee to be paid
     */
    public double calculateFee(PunchTime p){
        double time = getTimeCharged(p);
        if(time < 0){
            return -1;
        }
        if(time < BASE_HOURS){
            return BASE_FEE;
        } else {
            return BASE_FEE + ((time - BASE_HOURS) * HOUR_RATE);
        }
    }
    
        /**
     * returns the time to be charged, counting partial hours
     * @param p PunchTime object containing the amount of time parked
     * @return the total amount of time charged. If it exceeds MAX_HOURS, return -1
     */
    @Override
    public double getTimeCharged(PunchTime p){
        int hours = p.getHours();
        int minutes = p.getMinutes();
        if(minutes != 0){
            hours++;
        }
        if(hours > MAX_HOURS){
            return -1;
        } else {
            return hours;
        }
    }
    
    /**
     * returns the exact amount of time spent.
     * @param p PunchTime object containing the amount of time parked
     * @return the total amount of time parked. If it exceeds MAX_HOURS, return -1
     */
    @Override
    public double getTimeParked(PunchTime p){
        double hours = p.getHours();
        double minutes = p.getMinutes();
        if(minutes != 0){
            hours += (minutes/60.0);
        }
        if(hours > MAX_HOURS){
            return -1;
        } else {
            return hours;
        }
    }
    
    @Override
    public String getName(){
        return GARAGE_NAME;
    }
    
    
}
