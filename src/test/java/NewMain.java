
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Kien Luu
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       
        long diffDays = 0;
        try {
        
        
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("14/10/2023");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2023");

        long diff = date2.getTime() - date1.getTime();
        diffDays = diff / (24 * 60 * 60 * 1000);
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        System.err.println(diffDays);
    }
    
}
