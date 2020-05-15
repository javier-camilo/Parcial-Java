
package Modelo;

public class Cliente {
    
    private String nombre, apellido, cedula;
    private int cantidad;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido, int cantidad) {
      
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantidad = cantidad;
        
    }

  
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

  
    public int getCantidad() {
        return cantidad;
    }

 
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
