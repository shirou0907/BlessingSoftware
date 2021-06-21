/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dao;

import demo.model.HoaDonNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class NhapKhoDAOimpl implements NhapKhoDAO {

    @Override
    public List<HoaDonNhap> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM hoadonnhap";
            List<HoaDonNhap> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonNhap hdn = new HoaDonNhap();
                hdn.setManhap(rs.getString("manhap"));
                hdn.setNgaynhap(rs.getDate("ngaynhap"));
                hdn.setManv(rs.getString("manv"));
                hdn.setBengui(rs.getString("bengui"));
                list.add(hdn);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        NhapKhoDAO a = new NhapKhoDAOimpl();
        System.out.println(a.getList());
    }
}
