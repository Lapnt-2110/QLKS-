/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Kien Luu
 */
public class DialogHelper {
    public static void alert(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "HỆ THỐNG QUẢN LÝ KHÁCH SẠN", 1);
    }
    
    public static void prompt(Component parentComponent, String message) {
        JOptionPane.showInputDialog(parentComponent, message,"HỆ THỐNG QUẢN LÝ KHÁCH SẠN", 1);
    }
    
    public static boolean comfirm(Component parentComponent, String message) {
        int response = JOptionPane.showConfirmDialog(parentComponent, message,"HỆ THỐNG QUẢN LÝ KHÁCH SẠN", JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }
    
}
