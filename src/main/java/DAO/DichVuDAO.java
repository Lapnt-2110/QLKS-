/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import Model.DatPhong;
import Model.DichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class DichVuDAO {
    public List<DichVu> select(String sql, Object...args) {
        List<DichVu> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                DichVu model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public DichVu readFromResultSet(ResultSet rs) throws SQLException {
        String maDV = rs.getString("MaDV");
        String tenDV = rs.getString("TenDV");
        double gia = rs.getDouble("Gia");
        
        
        DichVu model = new DichVu(maDV, tenDV, gia);
        return model;
    }
    
    public List<DichVu> select() {
        String sql = "Select * From DichVu";
        return select(sql);
    } 
    
    public DichVu findByMaDV(String maDV) {
        String sql = "SELECT * FROM DICHVU WHERE MADV = ?";
        List<DichVu> list = select(sql, maDV);
        
        return !list.isEmpty() ? list.get(0) : null;
    }
    
}
