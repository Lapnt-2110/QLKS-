/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import Model.DatPhong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class DatPhongDAO {
    public List<DatPhong> select(String sql, Object...args) {
        List<DatPhong> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                DatPhong model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public DatPhong readFromResultSet(ResultSet rs) throws SQLException {
        String maDatPhong = rs.getString("MaDat");
        String maNV = rs.getString("MaNV");
        int SDTKhach = rs.getInt("SDTKhach");
        Date ngayDen = rs.getDate("ngayDen");
        Date ngayDi = rs.getDate("ngayDi");
        
        DatPhong model = new DatPhong(maDatPhong, maNV, SDTKhach, ngayDen, ngayDi, maDatPhong);
        return model;
    }
    
    public List<DatPhong> select() {
        String sql = "Select * From DatPhong";
        return select(sql);
    }
    
    public void insert(DatPhong model) {
        String sql = "INSERT INTO DATPHONG (MADAT, MANV, SDTKHACH, NGAYDEN, NGAYDI, SOPHONG) values (?, ?, ?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql, model.getMaDatPhong(), model.getMaNV(), model.getSDTKhach(), model.getNgayDen(), model.getNgayDi(), model.getSoPhong()
        );
    }
    
    public void update(DatPhong model) {
        String sql = "UPDATE DATPHONG SET MANV = ?, SDTKHACH = ?, NGAYDEN = ?, NGAYDI = ?, SOPHONG = ? WHERE MADAT = ? ";
        JDBCHelper.executeUpdate(sql, model.getMaNV(), model.getSDTKhach(), model.getNgayDen(), model.getNgayDi(), model.getSoPhong(),model.getMaDatPhong()
        );
    }
    
    public void delete(String maDat) {
        String sql = "DELETE FROM DATPHONG WHERE MADAT =?";
        JDBCHelper.executeUpdate(sql, maDat);
    }
    
    public DatPhong findByMaDat(String maDat) {
        String sql = "SELECT * FROM DATPHONG WHERE MADAT = ?";
        List<DatPhong> list = select(sql, maDat);
        
        return !list.isEmpty() ? list.get(0) : null;
    }
    
    public DatPhong findBySoPhong(String soPhong) {
        String sql = "SELECT * FROM DATPHONG WHERE SOPHONG = " + soPhong;
        List<DatPhong> list = select(sql);
        
        return !list.isEmpty() ? list.get(0) : null;
    }
}
