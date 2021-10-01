package sistema.presentacion.clientes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.logic.Provincia;
import sistema.logic.Cliente;
import java.util.Observable;
import java.util.Observer;
import sistema.logic.Canton;
import sistema.logic.Distrito;
import sistema.logic.Service;

public class Model extends Observable{
     // Model attributes here
    // Model gets and sets here

    Cliente cliente;
    Provincia provincia;
    Canton canton;
    Distrito distrito;
    //List<Cliente> clientes;
    List<Provincia> provincias;
    List<Canton> cantones;
    List<Distrito> distritos;

    public Model() {
        
        cliente = new Cliente();
        provincia = new Provincia();
        canton = new Canton();
        distrito = new Distrito();
       // clientes = new ArrayList();
        provincias = new ArrayList();
        cantones  = new ArrayList();
        distritos = new ArrayList();
 
    }

    
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   /* public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
*/
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

    public Distrito getDistrito() {
        return distrito;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
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

    void crearCliente(Cliente cli) throws Exception {
        Service.instance().creandoCliente(cli);
        this.commit();
        
    }
    
    
      public void buscar(String provincia) throws Exception 
    {
        List<Canton> cantones = Service.instance().buscarCanton(provincia);
        this.setCantones(cantones);
        this.setDistritos(cantones.get(0).getDistrito());
        this.commit();
       
    }
    public void consultar(String cedula) throws Exception{

        Cliente cliente = Service.instance().clienteGet(cedula);
        this.setCliente(cliente);
        this.provincia = Service.instance().buscarProvinciaNombre(cliente.getProvincia());
        this.canton = provincia.getCanton().stream().filter(f->f.getNumero().equals(cliente.getCanton())).findFirst().orElse(null);
        this.distrito = canton.getDistrito().stream().filter(f->f.getNumero().equals(cliente.getDistrito())).findFirst().orElse(null);
        this.commit();
       
    }

    void guardarDatos() {
        Service.instance().store();
    }
}