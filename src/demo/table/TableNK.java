/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.table;

import demo.model.HoaDonNhap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class TableNK {
    public DefaultTableModel setTableNhapKho(List<HoaDonNhap> listItem, String[] listColumn) {
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
        HoaDonNhap hdn = null;
        for (int i = 0; i < num; i++) {
            hdn = listItem.get(i);
            obj = new Object[columns];
            obj[0] = hdn.getManhap();
            obj[1] = hdn.getNgaynhap();
            obj[2] = hdn.getManv();
            obj[3] = hdn.getBengui();
            dtm.addRow(obj);
        }
        return dtm;

    }
}
