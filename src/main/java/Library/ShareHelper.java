/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
//
//import Model.NhanVien;
import Model.NhanVien;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Kien Luu
 */
public class ShareHelper {
    public static Image APP_ICON = new ImageIcon("..\\Polypro\\Image\\logo.png").getImage();
    
    public static void saveLogo(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            
            String imageName = file.getName();
            String outputFilePath = "..\\Polypro\\Image\\" + imageName+".png";
            
            File outputFile = new File(outputFilePath);
            ImageIO.write(image, "png", outputFile);
            System.out.println("ok");
        } catch (IOException ex) {
            Logger.getLogger(ShareHelper.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static ImageIcon readLogo(String filename) {
        ImageIcon Img = new ImageIcon(filename);
        return Img;
    }
    
    public static NhanVien USER = null;
    
        public static void logoff() {
        USER = null;
    }
    
    public static boolean authenticated() {
        return USER != null;
    }
    
}
