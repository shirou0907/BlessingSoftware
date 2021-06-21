/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import com.toedter.calendar.JDateChooser;
import demo.dao.DBConnect;
import demo.model.HoaDonXuat;
import demo.service.XuatKhoServiceImpl;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class FormXKController {
    
    private JTextField jtfMaXuat;
    private JTextField jtfBenNhan;
    private JDateChooser jtfNgayXuat;
    private JTextField jtfMaNv;
    private JLabel jlbMes;
    private JTable jtbChitiet;
    
    private HoaDonXuat hdx = null;
    private XuatKhoServiceImpl xkS = null;

    public FormXKController(JTextField jtfMaXuat, JTextField jtfBenNhan, JDateChooser jtfNgayXuat, JTextField jtfMaNv, JLabel jlbMes, JTable jtbChitiet) {
        this.jtfMaXuat = jtfMaXuat;
        this.jtfBenNhan = jtfBenNhan;
        this.jtfNgayXuat = jtfNgayXuat;
        this.jtfMaNv = jtfMaNv;
        this.jlbMes = jlbMes;
        this.jtbChitiet = jtbChitiet;
        this.xkS = new XuatKhoServiceImpl();
    }

   
    public void setView(HoaDonXuat hdx) {
        this.hdx = hdx;
        jtfMaXuat.setText(hdx.getMaxuat());
        jtfNgayXuat.setDate(hdx.getNgayxuat());
        jtfMaNv.setText(hdx.getManv());
        jtfBenNhan.setText(hdx.getBennhan());
        
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select * from hoadonxuat join chitietxuat on hoadonxuat.maxuat = chitietxuat.maxuat where hoadonxuat.maxuat ='"+jtfMaXuat.getText()+"'";
            DefaultTableModel t = new DefaultTableModel();
            t.setColumnIdentifiers(new String[]{"Mã xuất","Mã hàng hóa","Số lô","Số lượng"});
            jtbChitiet.setModel(t);
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String[] row = new String[]{
                    rs.getString("maxuat"), rs.getString("mahh"), rs.getString("solo"), rs.getString("soluong")
                };
                t.addRow(row);
            }
            rs.close();
            ps.close();
            cons.close();
            jtbChitiet.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
            jtbChitiet.setRowHeight(30);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public void setEvent() {
//        btnSubmit.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//               if(jtfMaNhanVien.getText().length()==0){
//               jlbMes.setText("Bạn phải nhập thông tin! ");
//               }
//               else{
//                   nv.setMavn(jtfMaNhanVien.getText());
//                   nv.setHoten(jtfHoTen.getText());
//                   nv.setNgaysinh(jtfNgaySinh.getDate());
//                   nv.setGioitinh(jrbNam.isSelected());
//                   nv.setSdt(jtfSdt.getText());
//                   nv.setCmnd(jtfCMND.getText());
//                   nv.setChucvu(jtfChucVu.getText());
//                   nvS.createOrUpdate(nv);
//                   jlbMes.setText("Cập nhật dữ liêụ thành công! ");
//               }
//            }        
//        });
//    }
}
