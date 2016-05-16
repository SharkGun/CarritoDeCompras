
package Modelo;

/**
 *
 * @author Betax
 */
public class DetalleCredito {
    
    
    private int codigoCredito;
    private double monto;
    private String fecha_pago;
    private double interes;
    private double total;

    public DetalleCredito(int codigoCredito, double monto, String fecha_pago, double interes, double total) {
        this.codigoCredito = codigoCredito;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
        this.interes = interes;
        this.total = total;
    }
    
    public DetalleCredito(){
    }
    
    public int getCodigoCredito() {
        return codigoCredito;
    }

    public void setCodigoCredito(int codigoCredito) {
        this.codigoCredito = codigoCredito;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
