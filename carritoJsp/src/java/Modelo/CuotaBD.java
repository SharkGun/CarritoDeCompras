/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import utils.Conexion;

/**
 *
 * @author Administrador
 */
public class CuotaBD {
    
     public static boolean insertarCuota(Cuota varCuota) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            cl=Conexion.getConexion().prepareCall("{CALL spI_cuota(?,?,?,?)}");
            //Como el codigo se autogenera y es del tipo OUT en el procedimiento
            //almacenado le decimos que es OUT y el del tipo Integer en Java
            cl.setInt(1, Types.INTEGER);
            //El siguiente parametro del procedimiento almacenado es el nombre
            cl.setInt(2, varCuota.getCodigoventa());
            //Y por ultimo el precio 
            cl.setDouble(3, varCuota.getMonto_venta());
            cl.setDouble(4, varCuota.getMonto_cuota());
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
    
     public static Cuota obtenerCredito(String usu) {
        //El array que contendra todos nuestros productos
        Cuota c=new Cuota();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        try {
            cn = Conexion.getConexion();
            cl=cn.prepareCall("{CALL autogenerado(?)}");
            cl.setString(1, usu);
            rs = cl.executeQuery();
            //Consultamos si hay datos para recorrerlo
            //e insertarlo en nuestro array
            while (rs.next()) {
                
                c.setCodigoventa(rs.getInt("codigo"));
                
                
            }
        } catch (Exception e) {  }
        return c;
    }
    
}
