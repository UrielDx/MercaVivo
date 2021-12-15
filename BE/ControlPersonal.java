package ControlDeLaBD;

import OperacionesPersonal.ListarPersonal;
import OperacionesPersonal.newPersonal;
import MenuPrincipal.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Métodos para el control de la tabla personal
 *
 */

public class ControlPersonal {
    DefaultTableModel modelo;
    String[] titulosColumnas = {"ID", "NOMBRE", "EDAD", "SEXO","TELEFONO","DIRECCIÓN","CORREO","TIPO","USUARIO","CONTRASEÑA"};
    String info[][] = {};
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
 /**
 * Métodos para agregar un nuevo registro a la tabla personal
 * @param recibe un dato id de tipo entero para la clave primaria
 * @param recibe nombre de tipo cadera para el nombre del personal
 * @param recibe eda de tipo entero para la edad
 * @param recibe sex de tipo cadena para el sexo del personal
 * @param recibe tele de tipo entero para alamacenar el telefono
 * @param recibe dire de tipo cadena para la dirección
 * @param recibe corr de tipo cadena para el correo
 * @param recibe tipo de tipo cadena para el tipo de usuario
 * @param recibe usu de tipo cadena que regitra el usuario
 * @param recibe con de tipo cadena para la contraseña
 * 
 */

     public void agregarPersonal(int id, String nombre, int eda, String sex, int tele, String direc, String corr, String tip,String usu, String con) {
         Connection reg = ConexionConBaseDatos.getConexion();
         String sql = "INSERT INTO table_personal (idPer, Nombre, Edad, Sexo, Telefono, Direccion, Correo, Tipo, Usuario,Contrasena)VALUES (?,?,?,?,?,?,?,?,?,?)";
            try {
            PreparedStatement pst= reg.prepareStatement(sql);
            pst.setInt(1,id);
            pst.setString(2,nombre);
            pst.setInt(3,eda);
            pst.setString(4,sex);
            pst.setInt(5,tele);
            pst.setString(6,direc);
            pst.setString(7,corr);
            pst.setString(8,tip);
            pst.setString(9,usu);
            pst.setString(10,con);
            int n = pst.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null,"Regristado Exitosamente de Cliente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error - "+ex);
            Logger.getLogger(newPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    /**
     * Metodo para listar todos los registros de la tabla de personal
     * @param No recibe parametros
     */
    public void listarTodosClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ListarPersonal.jTableListarCliente.setModel(modelo);
        ejecutarConsultaTodaTabla();
    }
    
    /**
     * Metodo para cargar los datos del personal a una nueva tabla que se mostrara en pantalla
     * @param No recibe parametros
     */
        public void CargarClientes() {
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Ventas.SeleccionarCliente.setModel(modelo);
        ejecutarConsultaTodaTabla();
        }

     /**
     * Metodo para ejecutar la consulta SQL que obtendra los datos de la tabla personal
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
            String consultaSQL = "SELECT * FROM table_personal ORDER BY Nombre ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                int id = resultado.getInt("idPer");
                String nombre = resultado.getString("Nombre");
                int eda = resultado.getInt("Edad");
                String sex = resultado.getString("Sexo");
                int tele = resultado.getInt("Telefono");
                String direc = resultado.getString("Direccion");
                String corr = resultado.getString("Correo");
                String tip = resultado.getString("Tipo");
                String usu = resultado.getString("Usuario");
                String con = resultado.getString("Contrasena");
                Object[] info = {id, nombre, eda, sex, tele,direc,corr,tip,usu,con};
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
     * Metodo para buscar el personal de una manera determinada por el usuario
     * @param Recibe parametroBusqueda
     * @param Recibe buscarPorCedula
     * @param Recibe buscarPorNombre
     * @param Recibe buscarPorApellido
     * Definiran el tipo de consulta que se va a realizar
     */
        
  
    public void buscarPersonal(String parametroBusqueda, boolean buscarPorCedula, boolean buscarPorNombre, boolean buscarPorApellido) {
            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            ListarPersonal.jTableListarCliente.setModel(modelo);
            buscarRegistroCedulaONombreOapellido(parametroBusqueda, buscarPorCedula, buscarPorNombre, buscarPorApellido);
    }
    
    /**
     * Método para realizar las consulas SQL dependiendo la elección del usuario
     * @param Recibe el parametro llamado parametroBusqueda
     * @param Recibe el parametro llamado buscarPorId
     * @param Recibe el parametro llamado buscarPorNombre
     * @param Recibe el parametro llamado buscarPorUsuario
     */
    public void buscarRegistroCedulaONombreOapellido(String parametroBusqueda, boolean buscarPorId, boolean buscarPorNombre, boolean buscarPorUsuario) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
            if (buscarPorId == true) {               
                selectSQL = "SELECT * FROM table_Personal WHERE idPer LIKE ? ORDER BY idPer ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            } 
            else if(buscarPorNombre== true){
                selectSQL = "SELECT * FROM table_Personal WHERE Nombre LIKE ? ORDER BY idPer ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorUsuario== true){

                selectSQL = "SELECT * FROM table_personal WHERE Usuario LIKE ? ORDER BY idPer ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("idPer");
                String nombre = resultado.getString("Nombre");
                int eda = resultado.getInt("Edad");
                String sex = resultado.getString("Sexo");
                int tele = resultado.getInt("Telefono");
                String direc = resultado.getString("Direccion");
                String corr = resultado.getString("Correo");
                String tip = resultado.getString("Tipo");
                String usu = resultado.getString("Usuario");
                String con = resultado.getString("Contrasena");
                Object[] info = {id, nombre, eda, sex, tele, direc,corr,tip,usu,con};
                modelo.addRow(info);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
    /**
     * Método para eliminar el personal validando su id de personal
     * @param Recibe como parametro idP para validar el id
     */
    public void EliminarPersonal(int idP) {

        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_personal where idPer=" + idP);
            if (cantidad == 1) {
   
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe el Personal de Codigo "+idP);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }
    }

    /**
     * Método para modificar el personal validando su id de personal
     * @param recibe un dato id de tipo entero para la clave primaria
     * @param recibe nombre de tipo cadera para el nombre del personal
     * @param recibe eda de tipo entero para la edad
     * @param recibe sex de tipo cadena para el sexo del personal
     * @param recibe tele de tipo entero para el telefono
     * @param recibe dire de tipo cadena para la dirección
     * @param recibe corr de tipo cadena para el correo
     * @param recibe tipo de tipo cadena para el tipo de usuario
     * @param recibe usu de tipo cadena para el usuario
     * @param recibe con de tipo cadena para la contraseña
     */
    
    public void ModificarPer(int id, String Nom, int Eda, String Sex, int Tele, String Dire, String Co, String Tip,String Usu, String Con) {
        try {
            Connection Conection = ConexionConBaseDatos.getConexion();
            Statement comando = Conection.createStatement();
            int cantidad = comando.executeUpdate("UPDATE table_personal SET Nombre ='" + Nom 
                + "', Edad ='" + Eda + "', Sexo ='" + Sex + "', Telefono ='" + Tele +
                 "', Direccion ='" + Dire + "', Correo ='" + Co+ "', Tipo ='" + Tip +
                 "', Usuario ='" + Usu + "', Contrasena ='" + Con +
                 "' WHERE idPer=" + id);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de un codigo "+ id);
            }
            Conection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }
}
