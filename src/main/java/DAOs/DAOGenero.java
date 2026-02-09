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
    
    public void Insert_Genero(String nombre){};
    public void Delete_Genero(int id){};
    public void Update_Genero(int id){};
    public void Listall_Genero(){};
    public void Listone_Genero(int id){};
    
}
