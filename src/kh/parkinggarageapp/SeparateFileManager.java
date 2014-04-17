/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.io.*;

/**
 *
 * @author khalloway
 */
public class SeparateFileManager implements FileManagerStrat {
    private File ticketFile;
    private File reportFile;
    
    public SeparateFileManager(String ticketFilePath, String reportFilePath){
        ticketFile = new File(ticketFilePath);
        reportFile = new File(reportFilePath);
    }

    @Override
    public void writeTicketRecord(String record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeReportRecord(String record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readAllTicketRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readTicketRecord(int record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
