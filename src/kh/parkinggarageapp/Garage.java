/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;

/**
 * keeps track of cars entering and exiting
 * has a teller and a fee strategy
 * @author Keiji
 */
public class Garage {
    private static final int MAX_CAPACITY = 1000;
    
    private Car[] cars;
    private FeeStrategy feeStrat;
    private TellerStrategy tellerStrat;
    private DateTimeStrat dts;
    
    /**
     * initialize an empty garage with a FeeStrategy and a TellerStrategy
     * @param feeStrat the fee strategy of the garage
     * @param tellerStrat the teller strategy of the garage
     */
    public Garage(FeeStrategy feeStrat, TellerStrategy tellerStrat, DateTimeStrat dts){
        this.setFeeStrat(feeStrat);
        this.setTellerStrat(tellerStrat);
        this.setDts(dts);
        cars = new Car[0];
    }
    
    /**
     * initialize a garage with predetermined capacity with a FeeStrategy and a TellerStrategy
     * @param capacity the maximum capacity of the garage. cannot exceed MAX_CAPACITY
     * @param feeStrat the fee strategy of the garage
     * @param tellerStrat the teller strategy of the garage
     */
    public Garage(int capacity, FeeStrategy feeStrat, TellerStrategy tellerStrat, DateTimeStrat dts){
        this.setFeeStrat(feeStrat);
        this.setTellerStrat(tellerStrat);
        this.setDts(dts);
        if(capacity < MAX_CAPACITY){
            this.cars = new Car[capacity];
        } else {
            this.cars = new Car[MAX_CAPACITY];
        }
    }
    
    /**
     * add a car to the garage
     * @param c a Car object
     * @param start Calendar object representing when the car entered the garage
     */
    public void park(Car c, Calendar start){
        if(cars.length == 0){
            cars = new Car[1];
            cars[0] = c;
        } else {
            if(findEmptySpot() == -1){
                Car[] temp = new Car[cars.length + 1];
                System.arraycopy(cars, 0, temp, 0, cars.length);
                temp[cars.length] = c;
                cars = temp;
            }else if(findEmptySpot() == -2){
                tellerStrat.sendFullMessage();
            } else {
                cars[findEmptySpot()] = c;
            }
        }
        tellerStrat.issueTicket(c, start, this.getDts());
    }
    
    /**
     * remove a car from the garage
     * @param id id of the car
     * @param end Calendar object representing when the car exited
     */
    public void exit(String id, Calendar end){
        Car exit = this.searchById(id);
        if(exit == null){
            return;
        } else {
            for(Car c:cars){
                if(exit.equals(c)){
                    c = null;
                    tellerStrat.claimTicket(exit, end, feeStrat);
                    break;
                }
            }
        }
    }
    
    /**
     * private method to look for a specific car by its ID
     * @param id id of the car to search for
     * @return the Car object if it exists in the garage, else null
     */
    private Car searchById(String id){
        for(Car c: cars){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
    
    /**
     * find an empty index in the cars array
     * @return -1 if none, return -2 if filled to capacity
     */
    private int findEmptySpot(){
        for(int i = 0; i < cars.length; i++){
            if(cars[i] == null){
                return i;
            }
            if(i == MAX_CAPACITY-1){
                return -2;
            }
        }
        return -1;
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
    
    
    
    
}
