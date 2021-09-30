package sistema.presentacion.clientes;

import java.util.List;
import sistema.logic.Provincia;
import sistema.logic.Cliente;
import java.util.Observable;
import java.util.Observer;
import sistema.logic.Canton;
import sistema.logic.Distrito;

public class Model extends Observable{
     // Model attributes here
    // Model gets and sets here

    Cliente cliente;
    Provincia provincia;
    Canton canton;
    List<Cliente> clientes;
    List<Provincia> provincias;
    List<Canton> cantones;
    List<Distrito> distritos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
    public Canton getCanton(){
        return canton;
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
     
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        this.commit();
    }
    
    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
}
