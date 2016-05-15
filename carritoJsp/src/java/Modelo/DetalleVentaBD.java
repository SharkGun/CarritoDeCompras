package Modelo;

import java.sql.*;
import java.util.*;
import utils.Conexion;

public class DetalleVentaBD {
    //Metodo utilizado para insertar un Detalle de Venta a nuestra Base de datos
    //Obtenemos la conexion de Venta debido a que la clase Venta es la que inicia
    //la transaccion
    public static boolean insertarDetalleVenta(DetalleVenta varDetalle, Connection cn) {
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            //Preparamos la sentecia
            cl = cn.prepareCall("{CALL spI_detalleventa(?,?,?,?)}");
            //Codigo de la venta
            cl.setInt(1, varDetalle.getCodigoVenta());
            //Codigo del producto
            cl.setInt(2, varDetalle.getCodigoProducto());
            //La cantidad
            cl.setDouble(3, varDetalle.getCantidad());
            //El descuento
            cl.setDouble(4, varDetalle.getDescuento());
            //Ejecutamos la sentencia y si nos devuelve el valor de 1 es porque
            //registro de forma correcta los datos
            rpta = cl.executeUpdate() == 1 ? true : false;
            
        } catch (Exception e) {}
        return rpta;
    }
    //metodo para obtener el detalle de las ventas
    public static ArrayList<DetalleVenta> obtenerDetalleVenta(int codigo) {
        
       ArrayList<DetalleVenta> lista = new ArrayList<DetalleVenta>();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        try {
            //Nombre del procedimiento almacenado
            cn = Conexion.getConexion();
            cl = cn.prepareCall("{CALL spF_venta_one(?)}");
            cl.setInt(1, codigo);
            //La sentencia lo almacenamos en un resulset
            rs = cl.executeQuery();
            //Consultamos si hay datos para recorrerlo
            //e insertarlo en nuestro array
            while (rs.next()) {
                DetalleVenta v=new DetalleVenta();
                //Obtenemos los valores de la consulta y creamos
                //nuestro objeto producto
                v.setCodigoVenta(rs.getInt(1));
                v.setCliente(rs.getString(2));
                v.setFecha(rs.getString(3));
                v.setCodigoProducto(rs.getInt(4));
                v.setNombre(rs.getString(5));
                v.setPrecio(rs.getDouble(6));
                v.setCantidad(rs.getInt(7));
                v.setDescuento(rs.getDouble(8));
                v.setParcial(rs.getDouble(9));
                v.setSubtotal(rs.getDouble(10));
                v.setTotal(rs.getDouble(11));
                lista.add(v);
            }
        }catch (Exception e) {}
        return lista;
    }

}
