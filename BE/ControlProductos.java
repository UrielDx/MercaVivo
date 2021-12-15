package ControlDeLaBD;
import OperacionesProducto.ConsultarProductos;
import MenuPrincipal.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para el control de la tabla de productos
 */

public class ControlProductos {
    DefaultTableModel modelo;
    String[] titulosColumnas = {"CÓDIGO","MARCA","DESCRIPCIÓN","PRECIO","STOCK","ID PROVEEDOR","ID CATEGORÍA"};
    String info[][] = {};
    
/**
 * Clase para el control de la tabla de productos
 * Método que permite generar una tabla de productos existentes en la ventana
 */
   
     public void CargarProductos(){
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Ventas.SeleccionarProductos.setModel(modelo);
        ejecutarConsultaTodaTabla();
     }
    
    /**
     * Metodo para listar todos los registros de la tabla productos
     */
    public void listarTodosProductos() {
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ConsultarProductos.jTableListarCliente.setModel(modelo);
        ejecutarConsultaTodaTabla();
    }
    
     /**
     * Metodo que realiza la consulta SQL que permite obtener los datos de la tabla productos
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabla() {
        try {
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_producto ORDER BY marca ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String marca = resultado.getString("marca");
                String des = resultado.getString("descripcion");
                String pre = resultado.getString("precio");
                String stoc = resultado.getString("stock");
                String idPr = resultado.getString("idPro");
                String idCa = resultado.getString("idCat");
                Object[] info = {codigo, marca,des,pre,stoc,idPr,idCa};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
  
    /**
     * Metodo que realiza busquedas de productos determinados
     * @param Recibe el parametro llamado parametroBusqueda que se usara para validar la busqueda
     */
    
    public void buscarProductos(String parametroBusqueda) {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            ConsultarProductos.jTableListarCliente.setModel(modelo);
            buscarRegistroProductos(parametroBusqueda);
    }
    
    /**
     * Metodo que realiza la sentencia SQL para buscar un producto determinado
     * @param Recibe el parametro llamado parametroBusqueda que se usara para validar la busqueda
     */
    
    public void buscarRegistroProductos(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                            
                selectSQL = "SELECT * FROM table_producto WHERE codigo LIKE ? ORDER BY codigo ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
    
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String marca = resultado.getString("marca");
                String des = resultado.getString("descripcion");
                String pre = resultado.getString("precio");
                String stoc = resultado.getString("stock");
                String idPr = resultado.getString("idPro");
                String idCa = resultado.getString("idCat");
                Object[] info = {codigo,marca,des,pre,stoc,idPr,idCa};
                modelo.addRow(info);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
    /**
     * Método que permite eliminar productos determinados
     * @param Recibe el parametro llamado code para validar la sentencia SQL y verificar el producto a eliminar
     */
    public void EliminarProductos(String code) {

        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_producto where codigo=" + code);
            if (cantidad == 1) {
   
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Producto de Codigo: "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }
    }

    
    /**
     * Método modificar la información de los registros de productos
     * @param Recibe codigo para validar la actualización
     * @param Recibe marca de tipo cadena
     * @param Recibe descripcion de tipo cadena
     * @param Recibe precio de tipo flotante
     * @param Recibe stock de tipo entero
     * @param Recibe idPro de tipo cadena que son claves foraneas
     * @param Recibe idCat de tipo entero que son claves foraneas
     */
    
    public void ModificarProductos(String codigo,  String marca, String descripcion, float precio, int stock, String idPro, int idCat) {    
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("update table_producto set marca ='" + marca +
                "', descripcion ='" + descripcion + "', precio ='" + precio
                + "', stock ='" + stock + "', idPro='"+ idPro+"', idCat='"+idCat+"'"
                 + "where codigo="+ codigo);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de un codigo "+codigo);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }
    
    /**
     * Método buscar la información de un producto determinado
     * @param Recibe el parametro llamado parametroBusqueda para validar la busqueda
     */
    public void buscarProductosparaVentas(String parametroBusqueda) {
            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            Ventas.SeleccionarProductos.setModel(modelo);
            buscarRegistroProductoss(parametroBusqueda);
    }
    
    /**
     * Método que realiza la consulta SQL para la busqueda de productos
     * @param Recibe el parametro llamado parametroBusqueda para validar la busqueda
     */
    
    public void buscarRegistroProductoss(String parametroBusqueda) {
        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                selectSQL = "SELECT * FROM table_producto where codigo=";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String marca = resultado.getString("marca");
                String des = resultado.getString("descripcion");
                String pre = resultado.getString("precio");
                String stoc = resultado.getString("stock");
                String idPr = resultado.getString("idPro");
                String idCa = resultado.getString("idCat");
                Object[] info = {codigo, marca,des,pre,stoc,idPr,idCa};
                modelo.addRow(info);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
}
