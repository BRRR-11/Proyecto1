package sistema.presentacion.prestamo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Aplicacion.PRESTAMOCLIENTE.show();
    }    
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
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
}
