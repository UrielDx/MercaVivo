package ControlDeLaBD;
import OperacionesProveedor.ConsultarProveedor;
import MenuPrincipal.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlProveedor {
    
    DefaultTableModel modelo;
    String[] titulosColumnas = {"ID PROVEEDOR", "NOMBRE", "TELEFONO", "DIRECCION", "CORREO"};
    String info[][] = {};
    
    /**
     * Metodo para generar una tabla que muestre la información de los proveedores
     */
    public void listarTodosProveedores() {
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ConsultarProveedor.jTableListarVendedor.setModel(modelo);
        ejecutarConsultaTodaTabla();
    }
    
    /**
     * Metodo para cargar una tabla
     */
        public void CargarProveedor() {
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Ventas.SeleccionarVendedor.setModel(modelo);
        ejecutarConsultaTodaTabla();
        }
        
    /**
     * Metodo para realizar la consulta SQL a la tabla de proveedores
     */
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
    
    /**
     * Metodo para ejecutar la consulta SQL que mostrara los datos de la tabla
     */
    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_proveedor ORDER BY nombre ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                String id = resultado.getString("idPro");
                String nombre = resultado.getString("nombre");
                int tele = resultado.getInt("telefono");
                String direc = resultado.getString("direccion");
                String corre = resultado.getString("correo");
                Object[] info = {id, nombre, tele, direc, corre};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:\n" + e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
    /**
     * Metodo para elminar un proveedores
     * @param Recibe como parametro id para determinar el proveedor que el usuario desea eliminar
     */
    
    public void EliminarProveedor(String id){
        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_proveedor where idPro=" + id);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe el Proveedor con el id: "+id);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }
    }
    
    /**
     * Metodo para modificar un proveedores determinado por el usuario
     * @param Recibe idPro de tipo cadena para validar el usuario
     * @param Recibe nombre de tipo cadena
     * @param Recibe telefono de tipo entero
     * @param Recibe direccion de tipo cadena
     * @param Recibe correo de tipo cadena
     */
    public void ModificarProveedor (String idPro, String nombre, int telefono, String direccion,String correo)
    {
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("update table_proveedor set nombre ='" + nombre + "', "
                + "telefono = '" + telefono +"', direccion = '"+ direccion + "', correo = '"+
                correo+"' "+"where idPro= '" + idPro+"'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Proveedor con el id: "+idPro);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }
}

