
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {
    
    private Connection conexion;
    private String URL = "jdbc:mysql://localhost:3306/escuela?AutoReconnect=true&useSSL=false";
    private String usuario = "root";
    private String contraseña = "1010031429";
    
    public Connection getConexion(){
        Connection conexion=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL,usuario,contraseña);
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }
        
        return conexion;
    }
    
    
    
}
