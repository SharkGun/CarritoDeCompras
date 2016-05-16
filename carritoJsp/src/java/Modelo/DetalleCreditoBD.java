
package Modelo;
import java.sql.*;
import java.util.*;
import utils.Conexion;
/**
 *
 * @author Betax
 */
public class DetalleCreditoBD {
    public static boolean insertarDetalleCredito(DetalleCredito varDetalle, Connection cn) {
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            //Preparamos la sentecia
            cl = cn.prepareCall("{CALL spI_detallecredito(?,?,?,?)}");
            //Codigo de la venta
            cl.setInt(1, varDetalle.getCodigoCredito());
            //Codigo del producto
            cl.setDouble(2, varDetalle.getMonto());
            //La cantidad
            cl.setString(3, varDetalle.getFecha_pago());
            //El descuento
            cl.setDouble(4, varDetalle.getInteres());
            cl.setDouble(5, varDetalle.getTotal());
            //Ejecutamos la sentencia y si nos devuelve el valor de 1 es porque
            //registro de forma correcta los datos
            rpta = cl.executeUpdate() == 1 ? true : false;
            
        } catch (Exception e) {}
        return rpta;
    }
}
