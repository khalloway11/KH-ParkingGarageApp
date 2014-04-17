/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;

/**
 * calculates the fee owed, and the amount of time spent and charged
 * also returns the name of the company
 * @author khalloway
 */
public interface FeeStrategy {
    /**
     * calculates and returns the fee owed
     * @param p PunchTime object containing the amount of time parked
     * @return the fee owed
     */
    public abstract double calculateFee(PunchTime p);
    public abstract String getName();
    public abstract double getTimeCharged(PunchTime p);
    public abstract double getTimeParked(PunchTime p);
}
