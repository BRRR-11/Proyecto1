package sistema.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Provincia {
    @XmlID
    String numero;
    String nombre;
    List<Canton> cantones;

    public Provincia(String numero, String nombre, List<Canton> cantones) {
        this.numero = numero;
        this.nombre = nombre;
        this.cantones = cantones;
    }
     public Provincia(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre; 
        cantones = new ArrayList<>();
    }
    public Provincia(String nombre) {
        this.nombre = nombre;
        this.numero = "";
    }
    public Provincia() {
        this.numero = "";
        this.nombre = "";
        this.cantones = new ArrayList();
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

    public List<Canton> getCanton() {
        return cantones;
    }

    public void setCanton(List<Canton> canton) {
        this.cantones = canton;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.cantones);
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
        final Provincia other = (Provincia) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cantones, other.cantones)) {
            return false;
        }
        return true;
    }
  
    @Override
    public String toString() {
        return nombre;
    }
    
    public void comparar(String nom){
        if("San Jose".equals(nom)){
            setNumero("1");
        }
        else{
            if("Alajuela".equals(nom)){
                setNumero("2");
            }
            else{
                if("Cartago".equals(nom)){
                    setNumero("3");
                }
                else{
                    if("Heredia".equals(nom)){
                        setNumero("4");
                    }
                    else{
                        if("Guanacaste".equals(nom)){
                            setNumero("5");
                        }
                        else{
                            if("Puntarenas".equals(nom)){
                                setNumero("6");
                            }
                            else{
                                if("Limon".equals(nom)){
                                    setNumero("7");
                                }
                            }
                        }
                    }
                }
            }
            
        }
                
    }

    
}
