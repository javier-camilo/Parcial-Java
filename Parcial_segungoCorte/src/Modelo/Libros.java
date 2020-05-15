
package Modelo;


public class Libros extends Materiales{
    
    private String autor, año;

    public Libros(){}

    public Libros(String titulo, String codigo) {
        super(titulo, codigo);
    }
   
    public Libros(String autor, String año, String titulo, String codigo) {
        super(titulo, codigo);
        this.autor = autor;
        this.año = año;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    
}
