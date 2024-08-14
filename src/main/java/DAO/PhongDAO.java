/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import Model.Phong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class PhongDAO {
 public List<Phong> select(String sql, Object...args) {
        List<Phong> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                Phong model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public Phong readFromResultSet(ResultSet rs) throws SQLException {
        String soPhong = rs.getString("SoPhong");
        String loaiPhong = rs.getString("LoaiPhong");
        Double gia = rs.getDouble("gia");
        Boolean tinhTrang = rs.getBoolean("TinhTrang");
        
        Phong model = new Phong(soPhong, loaiPhong, gia, tinhTrang);
        return model;
    }
    
    public void insert(Phong model) {
        String sql = "INSERT INTO Phong (SoPhong, LoaiPhong, Gia, TinhTrang) values (?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql, model.getSoPhong(), model.getLoaiPhong(), model.getGia(), model.getTinhTrang()
        );
    }
    
    public void update(Phong model) {
        String sql = "UPDATE Phong SET LoaiPhong ?, SET Gia = ?, SET TinhTrang = ? WHERE SoPhong = ? ";
        JDBCHelper.executeUpdate(sql, model.getLoaiPhong(), model.getGia(), model.getTinhTrang(), model.getSoPhong()
        );
    }
    
    public void delete(int SDT) {
        String sql = "DELETE FROM Phong WHERE SDT =?";
        JDBCHelper.executeUpdate(sql, SDT);
    }
    
    public List<Phong> select() {
        String sql = "SELECT * FROM Phong";
        return select(sql);
    }
    
    public Phong findBySoPhong(int soPhong) {
        String sql = "SELECT * FROM Phong WHERE soPhong = ?";
        List<Phong> list = select(sql, soPhong);
        
        return !list.isEmpty() ? list.get(0) : null;
    }   
}
