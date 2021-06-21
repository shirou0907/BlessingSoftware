/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import com.toedter.calendar.JDateChooser;
import demo.model.NhanVien;
import demo.service.NhanVienService;
import demo.service.NhanVienServiceImpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author MY PC
 */
public class FormNVController {
    private JButton btnSubmit;
    private JTextField jtfMaNhanVien;
    private JTextField jtfHoTen;
    private JDateChooser jtfNgaySinh;
    private JTextField jtfSdt;
    private JTextField jtfCMND;
    private JTextField jtfChucVu;
    private JRadioButton jrbNam;
    private JRadioButton jrbNu;
    private JLabel jlbMes;
    
    private NhanVien nv = null;
    private NhanVienService nvS = null;

    public FormNVController(JButton btnSubmit, JTextField jtfMaNhanVien, JTextField jtfHoTen, JDateChooser jtfNgaySinh, JTextField jtfSdt, JTextField jtfCMND, JTextField jtfChucVu, JRadioButton jrbNam, JRadioButton jrbNu, JLabel jlbMes) {
        this.btnSubmit = btnSubmit;
        this.jtfMaNhanVien = jtfMaNhanVien;
        this.jtfHoTen = jtfHoTen;
        this.jtfNgaySinh = jtfNgaySinh;
        this.jtfSdt = jtfSdt;
        this.jtfCMND = jtfCMND;
        this.jtfChucVu = jtfChucVu;
        this.jrbNam = jrbNam;
        this.jrbNu = jrbNu;
        this.jlbMes = jlbMes;
        this.nvS = new NhanVienServiceImpl();
    }

    public void setView(NhanVien nv) {
        this.nv = nv;
        jtfMaNhanVien.setText(nv.getMavn());
        jtfHoTen.setText(nv.getHoten());
        jtfSdt.setText(nv.getSdt());
        jtfCMND.setText(nv.getCmnd());
        jtfChucVu.setText(nv.getChucvu());
        jtfNgaySinh.setDate(nv.getNgaysinh());
        if(nv.isGioitinh()){
           jrbNam.setSelected(true);
           jrbNu.setSelected(false);
        }
        else {
            jrbNam.setSelected(false);
            jrbNu.setSelected(true);
        }
            
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(jtfMaNhanVien.getText().length()==0){
               jlbMes.setText("Bạn phải nhập thông tin! ");
               }
               else{
                   nv.setMavn(jtfMaNhanVien.getText());
                   nv.setHoten(jtfHoTen.getText());
                   nv.setNgaysinh(jtfNgaySinh.getDate());
                   nv.setGioitinh(jrbNam.isSelected());
                   nv.setSdt(jtfSdt.getText());
                   nv.setCmnd(jtfCMND.getText());
                   nv.setChucvu(jtfChucVu.getText());
                   nvS.createOrUpdate(nv);
                   jlbMes.setText("Cập nhật dữ liêụ thành công!");
               }
            }        
        });
    }
}
