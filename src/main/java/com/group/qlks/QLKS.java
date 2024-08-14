/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.group.qlks;

import View.ChaoJFrame;
import View.DangNhapJFrame;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author Kien Luu
 */
public class QLKS {

    public static void main(String[] args) {
        ChaoJFrame frame2 = new ChaoJFrame();
        frame2.setDefaultCloseOperation(ChaoJFrame.DISPOSE_ON_CLOSE);
        
        
        frame2.setVisible(true);
        
        DangNhapJFrame login = new DangNhapJFrame();
        login.setDefaultCloseOperation(DangNhapJFrame.EXIT_ON_CLOSE);
        
        Timer timer = new Timer(3000, (ActionEvent evt) -> {
            frame2.dispose();
            login.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
