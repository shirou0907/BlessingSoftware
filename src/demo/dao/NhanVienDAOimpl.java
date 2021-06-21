
package demo.dao;


import demo.model.NhanVien;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author MY PC
 */
public class NhanVienDAOimpl implements NhanVienDAO{

    @Override
    public List<NhanVien> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM nhanvien";
            List<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMavn(rs.getString("manv"));
                nv.setHoten(rs.getString("hoten"));
                nv.setGioitinh(rs.getBoolean("gioitinh"));
                nv.setNgaysinh(rs.getDate("ngaysinh" ));
                nv.setSdt(rs.getString("sdt"));
                nv.setCmnd(rs.getString("cmnd"));
                nv.setChucvu(rs.getString("chucvu"));
                list.add(nv);
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
    
    @Override
    public int createOrUpdate(NhanVien nv) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhanvien(manv, hoten, ngaysinh, gioitinh, sdt, cmnd, chucvu) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE hoten = VALUES(hoten), ngaysinh = VALUES(ngaysinh), gioitinh = VALUES(gioitinh), sdt = VALUES(sdt), cmnd = VALUES(cmnd), chucvu = VALUES(chucvu);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nv.getMavn());
            ps.setString(2, nv.getHoten());
            ps.setDate(3, new Date(nv.getNgaysinh().getTime()));
            ps.setBoolean(4, nv.isGioitinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getCmnd());
            ps.setString(7, nv.getChucvu());
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
