/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import com.toedter.calendar.JDateChooser;
import demo.dao.DBConnect;
import demo.model.HoaDonNhap;
import demo.service.NhapKhoService;
import demo.service.NhapKhoServiceImpl;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class FormNKController {
    
    private JTextField jtfMaNhap;
    private JTextField jtfBenGui;
    private JDateChooser jtfNgayNhap;
    private JTextField jtfMaNv;
    private JLabel jlbMes;
    private JTable jtbChitiet;
    
    private HoaDonNhap hdn = null;
    private NhapKhoServiceImpl nkS = null;

    public FormNKController (JTextField jtfMaNhap, JTextField jtfBenGui, JDateChooser jtfNgayNhap, JTextField jtfMaNv, JLabel jlbMes, JTable jtbChitiet) {
 
        this.jtfMaNhap = jtfMaNhap;
        this.jtfBenGui = jtfBenGui;
        this.jtfNgayNhap = jtfNgayNhap;
        this.jtfMaNv = jtfMaNv;
        this.jlbMes = jlbMes;
        this.jtbChitiet = jtbChitiet;
        this.nkS = new NhapKhoServiceImpl();
    }

    public void setView(HoaDonNhap hdn) {
        this.hdn = hdn;
        jtfMaNhap.setText(hdn.getManhap());
        jtfNgayNhap.setDate(hdn.getNgaynhap());
        jtfMaNv.setText(hdn.getManv());
        jtfBenGui.setText(hdn.getBengui());
        
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select * from hoadonnhap join chitietnhap on hoadonnhap.manhap = chitietnhap.manhap where hoadonnhap.manhap ='"+jtfMaNhap.getText()+"'";
            DefaultTableModel t = new DefaultTableModel();
            t.setColumnIdentifiers(new String[]{"Mã nhập","Mã hàng hóa","Số lô","Số lượng"});
            jtbChitiet.setModel(t);
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String[] row = new String[]{
                    rs.getString("manhap"), rs.getString("mahh"), rs.getString("solo"), rs.getString("soluong")
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
