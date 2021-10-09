package sistema.presentacion.abonar;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import sistema.logic.Cliente;
import sistema.logic.Mensualidad;
import sistema.logic.Prestamo;

public class Model extends Observable{
    Prestamo prestamo;
    Mensualidad mensualidad;
   // List<Prestamo> prestamos;
   // List<Cliente> clientes;
    List<Mensualidad> mensualidades;

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

   /* public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }*/
//--------------------------------------------------------------------------------------
    public Mensualidad getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(Mensualidad mensualidad) {
        this.mensualidad = mensualidad;
    }
    

    public List<Mensualidad> getMensualidades() {
        return mensualidades;
    }

    public void setMensualidades(List<Mensualidad> mensualidades) {
        System.out.print("SetMensualidades  "); 
        this.mensualidades = mensualidades;
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

