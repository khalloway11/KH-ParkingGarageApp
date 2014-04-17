/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

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
    
    /**
     * initialize an empty garage with a FeeStrategy and a TellerStrategy
     * @param feeStrat the fee strategy of the garage
     * @param tellerStrat the teller strategy of the garage
     */
    public Garage(FeeStrategy feeStrat, TellerStrategy tellerStrat){
        this.setFeeStrat(feeStrat);
        this.setTellerStrat(tellerStrat);
        cars = new Car[0];
    }
    
    /**
     * initialize a garage with predetermined capacity with a FeeStrategy and a TellerStrategy
     * @param capacity the maximum capacity of the garage. cannot exceed MAX_CAPACITY
     * @param feeStrat the fee strategy of the garage
     * @param tellerStrat the teller strategy of the garage
     */
    public Garage(int capacity, FeeStrategy feeStrat, TellerStrategy tellerStrat){
        this.setFeeStrat(feeStrat);
        this.setTellerStrat(tellerStrat);
        if(capacity < MAX_CAPACITY){
            this.cars = new Car[capacity];
        } else {
            this.cars = new Car[MAX_CAPACITY];
        }
    }
    
    /**
     * add a car to the garage
     * @param c a Car object
     * @param hour time the car entered (hour)
     * @param minute time the car entered (minutes)
     */
    public void park(Car c, double hour, double minute){
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
        tellerStrat.issueTicket(c, hour, minute);
    }
    
    /**
     * remove a car from the garage
     * @param id id of the car
     * @param hour time the car exits (hours)
     * @param minute time the car exits (minutes)
     */
    public void exit(String id, double hour, double minute){
        Car exit = this.searchById(id);
        if(exit == null){
            return;
        } else {
            for(Car c:cars){
                if(exit.equals(c)){
                    c = null;
                    tellerStrat.claimTicket(exit, hour, minute, feeStrat);
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
    
    
}
