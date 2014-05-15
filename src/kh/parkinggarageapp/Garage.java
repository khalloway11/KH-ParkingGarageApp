/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

/**
 * keeps track of cars entering and exiting
 * has a teller and a fee strategy
 * @author Keiji
 */
public class Garage {
    private static final int MAX_CAPACITY = 1000;
    
    private HashMap<String, Car> cars;
    private FeeStrategy feeStrat;
    private TellerStrategy tellerStrat;
    private DateTimeStrat dts;
    
    /**
     * initialize a garage with a HashMap for cars, a FeeStrategy, a TellerStrategy, and a DateTimeStrat
     * @param feeStrat
     * @param tellerStrat
     * @param dts 
     */
    public Garage(FeeStrategy feeStrat, TellerStrategy tellerStrat, DateTimeStrat dts){
        this.setFeeStrat(feeStrat);
        this.setTellerStrat(tellerStrat);
        this.setDts(dts);
    }
    
    
    /**
     * add a car to the garage
     * @param c a Car object
     * @param start Calendar object representing when the car entered the garage
     */
    public void park(Car c, Calendar start){
        if(cars.size() < MAX_CAPACITY){
            cars.put(c.getId(), c);
            tellerStrat.issueTicket(c, start, this.getDts());
        } else {
            tellerStrat.sendFullMessage();
        }
    }
    
    /**
     * remove a car from the garage
     * @param id id of the car
     * @param end Calendar object representing when the car exited
     */
    public void exit(String id, Calendar end){
        if(cars.containsKey(id)){
            Car exit = cars.get(id);
            tellerStrat.claimTicket(exit, end, feeStrat);
            cars.remove(id);
        }
        
    }

    /*
    getters and setters
    */
    public FeeStrategy getFeeStrat() {
        return feeStrat;
    }

    /**
     * set the fee strategy for the garage
     * @param feeStrat 
     */
    public void setFeeStrat(FeeStrategy feeStrat) {
        this.feeStrat = feeStrat;
    }

    public TellerStrategy getTellerStrat() {
        return tellerStrat;
    }

    /**
     * set the teller strategy for the garage
     * @param tellerStrat 
     */
    public void setTellerStrat(TellerStrategy tellerStrat) {
        this.tellerStrat = tellerStrat;
    }

    public DateTimeStrat getDts() {
        return dts;
    }

    public void setDts(DateTimeStrat dts) {
        this.dts = dts;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.cars);
        hash = 73 * hash + Objects.hashCode(this.feeStrat);
        hash = 73 * hash + Objects.hashCode(this.tellerStrat);
        hash = 73 * hash + Objects.hashCode(this.dts);
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
        final Garage other = (Garage) obj;
        if (!Objects.equals(this.cars, other.cars)) {
            return false;
        }
        if (!Objects.equals(this.feeStrat, other.feeStrat)) {
            return false;
        }
        if (!Objects.equals(this.tellerStrat, other.tellerStrat)) {
            return false;
        }
        if (!Objects.equals(this.dts, other.dts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Garage{" + "cars=" + cars + ", feeStrat=" + feeStrat + ", tellerStrat=" + tellerStrat + ", dts=" + dts + '}';
    }
    
    
    
    
}
