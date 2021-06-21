/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dao;

import demo.model.HoaDonXuat;
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
public class XuatKhoDAOimpl implements XuatKhoDAO {

    @Override
    public List<HoaDonXuat> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM hoadonxuat";
            List<HoaDonXuat> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonXuat hdx = new HoaDonXuat();
                hdx.setMaxuat(rs.getString("maxuat"));
                hdx.setNgayxuat(rs.getDate("ngayxuat"));
                hdx.setManv(rs.getString("manv"));
                hdx.setBennhan(rs.getString("bennhan"));
                list.add(hdx);
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
        XuatKhoDAO a = new XuatKhoDAOimpl();
        System.out.println(a.getList());
    }
}
