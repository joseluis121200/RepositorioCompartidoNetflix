/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.Utiles;

/**
 *
 * @author rai
 */
public class DAOGenero {
    
    //ATRIBUTOS
    
    private Connection conexion;
    private static final String INSERT = "INSERT INTO genero "
            + "(nombre) "
            + "VALUES (?)";
    private static final String DELETE = "DELETE FROM genero WHERE id = ?";
    private static final String UPDATE = "UPDATE genero SET nombre = ? "
            + "WHERE id = ?";
    private static final String LISTALL = "SELECT * FROM genero";
    private static final String LISTONE = "SELECT * FROM genero WHERE id = ?";
    
    //CONSTRUCTOR
    
    public DAOGenero(Connection conexion){
        
        this.conexion = conexion;
    }
    
    //MÉTODOS (AUN POR HACER)
    
    public void Insert_Genero(String nombre) throws SQLException{
    
        PreparedStatement stmt = null;
        try{
            stmt = this.conexion.prepareStatement(this.INSERT);
            stmt.setString(1, nombre);
            stmt.executeQuery();
        } catch(SQLException e){
            
            System.out.println("Error en INSERT genero."+e.getMessage());
        } finally{
        
            Utiles.cerrarEstados(stmt);
        }
    };
    public void Delete_Genero(int id) throws SQLException{
    
        PreparedStatement stmt = null;
        try{
            stmt = this.conexion.prepareStatement(this.DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en DELETE genero."+e.getMessage());
        } finally{
        
            Utiles.cerrarEstados(stmt);
        }
    };
    public void Update_Genero(int id, String nombre) throws SQLException{
    
        PreparedStatement stmt = null;
        try{
            stmt = this.conexion.prepareStatement(this.UPDATE);
            stmt.setString(1, nombre);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en UPDATE genero."+e.getMessage());
        } finally{
        
            Utiles.cerrarEstados(stmt);
        }
    };
    public void Listall_Genero() throws SQLException{
    
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = this.conexion.prepareStatement(this.LISTALL);
            rs = stmt.executeQuery();
            while(rs.next()){
               
                System.out.println(Utiles.crarGen(rs).toString());
            }
        } catch(SQLException e){
            
            System.out.println("Error en LIST ALL genero."+e.getMessage());
        } finally{
        
            Utiles.cerrarEstados(stmt, rs);
        }
    };
    public void Listone_Genero(int id) throws SQLException{
    
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = this.conexion.prepareStatement(this.LISTONE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            System.out.println(Utiles.crarGen(rs).toString());
            
        } catch(SQLException e){
            
            System.out.println("Error en LIST ONE genero."+e.getMessage());
        } finally{
        
            Utiles.cerrarEstados(stmt, rs);
        }
    };
    
}
