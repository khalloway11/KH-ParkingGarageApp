/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kh.parkinggarageapp;

import java.util.Calendar;

/**
 * DateTimeStrat will handle calculating the difference between punch-in and punch-out
 * times on tickets issued. 
 *
 * Has one method, getTimeDiff(), which will return how much time has passed between the punch-in
 * and punch-out, accepting Calendar objects as parameters, and returning a PunchTime object
 * initialized with the time passed.
 * @author khalloway
 */
public interface DateTimeStrat {
    public abstract PunchTime getTimeDiff(Calendar in, Calendar out);
}
