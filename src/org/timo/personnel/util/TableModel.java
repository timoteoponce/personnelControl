/*
 * ModeloTabla.java
 *
 * Created on 27 de abril de 2008, 1:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.timo.personnel.util;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juan Timoteo Ponce Ortiz
 */
public class TableModel extends AbstractTableModel {

    private final ArrayList<Object[]> dataList;

    private final String[] columnNames;

    public TableModel(String[] cols, Collection<Object[]> data) {
        if (cols == null || data == null) {
            throw new IllegalArgumentException(
                    "Constructor arguments must be not null");
        }
        this.columnNames = cols;
        this.dataList = new ArrayList<Object[]>();
        this.dataList.addAll(data);
    }

    public Object getValueAt(int fila, int columna) {
        if (fila < dataList.size()) {
            return dataList.get(fila)[columna];
        }
        return null;
    }

    public void setData(Collection<Object[]> data) {
        dataList.clear();
        this.dataList.addAll(data);
        fireTableDataChanged();
    }

    public void addRow(Object[] data) {
        if (data.length != columnNames.length) {
            throw new IllegalStateException(
                    "Values are different than declared columns");
        }
        dataList.add(data);
        fireTableDataChanged();

    }

    public void deleteRow(int index) {
        if (index < dataList.size()) {
            dataList.remove(index);
            fireTableDataChanged();
        }
    }

    public int getRowCount() {
        return dataList.size();
    }

    public String getColumnName(int columna) {
        return columnNames[columna];
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public void setValueAt(Object ele, int fila, int columna) {
        dataList.get(fila)[columna] = ele;
        fireTableCellUpdated(fila, columna);
    }

    public Class getColumnClass(int columna) {
        return getValueAt(0, columna).getClass();
    }

    public boolean contains(Object data) {
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < columnNames.length; j++) {
                if (getValueAt(i, j).equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void clear() {
        this.dataList.clear();        
        fireTableDataChanged();
    }
}
