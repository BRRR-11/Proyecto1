
package sistema.presentacion.prestamo;

import sistema.logic.Prestamo;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MensualidadTableModel extends AbstractTableModel implements TableModel{
    String[] cols ={"Consecutivo","Monto","Tasa","Plazo","Dia","Mes","Año","Cliente" };
    List<Prestamo> rows;

    public  MensualidadTableModel(List<Prestamo> rows){
        this.rows=rows;
    }

    public int getColumnCount() {
        return 8;
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
        //java.text.DecimalFormat df = new java.text.DecimalFormat("####");
        switch (col){
            case 0: return (m.getNumero());
            case 1: return (m.getMonto());
            case 2: return (m.getTasa());
            case 3: return (m.getPlazo());
            case 4: return (m.getDia());
            case 5: return (m.getMes());
            case 6: return (m.getAnnio());
            case 7: return (m.getCliente().getCedula());
            default: return "";
        }
    }    
}
