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
    
    /**
     * an object that encapsulates the time in hours and minutes
     * @param hours
     * @param minutes 
     */
    public PunchTime(int hours, int minutes){
        this.setHours(hours);
        this.setMinutes(minutes);
    }

    //getters and setters
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.hours;
        hash = 43 * hash + this.minutes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PunchTime other = (PunchTime) obj;
        if (this.hours != other.hours) {
            return false;
        }
        if (this.minutes != other.minutes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PunchTime{" + "hours=" + hours + ", minutes=" + minutes + '}';
    }
    
    
    
}
