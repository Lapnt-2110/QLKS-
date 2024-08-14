/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import Model.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class HoaDonDAO {
    public List<HoaDon> select(String sql, Object...args) {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                HoaDon model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        String maHD = rs.getString("MaHD");
        int SDTKhach = rs.getInt("SoDTKhach");
        String maDat = rs.getString("MaDat");
        String maDV = rs.getString("MaDV");
        
        
        HoaDon model = new HoaDon(maHD, SDTKhach, maDat, maDV);
        return model;
    }
    
    public List<HoaDon> select() {
        String sql = "Select * From HoaDon";
        return select(sql);
    }
    
    public void insert(HoaDon model) {
        String sql = "INSERT INTO HoaDon (SoDTKhach, MaDV, MaDat) values ( ?, ?, ?)";
        JDBCHelper.executeUpdate(sql, model.getSDTKhach(), model.getMaDV(), model.getMaDat());
    }
    
    public void update(HoaDon model) {
        String sql = "UPDATE HoaDon SET SODTKHACH = ?, SET MADV = ?, SET MADAT = ?  WHERE MAHD = ? ";
        JDBCHelper.executeUpdate(sql, model.getSDTKhach(), model.getMaDV(), model.getMaDat(),model.getMaHD()
        );
    }
    
    public void delete(String maHD) {
        String sql = "DELETE FROM HoaDon WHERE MAHD =?";
        JDBCHelper.executeUpdate(sql, maHD);
    }
    
    public HoaDon findByMaDat(String maDat) {
        String sql = "Select * from HoaDon where MaDat like ?";
        List<HoaDon> list = select(sql, maDat);
        System.err.println(list.size());
        
        return !list.isEmpty() ? list.get(0) : null;
    }
}
