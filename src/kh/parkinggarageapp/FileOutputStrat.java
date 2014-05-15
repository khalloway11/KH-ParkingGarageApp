/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import filemanager.FileManagerStrat;

/**
 *
 * @author khalloway
 */
public class FileOutputStrat implements OutputStrategy {
    private final FileManagerStrat fms;
    private int mode;
    
    public FileOutputStrat(FileManagerStrat fms, int mode){
        this.fms = fms;
        this.mode = mode;
    }

    @Override
    public void makeTicketOutput(String id, String garageName, double collected, double timeParked) {
        String out = "Receipt for car: " + id + "\t" + garageName + ":   " + "Hours charged: " + timeParked + "\t" + "Amount collected: $" + collected;
        fms.writeAppend(out, mode);
    }

    @Override
    public void makeReportOutput(String garageName, double totalCollected, double totalParked) {
        String out = "Totals for garage today:   " + garageName + ":   " + "Hours charged: " + totalParked + "\t" + "Total collected so far: $" + totalCollected;
        fms.writeAppend(out, mode);
    }

    @Override
    public void makeOutput(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
