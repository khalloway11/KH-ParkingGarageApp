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
public interface OutputStrategy {
    public abstract void makeTicketOutput(String id, double collected, double total);
    public abstract void makeOutput(String message);
}
