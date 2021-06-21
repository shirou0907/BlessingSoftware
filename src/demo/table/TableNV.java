/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.table;

import demo.model.NhanVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class TableNV {
    public DefaultTableModel setTableNhanVien(List<NhanVien> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhanVien nv = null;
        for (int i = 0; i < num; i++) {
            nv = listItem.get(i);
            obj = new Object[columns];
            obj[0] = nv.getMavn();
            obj[1] = nv.getHoten();
            obj[2] = nv.getNgaysinh();
            obj[3] = nv.isGioitinh() == true ? "Nam" : "Nữ";
            obj[4] = nv.getSdt();
            obj[5] = nv.getCmnd();
            obj[6] = nv.getChucvu();
            dtm.addRow(obj);
        }
        return dtm;

    }
}
