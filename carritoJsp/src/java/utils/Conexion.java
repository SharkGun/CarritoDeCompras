package utils;
import java.sql.*;

public class Conexion {
    //Metodo para obtener la conexion con la base de datos
    public static Connection getConexion() {
        Connection cn = null;
        try {
            //Cargamos el driver y le decimos que vamos a usar
            //una conexion con mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexion
            cn = DriverManager.getConnection("jdbc:mysql://localhost/bdcarrito", "root", "");
            System.out.print("Correcto");
        } catch (Exception e) { System.out.print("Error"); }
        return cn;
    }
    public static void main(String[] args) {
              getConexion();  
    }
}
