/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Filmografia;
import java.sql.Date;

/**
 *
 * @author rai
 */
public class DAOFilmografia {
    
    //ATRIBUTOS
    
    private Connection conexion;
    private static final String INSERT = "INSERT INTO filmografia "
            + "(titulo, fecha_estreno, sinopsis, pais_id, clasificacion_id) "
            + "VALUES (?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM filmografia WHERE id = ?";
    private static final String UPDATE = "UPDATE filmografia SET titulo = ?, "
            + "fecha_estreno = ?, sinpsis = ?, pais_id = ?, clasificacion_id = ?"
            + "WHERE id = ?";
    private static final String LISTALL = "SELECT * FROM filmografia";
    private static final String LISTONE = "SELECT * FROM filmografia WHERE id = ?";
    
    //CONSTRUCTOR
    
    public DAOFilmografia(Connection conexion){
        
        this.conexion = conexion;
    }
    
    //MÉTODOS
    
    public void Insert_Filmografia(String titulo, Date fecha_estreno,
            String sinopsis, int pais_id, int clasificacion_id){
    
        try{
            PreparedStatement stmt = this.conexion.prepareStatement(this.INSERT);
            stmt.setString(1, titulo);
            stmt.setDate(2,fecha_estreno);
            stmt.setString(3,sinopsis);
            stmt.setInt(4,pais_id);
            stmt.setInt(5,clasificacion_id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en INSERT filmo."+e.getMessage());
        }
    };
    public void Delete_Filmografia(int id){
    
        try{
            PreparedStatement stmt = this.conexion.prepareStatement(this.DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en DELETE filmo."+e.getMessage());
        }
    };
    public void Update_Filmografia(String titulo, Date fecha_estreno,
            String sinopsis, int pais_id, int clasificacion_id){
    
        try{
            PreparedStatement stmt = this.conexion.prepareStatement(this.UPDATE);
            stmt.setString(1, titulo);
            stmt.setDate(2,fecha_estreno);
            stmt.setString(3,sinopsis);
            stmt.setInt(4,pais_id);
            stmt.setInt(5,clasificacion_id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en list all filmo."+e.getMessage());
        }
    };
    public void Listall_Filmografia(){
        
        try{
            PreparedStatement stmt = this.conexion.prepareStatement(this.LISTALL);
            ResultSet rs = stmt.executeQuery();
            Filmografia filmo = new Filmografia();
            while(rs.next()){
                
                filmo.setId(rs.getInt("id"));
                filmo.setTitulo(rs.getString("titulo"));
                filmo.setFecha_estreno(rs.getDate("fecha_estreno"));
                filmo.setSinopsis(rs.getString("sinopsis"));
                filmo.setPais_id(rs.getInt("pais_id"));
                filmo.setClasificacion_id(rs.getInt("clasificacion_id"));
                System.out.println(filmo.toString());
            }
        } catch(SQLException e){
            
            System.out.println("Error en list all filmo."+e.getMessage());
        }
    };
    public void Listone_Filmografia(int id){
    
        try{
            PreparedStatement stmt = this.conexion.prepareStatement(this.LISTONE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Filmografia filmo = new Filmografia();
            rs.next();
            filmo.setId(rs.getInt("id"));
            filmo.setTitulo(rs.getString("titulo"));
            filmo.setFecha_estreno(rs.getDate("fecha_estreno"));
            filmo.setSinopsis(rs.getString("sinopsis"));
            filmo.setPais_id(rs.getInt("pais_id"));
            filmo.setClasificacion_id(rs.getInt("clasificacion_id"));
            System.out.println(filmo.toString());
            
        } catch(SQLException e){
            
            System.out.println("Error en list all filmo."+e.getMessage());
        }
    };
}
