package sistema.presentacion.abonar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.logic.Mensualidad;
import sistema.principal.Aplicacion;
import sistema.logic.Prestamo;
import sistema.logic.Service;

public class Controller {
    Model model;
    ViewAbonar view;

    public Controller(Model model, ViewAbonar view) {
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
        Aplicacion.PRESTAMO.show();
    }    
    public void setearCed(String ced){
        this.view.textCedula.setText(ced);
    }
    public void setearNombre(String nom){
        this.view.textNombre.setText(nom);
    }
    public void setearID(String ID){
        this.view.textNumPrestamo.setText(ID);
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
        List<Prestamo> prestamos= Service.instance().prestamoSearch(numero);
        model.setPrestamo(new Prestamo(numero,0,2,0,"","",""));
        model.setPrestamos(prestamos);
        model.commit();
    }*/
    public void mensualidadList(int num){
            List<Mensualidad> mensu = Service.instance().mensualidad(num);
            model.setMensualidad(new Mensualidad(0,0,0,0));
            model.setMensualidades(mensu);
            model.commit();
     
    }
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
