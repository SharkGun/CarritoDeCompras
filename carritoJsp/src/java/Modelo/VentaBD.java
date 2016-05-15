package Modelo;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import utils.Conexion;
import static utils.Conexion.getConexion;

public class VentaBD {
    
        //Metodo utilizado para insertar una Venta a nuestra Base de datos
    public static boolean insertarVenta(Venta varventa, ArrayList<DetalleVenta> detalle) {

        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            //Obtenemos la conexion
            cn = Conexion.getConexion();
            //Preparamos la sentecia
            cl = cn.prepareCall("{CALL spI_venta(?,?)}");
            //Como el codigo se autogenera y es del tipo OUT en el procedimiento
            //almacenado le decimos que es OUT y el del tipo Integer en Java
            cl.registerOutParameter(1, Types.INTEGER);
            //El siguiente parametro del procedimiento almacenado es el cliente
            cl.setString(2, varventa.getCliente());
            //Ejecutamos la sentencia y si nos devuelve el valor de 1 es porque
            //registro de forma correcta los datos
            int i=cl.executeUpdate();
            if(i== 1){
                rpta=true;
            }
            //Codigo que se genero producto de la insercion ---> codigoVenta
            varventa.setCodigoVenta(cl.getInt(1));
            if (rpta) {
                for (DetalleVenta det : detalle) {
                    //Establecemos al detalle el codigo genero producto de la venta
                    det.setCodigoVenta(varventa.getCodigoVenta());
                    //Insertamos el detalle y le pasamos la conexion
                    rpta = DetalleVentaBD.insertarDetalleVenta(det, cn);
                    //Si nos devuelve false salimos del for
                    if (!rpta) {
                        break;
                    }
                }
                
            } 
        }catch (Exception e) {}
        return rpta;
    }

      //Metodo utilizado para obtener todas las ventas

    public static ArrayList<Venta> obtenerVentas(String usu) {
        //El array que contendra todos nuestros productos
        ArrayList<Venta> lista = new ArrayList<Venta>();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        String user=null;
        cliente c=new cliente();
        
        try {
            cl=Conexion.getConexion().prepareCall("{CALL spI_venta_1(?)}");
            cl.setString(1, usu);
            //La sentencia lo almacenamos en un resulset
            rs = cl.executeQuery();
            //Consultamos si hay datos para recorrerlo
            //e insertarlo en nuestro array
            while (rs.next()) {
                Venta v=new Venta(rs.getInt(1), rs.getString(2), rs.getTimestamp(3));
                 //Lo adicionamos a nuestra lista
                lista.add(v);
            }
        } catch (Exception e) {  }
        return lista;
    }
    
    
    
   public void deleteUsuario(int StrCodigo,int id){                
        PreparedStatement pst = null;
        String StrSQL = "delete from detalleventa \n" +
"where  codigoVenta= ? and codigoProducto = ?";
        try {			
            pst= getConexion().prepareStatement(StrSQL);
            pst.setInt(1, StrCodigo);
            pst.setInt(2, id);
            // execute delete SQL stetement
            pst.executeUpdate();
            System.out.println("Registro eliminado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println(this.getClass().getName()+ ": " + e);
            }
        }
        
    }
  
}
