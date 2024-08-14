
import DAO.DatPhongDAO;
import Model.DatPhong;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pham Nhat Hoang
 */
public class TestSQL {
    public static void main(String[] args) {
        DatPhongDAO dao = new DatPhongDAO();
        List<DatPhong> list = dao.select();
    }
}
