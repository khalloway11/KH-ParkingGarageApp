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
    public abstract void makeTicketOutput(String id, String garageName, double collected);
    public abstract void makeReportOutput(String garageName, double totalCollected, double totalParked);
    public abstract void makeOutput(String message);
}
