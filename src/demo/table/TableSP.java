/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.table;

import demo.model.SanPham;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class TableSP {
    public DefaultTableModel setTableSanPham(List<SanPham> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        SanPham hh = null;
        for (int i = 0; i < num; i++) {
            hh = listItem.get(i);
            obj = new Object[columns];
            obj[0] = hh.getMahh();
            obj[1] = hh.getTenhh();
            obj[2] = hh.getDonvitinh();
            obj[3] = hh.getSolo();
            obj[4] = hh.getSoluong();
            dtm.addRow(obj);
        }
        return dtm;

    }
}
