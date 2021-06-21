/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dao;

import demo.model.SanPham;
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
public class SanPhamDAOimpl implements SanPhamDAO {

    @Override
    public List<SanPham> getList() {
       
    try {
            Connection cons = DBConnect.getConnection();
            String sql = "select * from hanghoa";
            List<SanPham> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){    
                SanPham hh = new SanPham();
                hh.setMahh(rs.getString("mahh"));
                hh.setTenhh(rs.getString("tenhh"));
                hh.setDonvitinh(rs.getString("donvitinh"));
                hh.setSolo(rs.getString("solo"));  
                hh.setSoluong(rs.getInt("soluong"));
                list.add(hh);
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
        SanPhamDAO a = new SanPhamDAOimpl();
        System.out.println(a.getList());
    }

    @Override
    public int createOrUpdate(SanPham sp) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO hanghoa(mahh, tenhh, donvitinh, solo) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE mahh = VALUES(mahh), tenhh = VALUES(tenhh), donvitinh = VALUES(donvitinh), solo = VALUES(solo);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, sp.getMahh());
            ps.setString(2, sp.getTenhh());
            ps.setString(3, sp.getDonvitinh());
            ps.setString(4, sp.getSolo());
//            ps.setInt(5, sp.getSoluong());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
}
