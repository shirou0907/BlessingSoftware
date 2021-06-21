/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.model.NhanVien;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import demo.service.NhanVienService;
import demo.service.NhanVienServiceImpl;
import demo.table.TableNV;
import demo.view.NhanVienJFrame;
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
public class NVController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private NhanVienService nvS = null;
    
    private String[] listColumn = {"Mã nhân viên", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "CMND", "Chức vụ"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public NVController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.nvS = new NhanVienServiceImpl();
    }
    
    public void setDataToTable() {
        List<NhanVien> listItem = nvS.getList();
        
        DefaultTableModel model = new TableNV().setTableNhanVien(listItem, listColumn);
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
                    
                    NhanVien nv = new NhanVien();
                    nv.setMavn(model.getValueAt(selectedRowIndex, 0).toString());
                    nv.setHoten(model.getValueAt(selectedRowIndex, 1).toString());
                    nv.setNgaysinh((Date) model.getValueAt(selectedRowIndex, 2));
                    nv.setGioitinh(model.getValueAt(selectedRowIndex, 3).toString().equalsIgnoreCase("Nam"));
                    nv.setSdt(model.getValueAt(selectedRowIndex, 4).toString());
                    nv.setCmnd(model.getValueAt(selectedRowIndex, 5).toString());
                    nv.setChucvu(model.getValueAt(selectedRowIndex, 6).toString());
                                                                       
                    NhanVienJFrame frame = new NhanVienJFrame(nv);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setTitle("Thông tin nhân viên");
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
        table.getColumnModel().getColumn(1).setMinWidth(160);
    }
    
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVienJFrame frame = new NhanVienJFrame(new NhanVien());
                frame.setVisible(true);
                frame.setResizable(true);
                frame.setLocationRelativeTo(null);    
            }
        });
    }
    
}
