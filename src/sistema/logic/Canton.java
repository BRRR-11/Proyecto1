package sistema.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Canton {
    @XmlID
    String numero;
    String nombre;
    List<Distrito> distritos;

    public Canton(String numero, String nombre, List<Distrito> distritos) {
        this.numero = numero;
        this.nombre = nombre;
        this.distritos = distritos;
    }
     public Canton(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }
    public Canton() {
        this.numero = "";
        this.nombre = "";
        this.distritos = new ArrayList();
    }    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Distrito> getDistrito() {
        return distritos;
    }

    public void setDistrito(List<Distrito> distritos) {
        this.distritos = distritos;
    }
    
    @Override
    public String toString() {
        return nombre;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.numero);
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.distritos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       return this.numero.equals(((Canton)obj).numero);
    }


   
    
}
