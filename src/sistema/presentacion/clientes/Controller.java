package sistema.presentacion.clientes;

import sistema.logic.Cliente;
import sistema.logic.Provincia;
import sistema.logic.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.logic.Canton;
import sistema.principal.Aplicacion;

public class Controller {
     Model model;
     Mapa view;

    public Controller(Model model, Mapa view) {
        this.model = model;
        this.view = view;
       
        model.setCliente(new Cliente());
        model.setClientes(new ArrayList<>());
        model.setProvincia(new Provincia());
        //model.setProvincias(new ArrayList<>());
        model.setProvincias(Service.instance().getProvincias());
       // model.setCantones(new ArrayList<>());
        model.setCantones(Service.instance().getCanton());
        model.setDistritos(Service.instance().getDistrito());
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void showPrestamoCliente()
    {
      this.hide();
      Aplicacion.PRESTAMOCLIENTE.show();
    }
    
    public void buscar(String dato) 
    {
        try{
            List<Canton> cantones = Service.instance().buscarCanton(dato);
            model.setCantones(cantones);
            model.commit();
        }
        catch (Exception ex) 
        {
            model.setCantones(new ArrayList<>());
            model.commit();
        }
    }
    public void consultar(String cedula){
         try {
             Cliente cliente = Service.instance().clienteGet(cedula);
             model.setCliente(cliente);
             model.commit();
         } catch (Exception ex) {
            model.setCliente(new Cliente());
            model.commit();
         }
    }
    public void guardar(Cliente cli){
        try{
         Service.instance().creandoCliente(cli);
         model.setCliente(cli);
         model.setClientes(Arrays.asList(cli));
         model.commit(); 
         
        }
        catch (Exception exi){
           // model.setCliente(new Cliente());
            //model.commit();
        }
    }

    private void hide() {
        this.view.setVisible(false);
    }
    
}
