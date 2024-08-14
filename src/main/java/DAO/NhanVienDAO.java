/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class NhanVienDAO {
    public List<NhanVien> select(String sql, Object...args) {
        List<NhanVien> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            while(rs.next()) {
                NhanVien model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        String maNV = rs.getString("MaNV");
        String hoTen = rs.getString("HoTen");
        String matKhau = rs.getString("MatKhau");
        Boolean vaiTro = rs.getBoolean("Vaitro");

        
        NhanVien model = new NhanVien(maNV, hoTen, matKhau, vaiTro);
        return model;
    }
    
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (maNV, hoTen, matKhau, vaiTro) values (?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql, model.getMaNv(), model.getHoTen(), model.getMatKhau(), model.getVaiTro()
        );
    }
    
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET hoTen = ?, matKhau = ?, vaiTro =? WHERE maNV = ? ";
        JDBCHelper.executeUpdate(sql, model.getHoTen(), model.getMatKhau(), model.getVaiTro(), model.getMaNv()
        );
    }
    
    public void delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE maNV =?";
        JDBCHelper.executeUpdate(sql, maNV);
    }
    
    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }
    
    public NhanVien findByMaNV(String MaNv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        List<NhanVien> list = select(sql, MaNv);
        
        return !list.isEmpty() ? list.get(0) : null;
    }
}
