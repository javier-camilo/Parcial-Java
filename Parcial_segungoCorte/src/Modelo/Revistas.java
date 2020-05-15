
package Modelo;


public class Revistas extends Materiales {
    
    private String editoria;

    public Revistas() {
    }
    public Revistas(String titulo, String codigo) {
        super(titulo, codigo);
    }

    public Revistas(String editoria, String titulo, String codigo) {
        super(titulo, codigo);
        this.editoria = editoria;
    }
    
    
    public String getEditoria() {
        return editoria;
    }

    public void setEditoria(String editoria) {
        this.editoria = editoria;
    }
    
    
}
