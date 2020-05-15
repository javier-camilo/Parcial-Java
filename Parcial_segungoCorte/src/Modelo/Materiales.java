
package Modelo;

public class Materiales {
    private String titulo, codigo, autor;

    public Materiales(String titulo, String codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
        
    }

    public Materiales(){
    }

    
    public String getTitulo(){
        return titulo;
    }

  
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
