/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Library.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class ThongKeDAO {
    public List<Object[]> getDTTheoPhong() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec dbo.sp_DTSoPhong";
                rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    
                    Object[] model = {
                        rs.getString("SoPhong"),
                        formatTienVND(rs.getDouble("TongTien")),
                        rs.getInt("SoNgayThue")                        
                    };                            
                    list.add(model);
                }
            }
            finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Object[]> getDTTheoThang(String nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec dbo.sp_DTThang " + nam;
                rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("Thang"),
                        rs.getInt("TongSoNgayThue"),
                        formatTienVND(rs.getDouble("TongTien")),                        
                        rs.getInt("Nam")
                    };                            
                    list.add(model);
                }
            }
            finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    //Định dạng tiền
    private static String formatTienVND(double giaTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        return decimalFormat.format(giaTien);
    }
}
