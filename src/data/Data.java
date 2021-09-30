package data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import sistema.logic.Canton;
import sistema.logic.Cliente;
import sistema.logic.Distrito;
import sistema.logic.Prestamo;
import sistema.logic.Provincia;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
   private List<Cliente> clientes;
   private List<Provincia> provincias;
   private List<Canton> cantones;
   private List<Distrito> distritos;
   private List<Prestamo> prestamos;
   
   public Data(){
       clientes = new ArrayList();
       provincias = new ArrayList();
       cantones = new ArrayList();
       distritos = new ArrayList();
       prestamos = new ArrayList();
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

    public List<Canton> getCantones() {
        return cantones;
    }

    public void setCantones(List<Canton> cantones) {
        this.cantones = cantones;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }
    
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
}
