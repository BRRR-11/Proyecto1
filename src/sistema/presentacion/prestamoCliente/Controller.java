package sistema.presentacion.prestamoCliente;
import sistema.principal.Aplicacion;
import sistema.logic.Service;

public class Controller {
        Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
        Aplicacion.CLIENTES.show();
    }
    
    public void exit(){
        Service.instance().store();
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
   /* public void clientesShow(){
        this.hide();
        Aplicacion.CLIENTES.show();
    }*/
    
     public void prestamoShow(){
        this.hide();
        Aplicacion.PRESTAMO.show();
    }
     
     public void abonarShow()
     {
        this.hide();
        Aplicacion.ABONAR.show();
     }
    
    /*public void facturasShow(){
        this.hide();
        Application.FACTURAS.show();
    }  */
}
