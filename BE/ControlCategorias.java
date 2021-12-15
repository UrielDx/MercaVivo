package ControlDeLaBD;

import ControlCategorias.Consulta;
import MenuPrincipal.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlCategorias {
    
    DefaultTableModel modelo;
    String[] titulosColumnas = {"ID CATEGORÍAS", "NOMBRE"};
    String info[][] = {};
    
    /**
     * Metodo para listar (Mandar llamar) todos los registros de la tabla
     * de proveedores
     * @param No recibe parametros
     */
    public void listarTodosCategorias() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Consulta.jTableListarVendedor.setModel(modelo);
        
        ejecutarConsultaTodaTabla();
    }
    
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
     * Método para consultar todos los regsitros de la base de datos de la tabla categorías
     * y luego ser mostrarlas en una tabla.
     * @param No recibe parametros
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_categorias ORDER BY nombre ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                String id = resultado.getString("idCat");
                String nombre = resultado.getString("nombre");
                Object[] info = {id, nombre};
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
     * Método para actualizar un registro de la tabla de categorías.
     * @param Recibe un entero llamado id que es la clave primaria de la tabla categoría
     * @param Recibe una cadena llamado Nom que es el nombre de la categoría
     */
       public void ModificarCategoria(int id, String Nom) {
        try {
            Connection Conection = ConexionConBaseDatos.getConexion();
            Statement comando = Conection.createStatement();
            int cantidad = comando.executeUpdate("UPDATE table_categorias SET Nombre ='" + Nom +
                 "' WHERE idCat=" + id);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Categoría con ese id: "+ id);
            }
            Conection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }
       
    /**
     * Método para eliminar un regsitro de la tabla categorías
     * @param Recibe un entero llamado idC que permite identificar el registo a eliminar
     */
       
     public void EliminarCategoria(String idC){
        
        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_categorias where idCat=" + idC);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe el Proveedor con el id: "+idC);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }
    }
}
