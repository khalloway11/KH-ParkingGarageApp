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
public interface FileManagerStrat {

    /**
     *
     * @param record the ticket record that will be written to the file
     */
    public abstract void writeTicketRecord(String record);
    
    /**
     * 
     * @param record the report record that will be written to the file
     */
    public abstract void writeReportRecord(String record);
    
    /**
     * read all records in the file
     */
    public abstract void readAllTicketRecords();
    
    /**
     * read a specific record from the file
     * @param record the record to read
     */
    public abstract void readTicketRecord(int record);
}
