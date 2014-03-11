/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

/**
 *
 * @author khalloway
 */
public interface FeeStrategy {
    public abstract double calculateFee(double startHour, double startMin, double endHour, double endMin);
}
