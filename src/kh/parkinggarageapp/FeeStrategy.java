/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * calculates the fee owed, and the amount of time spent and charged
 * also returns the name of the company
 * @author khalloway
 */
public interface FeeStrategy {
    /**
     * calculates and returns the fee owed
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return 
     */
    public abstract double calculateFee(double startHour, double startMin, double endHour, double endMin);
    public abstract String getName();
    public abstract double getTimeCharged(double startHour, double startMin, double endHour, double endMin);
    public abstract double getTimeParked(double startHour, double startMin, double endHour, double endMin);
}
