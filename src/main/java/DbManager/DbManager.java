/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DbManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author rai
 */
public class DbManager {
    
    // ATRIBUTOS
    
    private static final Dotenv dotenv = Dotenv.load();
    private static final String USER = dotenv.get("DB_USER");
    private static final String PSS = dotenv.get("DB_PSS");
    private static final String URL = dotenv.get("DB_URL");
    private Connection conexion = null;
    
    //GET
    
    public Connection getConexion(){
        
        return this.conexion;
    }
    
    // MÉTODOS
    
   public void conectar(){
        
        try{
            this.conexion = DriverManager.getConnection(this.URL,this.USER,this.PSS);
            System.out.println("Conexión exitosa.");
        }catch(SQLException e){
                System.out.println(e.getMessage()+" EROR AL CONECTAR ");
        }
    }
   
   public void desconectar(){
       
       try{
            if (this.conexion != null && !this.conexion.isClosed()) {
                this.conexion.close();
                System.out.println("Desconexión exitosa.");
            }
        }catch(SQLException e){
                System.out.println(e.getMessage()+" EROR AL DESCONECTAR ");
        }
   }
    
    
}
