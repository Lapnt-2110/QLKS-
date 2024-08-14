/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kien Luu
 */
public class DateHelper {
    public static String toString(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        String dateString = dateFormat.format(date);
        return dateString;
    }
    
    public static Date toDate(String dateString, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date date = dateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            return null;
        }
    }
    
    public static Date now() {
        return new Date();
    }
    
    public static Date addDaysToCurrentDate(int numberOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        Date newDate = calendar.getTime();
        return newDate;
    }
    
     public static Date addDaysToDate(Date date, int numberOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        Date newDate = calendar.getTime();
        return newDate;
    }
}
