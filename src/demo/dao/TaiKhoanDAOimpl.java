/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dao;

import demo.model.TaiKhoan;
import demo.dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MY PC
 */
public class TaiKhoanDAOimpl implements TaiKhoanDAO {

    @Override
    public TaiKhoan login(String tentk, String matkhau) {
        Connection cons = DBConnect.getConnection();
        String sql = "select * from taikhoan where tentk like ? and matkhau like ?";
        TaiKhoan tk = null;
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            ps.setString(1, tentk);
            ps.setString(2, matkhau);
            if (rs.next()) {
                tk = new TaiKhoan();
                tk.setTentk(rs.getString("tentk"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setManv(rs.getString("manv"));
            }
            ps.close();
            cons.close();
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
