package ControlDeLaBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Generador {
    
    /**
     * Método para definir la siguiente clave primaria a usar ya que algunas
     * de estas claves son auto incrementables
     */
    public int auto_increm(String sql){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionConBaseDatos db = new ConexionConBaseDatos();
        try{    
                ps = ConexionConBaseDatos.getConexion().prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    id = rs.getInt(1)+1;
                }
        }catch(Exception ex){
            System.out.println("idmaximo"+ex.getMessage());
            id = 1;
        }
        finally{
            try{
                ps.close();
                rs.close();
               
            }catch(Exception ex){}
        }
        return id;
    }
    
}
