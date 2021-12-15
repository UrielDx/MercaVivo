package ControlDeLaBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionConBaseDatos {
    
    /**
     * Generador de conexión a la BD
     */
    public static Connection conexion = null;
    /**
     * Este método realiza la conexión con la base de datos
     */
   
    public static Connection getConexion() {
        try {
           conexion = null;
           Class.forName("org.h2.Driver");
           conexion = DriverManager.getConnection("jdbc:h2:./BD/ventas","sa","");
           System.out.println("conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("error de conexion");
           JOptionPane.showMessageDialog(null, "error de conexion "+e);
       }
        return conexion;
    }
}