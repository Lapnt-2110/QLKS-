/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import Model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class KhachHangDAO {
    public List<KhachHang> select(String sql, Object...args) {
        List<KhachHang> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                KhachHang model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        int SDT = rs.getInt("SDT");
        String hoTen = rs.getString("HoTen");
        String soCMND = rs.getString("soCMND");

        
        KhachHang model = new KhachHang(SDT, hoTen, soCMND);
        return model;
    }
    
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (SDT, Hoten, SoCMND) values (?, ?, ?)";
        JDBCHelper.executeUpdate(sql, model.getSDT(), model.getHoTen(), model.getSoCMND()
        );
    }
    
    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET Hoten ?, SET SOCMND = ? WHERE SDT = ? ";
        JDBCHelper.executeUpdate(sql, model.getHoTen(), model.getSoCMND(), model.getSDT()
        );
    }
    
    public void delete(int SDT) {
        String sql = "DELETE FROM KhachHang WHERE SDT =?";
        JDBCHelper.executeUpdate(sql, SDT);
    }
    
    public List<KhachHang> select() {
        String sql = "SELECT * FROM KhachHang";
        return select(sql);
    }
    
    public KhachHang findBySDT(int SDT) {
        String sql = "SELECT * FROM KhachHang WHERE SDT = ?";
        List<KhachHang> list = select(sql, SDT);
        
        return !list.isEmpty() ? list.get(0) : null;
    }
}
