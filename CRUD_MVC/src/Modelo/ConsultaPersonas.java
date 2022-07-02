
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaPersonas extends ConexionBD{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public boolean insertarPersonas(Persona persona){
        Connection conexion = getConexion();
        
        try {
            ps = conexion.prepareStatement("insert into persona (clave,nombre,domicilio,"
                    + "celular,correo_electronico,fecha_nacimiento,genero) values (?,?,?,?,?,?,?)");
            
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreoElectronico());
            ps.setDate(6, persona.getFechaNacimiento());
            ps.setString(7, persona.getGenero());
            
            int resultado = ps.executeUpdate();
            
            if(resultado >0){
                return true;
            }else{
                return false;
            }
             
        } catch (Exception e) {
            System.err.println("Error:"+e);
            return false;
        } finally{
            try {
                conexion.close();
            } catch (Exception e) {
                 System.err.println("Error:"+e);
            }
        }
    }
      
    
    public boolean buscarPersona(Persona persona){
        Connection conexion=null;
        
        try {
            conexion = getConexion();
            ps = conexion.prepareStatement("select * from persona where clave =?");
            ps.setString(1, persona.getClave());
            rs  =ps.executeQuery();
            
            if(rs.next()){
               persona.setIdPersona(rs.getInt("idPersona"));
               persona.setClave(rs.getString("clave"));
               persona.setNombre(rs.getString("nombre"));
               persona.setDomicilio(rs.getString("domicilio"));
               persona.setCelular(rs.getString("celular"));
               persona.setCorreoElectronico(rs.getString("correo_electronico"));
               persona.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
               persona.setGenero(rs.getString("genero"));
               return true;
            }else{
                return false;
            }
            
            
        } catch (Exception e) {
            return false;
        }
        
        
    }
    
    public boolean modificarPersona(Persona persona){
        Connection conexion= null;
        
        try {
            conexion =getConexion();
            ps =conexion.prepareStatement("update persona set clave=?,nombre=?,domicilio=?,"
                    + "celular=?,correo_electronico=?,fecha_nacimiento=?,genero=? where idPersona = ?");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreoElectronico());
            ps.setDate(6, persona.getFechaNacimiento());
            ps.setString(7, persona.getGenero());
            ps.setInt(8, persona.getIdPersona());
            
            int resultado = ps.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
            
            
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean eliminarPersona(Persona persona){
        Connection conexion = null;
        
        try {
            conexion =getConexion();
            ps = conexion.prepareStatement("delete from persona where idPersona = ?");
            ps.setInt(1, persona.getIdPersona());
            
            int resultado = ps.executeUpdate();
            if(resultado>0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
}
