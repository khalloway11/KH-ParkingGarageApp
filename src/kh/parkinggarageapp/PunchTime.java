/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 * encapsulates the time logged on a ticket in minutes and hours.
 * @author khalloway
 */
public class PunchTime {
    
    private int hours;
    private int minutes;
    
    public PunchTime(int hours, int minutes){
        this.setHours(hours);
        this.setMinutes(minutes);
    };

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    
    
}
