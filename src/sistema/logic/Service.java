package sistema.logic;

import data.Data;
import data.XmlPersister;
import java.util.List;
import java.util.stream.Collectors;



public class Service {
    // Singleton implementation
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    // Service data
    
    private Data data;
    
    public List<Cliente> clienteAll(){
        return data.getClientes();       
    }
    public List<Provincia> getProvincias(){
        return data.getProvincias();
    }
    public List<Cliente> getCliente(){
        return data.getClientes();
    }
    public List<Canton> getCanton(){
        return data.getCantones();
    }
    public List<Distrito> getDistrito(){
        return data.getDistritos();
    }
    
    public Cliente clienteGet(String cedula) throws Exception{
        Cliente result=data.getClientes().stream().filter(c->c.getCedula().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cliente no existe");   
    }
     public List<Cliente> clienteSearch(String cedula){
        List<Cliente> result=data.getClientes().stream().filter(c->c.getCedula().startsWith(cedula)).collect(Collectors.toList());
       return result;        
    }
     public void creandoCliente(Cliente cli) throws Exception {
        Cliente resul = data.getClientes().stream().filter(c->c.getCedula().equals(cli.getCedula())).findFirst().orElse(null);
        if(resul == null)data.getClientes().add(cli); 
        else throw new Exception("Cliente ya existe");
            
        //XmlPersister.instance().store(data);
            //return resul;
        
    }
    public Provincia provinciaGet(String numero) throws Exception{
        Provincia result=data.getProvincias().stream().filter(f->f.getNumero().equals(numero)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Provincia no existe");   
    }
    public List<Provincia> provinciaSearch(String numero){
        List<Provincia> result=data.getProvincias().stream().filter(f->f.getNumero().startsWith(numero)).collect(Collectors.toList());
        return result;        
    }
    public void creandoProvincia(Provincia provincia){
        Provincia resul = data.getProvincias().stream().filter(c->c.getNumero().equals(provincia.getNumero())).findFirst().orElse(null);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public List<Canton> buscarCanton(String nomp) throws Exception{
         Provincia result=data.getProvincias().stream().filter(f->f.getNombre().equals(nomp)).findFirst().orElse(null);
         if (result!=null) return result.getCanton();
         else  throw new Exception("Canton no existe");  
    }
    
  
    
    //------------------------------------------------------------------------------------------------------------------------
    public Prestamo prestamoGet(int numero) throws Exception{
        Prestamo result=data.getPrestamos().stream().filter(f->f.getNumero()==(numero)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Factura no existe");   
    }
    
   /* public List<Prestamo> prestamoSearch(int numero){
        List<Prestamo> result=data.getPrestamos().stream().filter(f->f.getNumero().startsWith(numero)).collect(Collectors.toList());
        return result;        
    }*/
    
    public void prestamoAdd(Prestamo prestamo) throws Exception{
        Prestamo old=data.getPrestamos().stream().filter(f->f.getNumero()==(prestamo.getNumero())).findFirst().orElse(null);
        if (old==null) data.getPrestamos().add(prestamo);
        else throw new Exception("Factura ya existe");           
        
    } 
     //------------------------------------------------------------------------------------------------------------------------
     public void store(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception ex) {
        }
    }
    public Service() {
        try{
            data = XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }
    }
   
    
}
