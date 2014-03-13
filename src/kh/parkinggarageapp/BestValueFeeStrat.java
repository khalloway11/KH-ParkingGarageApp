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
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return fee
     */
    public double calculateFee(double startHour, double startMin, double endHour, double endMin){
        double time = getTimeCharged(startHour, startMin, endHour, endMin);
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
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return -1 if over 24 hours, else time charged
     */
    public double getTimeCharged(double startHour, double startMin, double endHour, double endMin){
        double hourDiff = endHour - startHour;
        if(hourDiff < 0){
            hourDiff += 24;
        }
        double minDiff = endMin - startMin;
        if(minDiff != 0){
            hourDiff++;
        }
        if(hourDiff > MAX_HOURS){
            return -1;
        } else {
            return hourDiff;
        }
    }
    
    /**
     * returns the exact amount of time spent.
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return -1 if over 24 hours, else time parked
     */
    public double getTimeParked(double startHour, double startMin, double endHour, double endMin){
        double hourDiff = endHour - startHour;
        if(hourDiff < 0){
            hourDiff += 24;
        }
        double minDiff = endMin - startMin;
        if(minDiff != 0){
            hourDiff += (Math.abs(minDiff)/60.0);
        }
        if(hourDiff > MAX_HOURS){
            return -1;
        } else {
            return hourDiff;
        }
    }
    
    public String getName(){
        return GARAGE_NAME;
    }
}
