/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Kien Luu
 */
public class DatPhong {
    String maDatPhong;
    String maNV;
    int SDTKhach;
    Date ngayDen;
    Date ngayDi;
    String soPhong;
    
    public DatPhong() {
    }
     
    public DatPhong(String maDatPhong, String maNV,int SDTKhach, Date ngayDen, Date ngayDi, String soPhong) {
        this.maDatPhong = maDatPhong;
        this.maNV = maNV;
        this.SDTKhach = SDTKhach;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.soPhong = soPhong;
    }

     //Getter and Setter
    
    public String getMaDatPhong() {
        return maDatPhong;
    }

    public void setMaDatPhong(String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSDTKhach() {
        return SDTKhach;
    }

    public void setSDTKhach(int SDTKhach) {
        this.SDTKhach = SDTKhach;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }
}
