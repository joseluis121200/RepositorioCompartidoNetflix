/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.Date;
/**
 *
 * @author josel
 */
public class acceso {
    
    private int id_acceso;
    private int id_filmografia;
    private int id_cuenta;
    private  Date fecha_acceso;

    public acceso(int id_acceso, int id_filmografia, int id_cuenta, Date fecha_acceso) {
        this.id_acceso = id_acceso;
        this.id_filmografia = id_filmografia;
        this.id_cuenta = id_cuenta;
        this.fecha_acceso = fecha_acceso;
    }

    public int getId_acceso() {
        return id_acceso;
    }

    public int getId_filmografia() {
        return id_filmografia;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public Date getFecha_acceso() {
        return fecha_acceso;
    }

    public void setId_acceso(int id_acceso) {
        this.id_acceso = id_acceso;
    }

    public void setId_filmografia(int id_filmografia) {
        this.id_filmografia = id_filmografia;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setFecha_acceso(Date fecha_acceso) {
        this.fecha_acceso = fecha_acceso;
    }

    @Override
    public String toString() {
        return "acceso{" + "id_acceso=" + id_acceso + ", id_filmografia=" + id_filmografia + ", id_cuenta=" + id_cuenta + ", fecha_acceso=" + fecha_acceso + '}';
    }
    
    
    
    
    
    
}
