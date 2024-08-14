/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kien Luu
 */
public class HoaDon {
    String maHD;
    int SDTKhach;
    String maDat;
    String maDV;
    
    public HoaDon() {}
    
    public HoaDon(String maHD, int SDTKhach, String maDat, String maDV) {
        this.maHD = maHD;
        this.SDTKhach = SDTKhach;
        this.maDat = maDat;
        this.maDV = maDV;
    }
    
    public HoaDon(int SDTKhach, String maDat, String maDV) {
        this.SDTKhach = SDTKhach;
        this.maDat = maDat;
        this.maDV = maDV;
    }
    
    //Getter and Setter

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSDTKhach() {
        return SDTKhach;
    }

    public void setSDTKhach(int SDTKhach) {
        this.SDTKhach = SDTKhach;
    }

    public String getMaDat() {
        return maDat;
    }

    public void setMaDat(String maDat) {
        this.maDat = maDat;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }
    
}
