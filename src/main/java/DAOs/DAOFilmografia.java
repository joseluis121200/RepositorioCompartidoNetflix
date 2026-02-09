/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import Models.Filmografia;

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
    
    private Filmografia crarFilmo(ResultSet rs) throws SQLException{
    
        try{
            Filmografia filmo = new Filmografia(rs.getInt("id"),rs.getString("titulo"),rs.getDate("fecha_estreno"),
                    rs.getString("sinopsis"),rs.getInt("pais_id"),rs.getInt("clasificacion_id"));
            return filmo;
        } catch(SQLException e){
            
            throw new SQLException("Error creando Filmo.",e);
        }
    }
    
    private void cerrarEstados(PreparedStatement stmt, ResultSet rs) throws SQLException{
        
        if (stmt != null){ try{
                
                stmt.close();
            } catch(SQLException e){
                throw new SQLException("Error cerrando statement.",e);
            }
        }
            
            if (rs != null){ try{
                
                rs.close();
            } catch(SQLException e){
                throw new SQLException("Error cerrando resulset.",e);
            }
        }
        
    }
    
    private void cerrarEstados(PreparedStatement stmt) throws SQLException{
        
        if (stmt != null){ try{
                
                stmt.close();
            } catch(SQLException e){
                throw new SQLException("Error cerrando statement.",e);
            }
        }
    }
    
    private void cerrarEstados(ResultSet rs) throws SQLException{
                    
            if (rs != null){ try{
                
                rs.close();
            } catch(SQLException e){
                throw new SQLException("Error cerrando resulset.",e);
            }
        }
        
    }
    
    public void Insert_Filmografia(String titulo, Date fecha_estreno,
            String sinopsis, int pais_id, int clasificacion_id) throws SQLException{
    
        PreparedStatement stmt = null;
        try{
            stmt = this.conexion.prepareStatement(this.INSERT);
            stmt.setString(1, titulo);
            stmt.setDate(2,fecha_estreno);
            stmt.setString(3,sinopsis);
            stmt.setInt(4,pais_id);
            stmt.setInt(5,clasificacion_id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en INSERT filmografia."+e.getMessage());
        } finally{
        
            cerrarEstados(stmt);
        }
    };
    public void Delete_Filmografia(int id) throws SQLException{
    
        PreparedStatement stmt = null;
        try{
            stmt = this.conexion.prepareStatement(this.DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en DELETE filmografia."+e.getMessage());
        } finally{
        
            cerrarEstados(stmt);
        }
    };
    public void Update_Filmografia(String titulo, Date fecha_estreno,
            String sinopsis, int pais_id, int clasificacion_id, int id) throws SQLException{
    
        PreparedStatement stmt = null;
        try{
            stmt = this.conexion.prepareStatement(this.UPDATE);
            stmt.setString(1, titulo);
            stmt.setDate(2,fecha_estreno);
            stmt.setString(3,sinopsis);
            stmt.setInt(4,pais_id);
            stmt.setInt(5,clasificacion_id);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        } catch(SQLException e){
            
            System.out.println("Error en UPDATE filmografia."+e.getMessage());
        } finally{
        
            cerrarEstados(stmt);
        }
    };
    public void Listall_Filmografia() throws SQLException{
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = this.conexion.prepareStatement(this.LISTALL);
            rs = stmt.executeQuery();
            while(rs.next()){
           
                System.out.println(crarFilmo(rs).toString());
            }
        } catch(SQLException e){
            
            System.out.println("Error en LIST ALL filmografia."+e.getMessage());
        } finally{
        
            cerrarEstados(stmt, rs);
        }
    };
    public void Listone_Filmografia(int id) throws SQLException{
    
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = this.conexion.prepareStatement(this.LISTONE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            System.out.println(crarFilmo(rs).toString());
            
        } catch(SQLException e){
            
            System.out.println("Error en LIST ONE filmo."+e.getMessage());
        } finally{
        
            cerrarEstados(stmt, rs);
        }
    };
}
