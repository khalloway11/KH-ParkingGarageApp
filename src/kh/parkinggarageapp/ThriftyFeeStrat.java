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
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return fee
     */
    public double calculateFee(double startHour, double startMin, double endHour, double endMin){
        double time = getTimeCharged(startHour, startMin, endHour, endMin);
        if((time < 0) || (time > MAX_HOURS)){
            return 0;
        }
        if(time < BASE_HOURS){
            return BASE_FEE;
        } else {
            return BASE_FEE + ((time - BASE_HOURS) * HOUR_RATE);
        }
    }
    
        /**
     * returns the time to be charged, counting partial hours
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return 
     */
    public double getTimeCharged(double startHour, double startMin, double endHour, double endMin){
        double hourDiff = endHour - startHour;
        double minDiff = endMin - startMin;
        if(minDiff != 0){
            hourDiff++;
        }
        return hourDiff;
    }
    
    /**
     * returns the exact amount of time spent.
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return 
     */
    public double getTimeParked(double startHour, double startMin, double endHour, double endMin){
        double hourDiff = endHour - startHour;
        double minDiff = endMin - startMin;
        if(minDiff != 0){
            hourDiff += (Math.abs(minDiff)/60.0);
        }
        return hourDiff;
    }
    
    public String getName(){
        return GARAGE_NAME;
    }
}
