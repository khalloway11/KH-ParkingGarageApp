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
        double hourDiff = endHour - startHour;
        double minDiff = endMin - startMin;
        if(minDiff != 0){
            hourDiff++;
        }
        if((hourDiff < 0) || (hourDiff > MAX_HOURS)){
            return 0;
        }
        if(hourDiff < BASE_HOURS){
            return BASE_FEE;
        } else {
            double fee= BASE_FEE + ((hourDiff - BASE_HOURS) * HOUR_RATE);
            if(fee <= MAX_FEE){
                return fee;
            } else {
                return MAX_FEE;
            }
        }
    }
}
