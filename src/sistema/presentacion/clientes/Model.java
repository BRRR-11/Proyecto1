package sistema.presentacion.clientes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.logic.Provincia;
import sistema.logic.Cliente;
import java.util.Observable;
import java.util.Observer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
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
    List<Cliente> clientes;
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
    
    
    //////////////  PARTE PDF  //////////////    
    
    public void clientesPDF() throws IOException{
        try(PDDocument document= new PDDocument()){
            File archivo = new File("ListadoClientes.pdf");
            if(archivo.exists()){
                archivo.delete();
            }
            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.OVERWRITE, false);
            for (int i = 0, ii = 10; this.getClientes().size() >= i; i++, ii += 10) {
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 10);
                contentStream.newLineAtOffset(5, page.getMediaBox().getHeight() - ii);
                contentStream.showText(i + this.getClientes().get(i).toString());
                contentStream.endText();
            }
        }
    }
    
    
    public void prestamosClientesPDF(){
        String id = cliente.getCedula();
        //int id = Integer.parseInt(map.TextoID.getText());
        try (PDDocument document = new PDDocument()) {
            File archivo = new File("ListadoPrestamosPC" + id + ".pdf");
            if (archivo.exists()) {
                archivo.delete();
            }
            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.OVERWRITE, false);
            for (int i = 0; i < this.getClientes().size(); i++) {
                if (id == this.getClientes().get(i).getCedula()) {
                    /*
                    for (int j = 0, ii = 10; j < this.getClientes().get(i).getPrestamosCliente().getPrestamos().size(); j++, ii += 10) {
                        contentStream.beginText();
                        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 10);
                        contentStream.newLineAtOffset(5, page.getMediaBox().getHeight() - ii);
                        contentStream.showText(j + this.getClientes().get(i).getPrestamosCliente().getPrestamos().get(j).toString());
                        contentStream.endText();
                    }*/
                }
            }
            contentStream.close();
            document.save(new File("ListadoPrestamosPC" + id + ".pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void pagosPrestamos() {
        int id = 0;
       // Integer id = (Integer) ventanaPrestamo.numerosPrestamos.getSelectedItem();
        try (PDDocument document = new PDDocument()) {
            File archivo = new File("ListadoPagos" + id + ".pdf");
            if (archivo.exists()) {
                archivo.delete();
            }
            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.OVERWRITE, false);
            /*
            for (int i = 0; i < this.getClientes().size(); i++) {
                for (int j = 0; j < this.getClientes().get(i).getPrestamosCliente().getPrestamos().size(); j++) {
                    if (id == this.getClientes().get(i).getPrestamosCliente().getPrestamos().get(j).getNumeroPrestamo()) {
                        for (int k = 0, ii = 10;k < this.getClientes().get(i).getPrestamosCliente().getPrestamos().get(j).getPagos().getPagos().size(); k++, ii += 10 ) {
                            contentStream.beginText();
                            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 10);
                            contentStream.newLineAtOffset(5, page.getMediaBox().getHeight() - ii);
                            contentStream.showText(j + this.getClientes().get(i).getPrestamosCliente().getPrestamos().get(j).getPagos().getPagos().get(k).toString());
                            contentStream.endText();
                        }
                    }
                }
            }
            */
            contentStream.close();
            document.save(new File("ListadoPagos" + id + ".pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}