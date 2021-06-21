/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.model.SanPham;
import demo.service.SanPhamService;
import demo.service.SanPhamServiceImpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author MY PC
 */
public class FormSPController {
    private JButton btnSubmit;
    private JTextField jtfMasp;
    private JTextField jtfTensp;
    private JTextField jtfDonvitinh;
    private JTextField jtfSolo;
    private JTextField jtfSoluong;
    private JLabel jlbMes;
    
    private SanPham sp = null;
    private SanPhamService spS = null;

    public FormSPController(JButton btnSubmit, JTextField jtfMasp, JTextField jtfTensp, JTextField jtfDonvitinh, JTextField jtfSolo, JTextField jtfSoluong, JLabel jlbMes) {
        this.btnSubmit = btnSubmit;
        this.jtfMasp = jtfMasp;
        this.jtfTensp = jtfTensp;
        this.jtfDonvitinh = jtfDonvitinh;
        this.jtfSolo = jtfSolo;
        this.jtfSoluong = jtfSoluong;
        this.jlbMes = jlbMes;
        this.spS = new SanPhamServiceImpl();
    }

    
    public void setView(SanPham sp) {
        this.sp = sp;
        jtfMasp.setText(sp.getMahh());
        jtfTensp.setText(sp.getTenhh());
        jtfDonvitinh.setText(sp.getDonvitinh());
        jtfSolo.setText(sp.getSolo());
        jtfSoluong.setText(Integer.toString(sp.getSoluong()));      
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(jtfMasp.getText().length()==0){
               jlbMes.setText("Bạn phải nhập thông tin! ");
               }
               else{
                   sp.setMahh(jtfMasp.getText());
                   sp.setTenhh(jtfTensp.getText());
                   sp.setDonvitinh(jtfDonvitinh.getText());
                   sp.setSolo(jtfSolo.getText());
                   sp.setSoluong(Integer.valueOf(jtfSoluong.getText()));
                   spS.createOrUpdate(sp);
                   jlbMes.setText("Cập nhật dữ liêụ thành công! ");
               }
            }        
        });
    }
}
