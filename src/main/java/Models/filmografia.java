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
public class filmografia {
    private int id;
    private String titulo;
    private Date fecha_estreno;
    private String sinopsis;
    private int pais_id;
    private int clasificacion_id;

    public filmografia(int id, String titulo, Date fecha_estreno, String sinopsis, int pais_id, int clasificacion_id) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_estreno = fecha_estreno;
        this.sinopsis = sinopsis;
        this.pais_id = pais_id;
        this.clasificacion_id = clasificacion_id;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getPais_id() {
        return pais_id;
    }

    public int getClasificacion_id() {
        return clasificacion_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public void setClasificacion_id(int clasificacion_id) {
        this.clasificacion_id = clasificacion_id;
    }

    @Override
    public String toString() {
        return "filmografia{" + "id=" + id + ", titulo=" + titulo + ", fecha_estreno=" + fecha_estreno + ", sinopsis=" + sinopsis + ", pais_id=" + pais_id + ", clasificacion_id=" + clasificacion_id + '}';
    }
    
    
}
