/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.model.HoaDonXuat;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import demo.service.XuatKhoService;
import demo.service.XuatKhoServiceImpl;
import demo.table.TableXK;
import demo.view.XuatKhoJFrame;
import demo.view.XuatKhoJFrameCreat;
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
public class XKController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private XuatKhoService xkS = null;
    
    private String[] listColumn = {"Mã xuất", "Ngày xuất", "Mã nhân viên", "Bên nhận"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public XKController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.xkS = new XuatKhoServiceImpl();
    }
    
    public void setDataToTable() {
        List<HoaDonXuat> listItem = xkS.getList();
        
        DefaultTableModel model = new TableXK().setTableXuatKho(listItem, listColumn);
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
                    
                    HoaDonXuat hdx = new HoaDonXuat();
                    hdx.setMaxuat(model.getValueAt(selectedRowIndex, 0).toString());
                    hdx.setNgayxuat((Date) model.getValueAt(selectedRowIndex, 1));                   
                    hdx.setManv(model.getValueAt(selectedRowIndex, 2).toString());
                    hdx.setBennhan(model.getValueAt(selectedRowIndex, 3).toString());
                                                                       
                    XuatKhoJFrame frame = new XuatKhoJFrame(hdx);
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
                XuatKhoJFrameCreat f = new XuatKhoJFrameCreat();
                f.setVisible(true);
                f.setResizable(false);
                f.setLocationRelativeTo(null);  
                f.setTitle("Thông tin chi tiết hóa đơn");
            }  
        });
    }
    
}
