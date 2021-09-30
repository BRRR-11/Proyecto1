/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.abonar;

import sistema.logic.Mensualidad;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class AbonarTableModel extends AbstractTableModel implements TableModel{
    String[] cols ={"Mensualidad","Saldo","Interés","Amortización" };
    List<Mensualidad> rows;

    public  AbonarTableModel(List<Mensualidad> rows){
        this.rows=rows;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int col){
        return cols[col];
    }

    public int getRowCount() {
        return rows.size();
    }
    
    public Class<?> getColumnClass(int columnIndex){
        return Integer.class;
    }
    
    public Object getValueAt(int row, int col) {
        Mensualidad m = rows.get(row);
        java.text.DecimalFormat df = new java.text.DecimalFormat("####");
        switch (col){
            case 0: return df.format(m.getNumero());
            case 1: return df.format(m.getSaldo());
            case 2: return df.format(m.getInteres());
            case 3: return df.format(m.getAmortizacion());
            default: return "";
        }
    }    
}
