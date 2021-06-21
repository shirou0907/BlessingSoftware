/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.table;

import demo.model.HoaDonXuat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class TableXK {
    public DefaultTableModel setTableXuatKho(List<HoaDonXuat> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        HoaDonXuat hdx = null;
        for (int i = 0; i < num; i++) {
            hdx = listItem.get(i);
            obj = new Object[columns];
            obj[0] = hdx.getMaxuat();
            obj[1] = hdx.getNgayxuat();
            obj[2] = hdx.getManv();
            obj[3] = hdx.getBennhan();
            dtm.addRow(obj);
        }
        return dtm;

    }
}
