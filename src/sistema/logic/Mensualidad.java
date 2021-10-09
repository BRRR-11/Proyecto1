package sistema.logic;

public class Mensualidad{
        static int generador=1;
    	double saldo;
	double interes;
	double amortizacion;
        //int cuota;
        //String fecha;
        int  numero;
	public Mensualidad (double s,double i,double a){
            numero = generador++;
            saldo = s;            
            interes = i;
            amortizacion = a;
	}

    public Mensualidad() {
        
    }
        
        
   /* public String getFecha() {
        return fecha;
    } public void setFecha(String fecha) {
        this.fecha = fecha;
    } public int getCuota() {
         return cuota;
    } public void setCuota(int cuota) {
            this.cuota = cuota;
    }*/
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double sald){
        saldo= sald;
    }
    public double getInteres(){
        return interes;
    }
    public void setInteres(double inte){
        interes = inte;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public double getAmortizacion(){
         return amortizacion;
    }
    public void setAmortizacion(double amort){
        amortizacion = amort;
    }
    
    @Override  
    public String toString() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("####");
        return numero+df.format(saldo)+df.format(interes)+df.format(amortizacion);
    }
}
