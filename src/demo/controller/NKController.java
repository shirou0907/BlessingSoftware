/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.model.HoaDonNhap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import demo.service.NhapKhoService;
import demo.service.NhapKhoServiceImpl;
import demo.table.TableNK;
import demo.view.NhapKhoJFrame;
import demo.view.NhapKhoJFrameCreat;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MY PC
 */
public class NKController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private NhapKhoService nkS = null;
    
    private String[] listColumn = {"Mã nhập", "Ngày nhập", "Mã nhân viên", "Bên gửi"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public NKController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.nkS = new NhapKhoServiceImpl();
    }
    
    public void setDataToTable() {
        List<HoaDonNhap> listItem = nkS.getList();
        
        DefaultTableModel model = new TableNK().setTableNhapKho(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1 ){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
//                    System.out.println(selectedRowIndex);
                    
                    HoaDonNhap hdn = new HoaDonNhap();
                    hdn.setManhap(model.getValueAt(selectedRowIndex, 0).toString());
                    hdn.setNgaynhap((Date) model.getValueAt(selectedRowIndex, 1));                   
                    hdn.setManv(model.getValueAt(selectedRowIndex, 2).toString());
                    hdn.setBengui(model.getValueAt(selectedRowIndex, 3).toString());
                                                                       
                    NhapKhoJFrame frame = new NhapKhoJFrame(hdn);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin hóa đơn");
                    frame.setVisible(true);
                }
            }   
        });
        
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100,68));
//        table.getTableHeader().setBackground(new Color(255,10,10));
//        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
//        table.setBackground(new Color(255,255,255));
//        table.setSelectionBackground(new Color(0, 100, 255, 105));
//        table.setSelectionForeground(new Color(255,255,255));
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 600));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
        table.getColumnModel().getColumn(3).setMinWidth(200);
    }
    
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhapKhoJFrameCreat f = new NhapKhoJFrameCreat();
                f.setVisible(true);
                f.setResizable(false);
                f.setLocationRelativeTo(null);  
                f.setTitle("Thông tin chi tiết hóa đơn");
            }  
        });
    }
    
}
