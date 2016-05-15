package Modelo;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Conexion;

public class clienteBD extends Conexion {
   public Boolean Login(String newUser, String newPwd) {
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            String StrSQL="SELECT * FROM cliente WHERE usuario=? AND password=?";
            pst = getConexion().prepareStatement(StrSQL);
            pst.setString(1, newUser);
            pst.setString(2, newPwd);
            
            rs=pst.executeQuery();
            //if(rs.absolute(1)) {
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   
   
    public static boolean insertarCliente(cliente varcliente) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            cl=Conexion.getConexion().prepareCall("{CALL spI_cliente(?,?,?,?,?)}");
            //Como el codigo se autogenera y es del tipo OUT en el procedimiento
            //almacenado le decimos que es OUT y el del tipo Integer en Java
            cl.registerOutParameter(1, Types.INTEGER);
            //El siguiente parametro del procedimiento almacenado es el nombre
            cl.setString(2, varcliente.getNombre());
            //Y por ultimo el precio 
            cl.setString(3, varcliente.getApellido());
            cl.setString(4, varcliente.getUsuario());
            cl.setString(5, varcliente.getPassword());
            int i=cl.executeUpdate();
            if(i==1){
                rpta=true;
            }else{
                rpta=false;
            }
        } catch (Exception e) { }
        return rpta;
    }
}
