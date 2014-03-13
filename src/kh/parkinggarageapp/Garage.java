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
public class Garage {
    private static final int MAX_CAPACITY = 1000;
    
    private Car[] cars;
    private FeeStrategy feeStrat;
    private TellerStrategy tellerStrat;
    
    /**
     * initialize an empty garage with a FeeStrategy and a TellerStrategy
     * @param feeStrat
     * @param tellerStrat 
     */
    public Garage(FeeStrategy feeStrat, TellerStrategy tellerStrat){
        this.setFeeStrat(feeStrat);
        this.setTellerStrat(tellerStrat);
        cars = new Car[0];
    }
    
    /**
     * initialize a garage with predetermined capacity with a FeeStrategy and a TellerStrategy
     * @param feeStrat
     * @param tellerStrat 
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
     * @param c 
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
            }else if(findEmptySpot() == -2){
                
            } else {
                cars[findEmptySpot()] = c;
            }
        }
        tellerStrat.issueTicket(c, hour, minute);
    }
    
    /**
     * remove a car from the garage
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
     * @param id
     * @return 
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
     * find an empty index in the cars array, return -1 if none, return -2 if filled to capacity
     * @return 
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

    public void setFeeStrat(FeeStrategy feeStrat) {
        this.feeStrat = feeStrat;
    }

    public TellerStrategy getTellerStrat() {
        return tellerStrat;
    }

    public void setTellerStrat(TellerStrategy tellerStrat) {
        this.tellerStrat = tellerStrat;
    }
    
    
}
