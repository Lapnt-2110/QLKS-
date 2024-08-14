/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kien Luu
 */
public class KhachHang {
    int SDT;
    String hoTen;
    String soCMND;
    
    public KhachHang() {}
    
    public KhachHang(int SDT, String hoTen, String soCMND) {
        this.SDT = SDT;
        this.hoTen = hoTen;
        this.soCMND = soCMND;
    }
    
    //Getter and Setter

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
   
}