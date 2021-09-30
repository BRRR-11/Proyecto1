package sistema.logic;

import java.util.Objects;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {
    @XmlID
    String cedula;
    String nombre;
    @XmlIDREF
    Provincia provincia;
    @XmlIDREF
    Canton canton;
    @XmlIDREF
    Distrito distrito;
    
    public Cliente(){
        cedula = "";
        nombre = "";
        provincia = new Provincia();
        canton = new Canton();
        distrito = new Distrito();
    }
    
    public Cliente(String ced, String nom){
        cedula = ced;
        nombre = nom;
        provincia = new Provincia();
        canton = new Canton();
        distrito = new Distrito();
    }
   public Cliente(String ced, String nom, String prov, String cant, String dis)
   {
        cedula = ced;
        nombre = nom;
        provincia = new Provincia();
       Object provincia=prov;
       Object canton= cant;
       Object distrito = dis;
   }

    public String getNombre(){
        return nombre;
    }
    public String getCedula(){
        return cedula;
    }
    public Provincia getProvincia(){
        return provincia;
    }
    
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setCedula(String ced){
        cedula = ced;
    }
    public void setProvincia(Provincia prov){
        provincia = prov;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + '}';
    }

    
   
   
    
    
}
