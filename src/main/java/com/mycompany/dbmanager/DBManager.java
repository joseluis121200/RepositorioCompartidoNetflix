package com.mycompany.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DBManager {

    // 1. ATRIBUTOS (Credenciales de acceso)
    // Cambia "root" y "tu_contraseña" por tus datos reales de MySQL
    private static final Dotenv dotenv = Dotenv.load();
    private static final String USUARIO = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASS");
    
    // Cambia "Netflix" por el nombre de la base de datos que creaste en Workbench
    private static final String URL = dotenv.get("DB_URL");
    
    private Connection conexion;

    // 2. MÉTODO PARA CONECTAR
    public void conectar() {
        try {
            // Cargamos el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentamos establecer la conexión
            this.conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            
            if (this.conexion != null) {
                System.out.println("✅ ¡Éxito! Conectado a la base de datos MySQL.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ ERROR: No se encontró el Driver de MySQL. Revisa tu pom.xml.");
        } catch (SQLException e) {
            System.out.println("❌ ERROR DE SQL: " + e.getMessage());
            e.printStackTrace(); // Esto te dirá la causa exacta si falla
        }
    }

    // 3. MÉTODO PARA DESCONECTAR
    public void desconectar() {
        try {
            if (this.conexion != null && !this.conexion.isClosed()) {
                this.conexion.close();
                System.out.println("🔌 Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // 4. MÉTODO MAIN (El punto de entrada que Maven necesita)
    public static void main(String[] args) {
        // Creamos el objeto manager
        DBManager miManager = new DBManager();
        
        // Ejecutamos la conexión
        miManager.conectar();
        
        // Aquí podrías hacer tus consultas en el futuro
        
        // Finalmente cerramos
        miManager.desconectar();
    }
}