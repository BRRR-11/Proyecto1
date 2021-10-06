package data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import sistema.logic.Canton;
import sistema.logic.Cliente;
import sistema.logic.Distrito;
import sistema.logic.Mensualidad;
import sistema.logic.Prestamo;
import sistema.logic.Provincia;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
   private List<Cliente> clientes;
   private List<Prestamo> prestamos;
   private List<Mensualidad> mensualidades;
   private List<Provincia> provincias;
   
   public Data(){
       clientes = new ArrayList();
       prestamos = new ArrayList();
       mensualidades = new ArrayList();
       provincias = new ArrayList();
   }
   public List<Cliente> getClientes() {
        return clientes;
   }
   
   public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
   }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

 
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Mensualidad> getMensualidades() {
        return mensualidades;
    }

    public void setMensualidades(List<Mensualidad> mensualidades) {
        this.mensualidades = mensualidades;
    }
    
    
}
