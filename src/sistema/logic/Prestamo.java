package sistema.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Prestamo {
        //int num = 0;
        static int generador =3;
        //int numero;
        double monto;
	double tasa;
	double plazo;
        String dia;
        String mes;
        String annio;
        @XmlIDREF
        Cliente cliente;
       // Random rand = new Random();
       // int contador=0;
        int numero;
	public Prestamo(double m, double t, double p,String d, String me, String an, Cliente cli){
            numero = generador++; 
            monto=m;
            tasa=t;
            plazo=p;
            dia = d;
            mes = me;
            annio = an;
            cliente = cli;
	}
        public Prestamo(double m, double t, double p, String d, String me, String an){
            numero = 0;
            monto=m;
            tasa=t;
            plazo=p;
            dia = d;
            mes = me;
            annio = an;
            cliente = new Cliente("","","","","");
        }

	public Prestamo(){
	}

        public int getNumero() {
            return numero;
        }

       /* public void setNumero(String numero) {
            this.numero = numero;
        }*/
        
	public double getMonto(){
            return monto;
	}

	public void setMonto(double monto){
            this.monto = monto;
	}

	public double getTasa(){
            return tasa;
	}

	public void setTasa(double tasa){
            this.tasa = tasa;
	}

	public double getPlazo(){
            return plazo;
	}

	public void setPlazo(double plazo){
            this.plazo = plazo;
	}

        public String getDia() {
             return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public String getMes() {
            return mes;
        }

        public void setMes(String mes) {
            this.mes = mes;
        }

        public String getAnnio() {
            return annio;
        }

        public void setAnnio(String annio) {
            this.annio = annio;
        }
        

	public double getCuota(){
		double cuota;
		cuota   = monto * tasa/100 /(1-Math.pow(1+tasa/100,-plazo));
		return cuota;
	}

	public double getTotal(){
		double total;
		total = this.getCuota() * this.getPlazo();
		return total;
	}

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }
        

	public List<Mensualidad> getMensualidades(){
            Mensualidad m;
            double cuota=this.getCuota();
            double saldo=monto;
            double interes=0;
            double amortizacion=0;
            ArrayList<Mensualidad> resultado = new ArrayList<>();

	    for(int i=0;i<plazo;i++){
	    	 interes = saldo * tasa/100;
	    	 amortizacion = cuota - interes;
                 m = new Mensualidad(i+1,saldo,interes, amortizacion);
                 resultado.add(m);
                 saldo = saldo - amortizacion;                 
            }
            return resultado;
	}

    @Override
    public String toString() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("####");
        return "MONTO: " + df.format(monto) + "    TASA: " + df.format(tasa) + "    PLAZO: " + df.format(plazo)+ "    CUOTA: " + df.format(getCuota());
    }
}
