/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * FeeStrategy for Best Value parking garage
 * contains constants, no instance variables
 * 
 * @author Keiji
 */
public class BestValueFeeStrat implements FeeStrategy {
    //constants
    private static final double BASE_FEE = 2.0;
    private static final double BASE_HOURS = 3.0;
    private static final double HOUR_RATE = 0.5;
    private static final double MAX_FEE = 10.0;
    private static final double MAX_HOURS = 24.0;
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    
    //constructor
    public BestValueFeeStrat(){}
    
    /**
     * Calculates the fee owed
     * @param p PunchTime object containing the amount of time parked
     * @return fee
     */
    @Override
    public double calculateFee(PunchTime p){
        double time = getTimeCharged(p);
        if(time == -1){
            return -1;
        }
        if(time < BASE_HOURS){
            return BASE_FEE;
        } else {
            double fee= BASE_FEE + ((time - BASE_HOURS) * HOUR_RATE);
            if(fee <= MAX_FEE){
                return fee;
            } else {
                return MAX_FEE;
            }
        }
    }
    
    /**
     * returns the time to be charged, counting partial hours
     * @param p PunchTime object containing the amount of time parked
     * @return -1 if over 24 hours, else time charged
     */
    public double getTimeCharged(PunchTime p){
        int minutes = p.getMinutes();
        int hours = p.getHours();
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
     * @param p the PunchTime object containing the length of time parked
     * @return -1 if over 24 hours, else time parked
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
