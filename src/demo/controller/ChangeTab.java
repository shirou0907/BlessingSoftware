/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.model.DanhMucBean;
import demo.model.GlobalData;
import demo.view.NhanVienJPanel;
import demo.view.NhapKhoJPanel;
import demo.view.SanPhamJPanel;
import demo.view.ThongKeJPanel;
import demo.view.TrangChuJPanel;
import demo.view.XuatKhoJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class ChangeTab {
    private final JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    public ChangeTab(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(204,0,0));
        jlbItem.setBackground(new Color(204,0,0));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for(DanhMucBean item: listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
        switch(kind) {
            case "TrangChu":
                node = new TrangChuJPanel();
                break;
            case "NhanVien":
                if(!"NV001".equals(GlobalData.getId())) {
                JOptionPane.showMessageDialog(new Frame(), "Chỉ quản lý mới có quyền truy cập", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                node = new TrangChuJPanel();
                break;  
                }
                else {
                  node = new NhanVienJPanel();
                    break;  
                }
            case "SanPham":
                node = new SanPhamJPanel();
                break;
            case "NhapKho":
                node = new NhapKhoJPanel();
                break;
            case "XuatKho":
                node = new XuatKhoJPanel();
                break;
            case "ThongKe":
                node = new ThongKeJPanel();
                break;
            default: 
                node = new TrangChuJPanel();
                break;
        }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(204,0,0));
            jlbItem.setBackground(new Color(204,0,0));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jpnItem.setBackground(new Color(204,0,0));
            jlbItem.setBackground(new Color(204,0,0));     
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(0,153,153));
                jlbItem.setBackground(new Color(0,153,153));
            }
        }
        
    }
    
    private void setChangeBackground(String kind) {
        for(DanhMucBean item:listItem) {
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(204,0,0));
                item.getJlb().setBackground(new Color(204,0,0));
            }
            else {
                item.getJpn().setBackground(new Color(0,153,153));
                item.getJlb().setBackground(new Color(0,153,153));
            }
        }
    }
}
