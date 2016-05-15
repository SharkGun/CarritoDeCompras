package Modelo;
import java.sql.*;
import java.util.*;
import utils.Conexion;

public class ProductoBD {
    
        //Metodo utilizado para obtener todos los productos de nuestra base de datos

    public static ArrayList<Producto> obtenerProducto() {
        //El array que contendra todos nuestros productos
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        
        try {
            cl=Conexion.getConexion().prepareCall("{CALL spF_producto_all()}");
            //La sentencia lo almacenamos en un resulset
            rs = cl.executeQuery();
            //Consultamos si hay datos para recorrerlo
            //e insertarlo en nuestro array
            while (rs.next()) {
                Producto p = new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
                 //Lo adicionamos a nuestra lista
                lista.add(p);
            }
        } catch (Exception e) {  }
        return lista;
    }

    
 //Metodo utilizado para insertar un Producto a nuestra Base de datos

    public static boolean insertarProducto(Producto varproducto) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            cl=Conexion.getConexion().prepareCall("{CALL spI_producto(?,?,?,?)}");
            //Como el codigo se autogenera y es del tipo OUT en el procedimiento
            //almacenado le decimos que es OUT y el del tipo Integer en Java
            cl.registerOutParameter(1, Types.INTEGER);
            //El siguiente parametro del procedimiento almacenado es el nombre
            cl.setString(2, varproducto.getNombre());
            //Y por ultimo el precio 
            cl.setDouble(3, varproducto.getPrecio());
            cl.setString(4, varproducto.getImagen());
            //Ejecutamos la sentencia y si nos devuelve el valor de 1 es porque
            //registro de forma correcta los datos
            int i=cl.executeUpdate();
            if(i==1){
                rpta=true;
            }else{
                rpta=false;
            }
        } catch (Exception e) { }
        return rpta;
    }
    
   public static Producto obtenerProducto(int codigo) {
        Producto p = new Producto();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        try {
            //Nombre del procedimiento almacenado
            cn = Conexion.getConexion();
            cl = cn.prepareCall("{CALL spF_producto_one(?)}");
            cl.setInt(1, codigo);
            //La sentencia lo almacenamos en un resulset
            rs = cl.executeQuery();
            //Consultamos si hay datos para recorrerlo
            //e insertarlo en nuestro array
            while (rs.next()) {
                //Obtenemos los valores de la consulta y creamos
                //nuestro objeto producto
                p.setCodigoProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setImagen(rs.getString(4));
            }

        }catch (Exception e) {}
        return p;
    }
   
   
    //Metodo utilizado para insertar un Producto a nuestra Base de datos
    public static boolean actualizarProducto(Producto varproducto) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            //Obtenemos la conexion
            cn = Conexion.getConexion();
            //Preparamos la sentecia
            cl = cn.prepareCall( "{CALL spU_producto(?,?,?)}");
            //El primer parametro del procedimiento almacenado es el codigo
            cl.setInt(1, varproducto.getCodigoProducto());
            //El siguiente parametro del procedimiento almacenado es el nombre
            cl.setString(2, varproducto.getNombre());
            //Y por ultimo el precio
            cl.setDouble(3, varproducto.getPrecio());
            //Ejecutamos la sentencia y si nos devuelve el valor de 1 es porque
            //registro de forma correcta los datos
            int i=cl.executeUpdate();
            
            if(i==1){
            rpta = true;
            }else{
            rpta = false;
            }
        } catch (Exception e) {}
        return rpta;
    }
  
}

