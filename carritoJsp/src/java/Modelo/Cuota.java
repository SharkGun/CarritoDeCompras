
package Modelo;


public class Cuota {
    private  int codigocredito;
     private  int codigoventa;
    private double monto_venta;
    private double monto_cuota;

    public Cuota() {
    }

    public Cuota(int codigocredito, int codigoventa, double monto_venta, double monto_cuota) {
        this.codigocredito = codigocredito;
        this.codigoventa = codigoventa;
        this.monto_venta = monto_venta;
        this.monto_cuota = monto_cuota;
    }

    public int getCodigocredito() {
        return codigocredito;
    }

    public void setCodigocredito(int codigocredito) {
        this.codigocredito = codigocredito;
    }

    public int getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public double getMonto_venta() {
        return monto_venta;
    }

    public void setMonto_venta(double monto_venta) {
        this.monto_venta = monto_venta;
    }

    public double getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(double monto_cuota) {
        this.monto_cuota = monto_cuota;
    }
    
    
}
