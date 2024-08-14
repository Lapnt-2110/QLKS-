/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kien Luu
 */
public class Phong {
 String soPhong; 
    String loaiPhong; 
    Double gia; 
    Boolean tinhTrang;
    
    public Phong(String soPhong, String loaiPhong, Double gia, Boolean tinhTrang) {
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
    }
    
    //Getter and Setter

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
       
}
