/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.principal;

//import sistema.logic.Provincia;
import sistema.presentacion.clientes.Controller;
import sistema.presentacion.clientes.Mapa;
import sistema.presentacion.clientes.Model;

/**
 *
 * @author ariqq
 */
public class Aplicacion {

    public static void main(String[] args) {
       /* Model model = new Model();
        Mapa m = new Mapa();
        Controller controller = new Controller(model,m);
        m.setVisible(true);
        controller.show();*/
        
       
        sistema.presentacion.clientes.Model modelClientes=new sistema.presentacion.clientes.Model() ;
        sistema.presentacion.clientes.Mapa viewClientes= new sistema.presentacion.clientes.Mapa();
        sistema.presentacion.clientes.Controller controllerClientes = new sistema.presentacion.clientes.Controller(modelClientes,viewClientes);
        CLIENTES = controllerClientes;
        
        sistema.presentacion.prestamo.Model modelPrestamo=new sistema.presentacion.prestamo.Model() ;
        sistema.presentacion.prestamo.View viewPrestamo= new sistema.presentacion.prestamo.View();
        sistema.presentacion.prestamo.Controller controllerPrestamo = new sistema.presentacion.prestamo.Controller(modelPrestamo,viewPrestamo);
        PRESTAMO = controllerPrestamo;
        
        sistema.presentacion.abonar.Model modelAbonar=new sistema.presentacion.abonar.Model() ;
        sistema.presentacion.abonar.ViewAbonar viewAbonar= new sistema.presentacion.abonar.ViewAbonar();
        sistema.presentacion.abonar.Controller controllerAbonar = new sistema.presentacion.abonar.Controller(modelAbonar,viewAbonar);
        ABONAR = controllerAbonar;
        
        sistema.presentacion.prestamoCliente.Model modelPrestamoCliente=new sistema.presentacion.prestamoCliente.Model() ;
        sistema.presentacion.prestamoCliente.View viewPrestamoCliente= new sistema.presentacion.prestamoCliente.View();
        sistema.presentacion.prestamoCliente.Controller controllerPrestamoCliente = new sistema.presentacion.prestamoCliente.Controller(modelPrestamoCliente,viewPrestamoCliente);
        PRESTAMOCLIENTE = controllerPrestamoCliente;
        
        System.out.println("Hola mundo");
        System.out.println("adios mundo");
        
        CLIENTES.show();
        
        
    }
    
    public static sistema.presentacion.prestamoCliente.Controller PRESTAMOCLIENTE;
    public static sistema.presentacion.clientes.Controller CLIENTES;
    public static sistema.presentacion.prestamo.Controller  PRESTAMO;
    public static sistema.presentacion.abonar.Controller  ABONAR;
    
}
