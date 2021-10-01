package sistema.logic;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Distrito {
    @XmlID
    String numero;
    String nombre;

    public Distrito(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }
    public Distrito() {
        this.numero = "";
        this.nombre = "";
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

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.numero);
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
      return this.numero.equals(((Distrito)obj).numero);
    }
    
}
