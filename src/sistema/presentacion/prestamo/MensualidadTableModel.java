
package sistema.presentacion.prestamo;

import sistema.logic.Prestamo;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MensualidadTableModel extends AbstractTableModel implements TableModel{
    String[] cols ={"Monto","Tasa","Plazo","Fecha" };
    List<Prestamo> rows;

    public  MensualidadTableModel(List<Prestamo> rows){
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
        Prestamo m = rows.get(row);
        java.text.DecimalFormat df = new java.text.DecimalFormat("####");
        switch (col){
            case 0: return df.format(m.getMonto());
            case 1: return df.format(m.getTasa());
            case 2: return df.format(m.getPlazo());
            case 3: return df.format(m.getAnnio()+m.getMes()+m.getDia());
            default: return "";
        }
    }    
}
/* int numero;
        double monto;
	double tasa;
	double plazo;
        String dia;
        String mes;
        String annio;*/