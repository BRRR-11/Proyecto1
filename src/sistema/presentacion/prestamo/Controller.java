package sistema.presentacion.prestamo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.logic.Cliente;
import sistema.principal.Aplicacion;
import sistema.logic.Prestamo;
import sistema.logic.Service;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setPrestamo(new Prestamo(0,2,0,"","",""));
        model.setPrestamos(new ArrayList<>());
        model.setClientes(Service.instance().clienteAll());
        
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
        Aplicacion.CLIENTES.show();
        //Aplicacion.PRESTAMOCLIENTE.show();
    }
    public void abonarShow(String ced, String nom, String ID){
        this.hide();
        Aplicacion.ABONAR.show();
        Aplicacion.ABONAR.setearCed(ced);
        Aplicacion.ABONAR.setearNombre(nom);
        Aplicacion.ABONAR.setearID(ID);
    }

    public void setearCed(String ced){
            this.view.cedText.setText(ced);
            //prestamoTable.clearSelection();
    }
    public void setearNombre(String ced){
        this.view.nombreText.setText(getCliente(ced).getNombre());
    }
    public Cliente getCliente(String ced)
    {
        Cliente cliente;
        try {
            cliente = Service.instance().clienteGet(ced);
            //this.view.nombreText.setText(cliente.getNombre()); //cliente
            return cliente; 
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    public void prestamoListar(String id)
    {
        List<Prestamo> prestamo = Service.instance().prestamoSearch(id);
        model.setPrestamo(new Prestamo(0,0,0,"","","", this.getCliente(id)));
        model.setPrestamos(prestamo);
        model.commit();
    }
    
    public void prestamoGet(int numero){
        try {
            Prestamo prestamo = Service.instance().prestamoGet(numero);
            model.setPrestamo(prestamo);
            model.setPrestamos(Arrays.asList(prestamo));
            model.commit();
        } catch (Exception ex) {
            model.setPrestamo(new Prestamo());
            model.setPrestamos(new ArrayList<>());
            model.commit();
        }
    }
    
   /* public void prestamoSearch(String numero){
        //List<Prestamo> prestamos= Service.instance().prestamoSearch(numero);
        model.setPrestamo(new Prestamo(0,2,0,"","",""));
        model.setPrestamos(prestamos);
        model.commit();
    }*/
    
    public void prestamoEdit(int row){
        Prestamo prestamo = model.getPrestamos().get(row);
        model.setPrestamo(prestamo);
        model.commit();
    }
    
    public void prestamoAdd(Prestamo prestamo){
        try {
            Service.instance().prestamoAdd(prestamo);
            model.setPrestamo(new Prestamo(0,2,0,"","",""));
            model.setPrestamos(Arrays.asList(prestamo));
            model.commit();
        } catch (Exception ex) {
            
        }
        
    }
    
    public void verificar(String abono, int numero )
    {
        try{
           Prestamo prestamo = Service.instance().verificarCuota(abono, numero);
           double ab=Double.parseDouble(abono);
            model.setPrestamo(new Prestamo(ab,2,0,"","",""));
            model.setPrestamos(Arrays.asList(prestamo));
        }catch(Exception ex){
        }
    }
    
}
