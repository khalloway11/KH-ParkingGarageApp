/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;

/**
 *
 * @author khalloway
 */
public class DateTimeHandler implements DateTimeStrat {
    //constants
    private final int SECONDS = 1000;
    private final int MINUTES = 60;
    private final int HOURS = 60;
    
    
    //constructor
    public DateTimeHandler(){}
    
    /**
     * calculates the time spent in the garage as a difference of Calender
     * objects and returns a PunchTime object
     * @param in time the car entered
     * @param out time the car left
     * @return PunchTime
     */
    @Override
    public PunchTime getTimeDiff(Calendar in, Calendar out) {
        long time = out.getTimeInMillis() - in.getTimeInMillis();
        
        //convert to seconds
        time /= SECONDS;
        
        //convert to minutes
        time /= MINUTES;
        long punchMin = time % 60;
        
        //convert to hours
        time -= punchMin;
        time /= HOURS;
        
        return new PunchTime((int)time, (int)punchMin);
    }
}
