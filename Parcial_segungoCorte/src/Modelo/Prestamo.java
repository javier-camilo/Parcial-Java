
package Modelo;

import java.util.Calendar;


public class Prestamo {
    private String id_libro;
    private Calendar fecha_inicio, fin_prestamo;

    public Prestamo( String id_libro, Calendar fecha_inicio, Calendar fin_prestamo) {
        
       
        this.id_libro = id_libro;
        this.fecha_inicio = fecha_inicio;
        this.fin_prestamo = fin_prestamo;
       
    }

  
    public String getId_libro() {
        return id_libro;
    }

    
    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public Calendar getFecha_inicio() {
        return fecha_inicio;
    }

  
    public void setFecha_inicio(Calendar fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

 
    public Calendar getFin_prestamo() {
        return fin_prestamo;
    }

    
    public void setFin_prestamo(Calendar fin_prestamo) {
        this.fin_prestamo = fin_prestamo;
    }

    
}
