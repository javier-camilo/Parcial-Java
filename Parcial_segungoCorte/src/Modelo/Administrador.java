
package Modelo;

import Datos.IArchivo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Administrador implements Comparable<IArchivo>{
    
   private  Scanner a = new Scanner(System.in);
   private ArrayList<Materiales> ListaMateriales = new ArrayList<>();
   private ArrayList<Cliente> ListaCliente = new ArrayList<>();
   private ArrayList<Prestamo> ListaPrestamo = new ArrayList<>();
 
    private Cliente cliente;
    private Materiales materiales;
    private Prestamo prestamo;

    public Administrador(Cliente cliente, Materiales materiales) {
        this.cliente = cliente;
        this.materiales = materiales;
    }
    public Administrador() {
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  
    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }
    
    public void GestionDeMaterial(){
        int escribir = 0;
        do{
            a.nextLine();
            String titulo, codigo, autor, año,  editoria;
            boolean Encontro;
            System.out.print("REGISTRE CODIGO: ");
            codigo = a.nextLine();
            Encontro = BuscarMaterialRepetido(codigo);//retorna un boleano
            
            if(Encontro==true){
                System.out.println("YA EXISTE");
            }else{
                System.out.print("REGISTRE TITULO: ");
                titulo = a.nextLine();
                System.out.println("ELIJA UNA OPCION: ");
                System.out.println("1. LIBROS");
                System.out.println("2. EDITORIA");
                System.out.print("ELIJA UNA OPCION: [");
                escribir = a.nextInt(); System.out.println("]");
                a.nextLine();
                if(escribir == 1 ){
                    System.out.print("REGISTRE AUTOR: ");
                    autor = a.nextLine();
                    System.out.print("REGISTRE AÑO DEL LIBRO: ");
                    año = a.nextLine();
                    materiales = new Libros(autor, año, titulo, codigo);
                }else{
                    System.out.print("REGISTRAR EDITORIA: ");
                    editoria = a.nextLine();
                    materiales = new Revistas(editoria, titulo, codigo);
                }
                ListaMateriales.add(materiales);
                System.out.println("DESEAS CONTINUAR: [1->SI] :: [2. NO]: ");
                escribir = a.nextInt();
            }
           
        }while(escribir != 2);
        ListaMateriales();//llamas a la lista despues de terminar de registrar
    }
    
    public boolean BuscarMaterialRepetido(String codigo){
        for(Materiales ms: ListaMateriales){//este pequeño codigo te busca si exte el codigo
            if(ms.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    public void ListaMateriales(){
        for(Materiales ms: ListaMateriales){
            System.out.println("::::MATERIALES::::");
            System.out.print("\nTITULO: "+ ms.getTitulo()+ "\tCODIGO: " + ms.getCodigo());
           if(ms instanceof Libros){
                Libros l = (Libros) ms;
                System.out.print("\tAUTOR: " +l.getAutor() + "\tAÑOS: " + l.getAño());
            }else{
                Revistas r = (Revistas) ms;
                System.out.print("\tEDITORIA: " + r.getEditoria());
            }
        }
        
    }
        
    public boolean EncontrarCliente(String cedula){
        
        for(Cliente c: ListaCliente ){
            if(c.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public void GestionDeCliente(){
        
       
        boolean encontro;
        int opcion;
        do{
        String nombre, apellido,  cedula;
        int cantidad=0;    
        
        System.out.println(":::::::REGISTRAR CLIENTE:::::::");
        System.out.println("PRESIONE ENTENTER PARA CONTINUAR...");
        a.nextLine();
        
        System.out.println("REGISTRAR CEDULA: ");
        cedula = a.nextLine();
        encontro = EncontrarCliente(cedula);
        
        if(encontro == true){
            System.out.println("EL CLIENTE YA EXISTE");
            
        }else{
            
            System.out.println("REGISTRE NOMBRE: ");
            nombre = a.nextLine();
            System.out.println("REGISTRE APELLIDO: ");
            apellido = a.nextLine();
            
            cliente = new Cliente(cedula,nombre,apellido,5);
            ListaCliente.add(cliente);
            
        }
          System.out.println("REGISTRO EXISTOSO");
          System.out.println("DESEA SEGUIR REGISTRANDO CLIENTES  [1->SI] :: [2->NO]");
          opcion = a.nextInt();
        }while(opcion != 2);
        
        ListaCliente();
        
    }

    public void ListaCliente(){
        for(Cliente c: ListaCliente){
            System.out.println("[CEDULA: " + c.getCedula() + "]" + " [NOMBRE: " + c.getNombre() + "]" + " [APELLIDO: " + "]" +c.getApellido() + " [CUPO: " + c.getCantidad() + "]");
        }
    }
    
    public void GestionDePrestamo(){
        String  cedula, id_libro;
        Calendar fecha_inicio, fin_prestamo;
        int opcion, contador = 0, finFecha, cupoDisponible;
        boolean comprobar;
        
        do{
            a.nextLine();
            System.out.println("::::REGISTRAR PRESTAMO::::");
            
            System.out.println("CEDULA: ");
            cedula = a.nextLine();
            
            comprobar = EncontrarCliente(cedula);
            
            if(comprobar == true){
                
            do{
               a.nextLine();
               System.out.println("ID_LIBRO: ");
               id_libro = a.nextLine();
               comprobar = BuscarMaterialRepetido(id_libro);
                
               if(comprobar==true){
               fecha_inicio = Calendar.getInstance();
               System.out.println("FECHA INICIO: " + fecha_inicio);
               System.out.println("FIN DE PRESTAMO: ");
               finFecha = a.nextInt();
               fin_prestamo = fecha_inicio;
               fin_prestamo.add(Calendar.DAY_OF_MONTH, finFecha);
               prestamo = new Prestamo(id_libro, fecha_inicio, fin_prestamo);
               ListaPrestamo.add(prestamo);
               
               contador++;
               cupoDisponible = contador - 5; 
            
                System.out.println("CUPO DISPONIBLE: " + cupoDisponible);
                }else{
                    System.out.println("EL LIBRO NO EXISTE");
                }
                
              System.out.println("DESEA CONTINUAR CON EL PRESTAMO [1->SI] :: [2->NO]: ");
               opcion = a.nextInt();
               
            }while(opcion != 2 && contador != 5); 
            
            }else{
                System.out.println("EL CLIENTE NO EXISTE");
            }
          
            System.out.println("DESEA CONTINUAR REGISTRANDO PRESTAMO 1->SI :: 2->NO");
            opcion = a.nextInt();
             
          }while(opcion!=2);
            ListaPrestamo();
    }
 
    private void ListaPrestamo(){
        
        for(Prestamo pe : ListaPrestamo){
            System.out.println("[CEDULA: " + cliente.getCedula()+ "]" + " [FECHA DE INICIO: " + pe.getFecha_inicio()+"]" + " [FECHA DE ENTREGA: " + pe.getFin_prestamo()+"]") ;
        }
        
    }

    @Override
    public int compareTo(IArchivo t) {
       return 0;
    }
    
    public Cliente buscarCLiente(String cedula) throws Exception {
        for(Cliente ab: this.ListaCliente){
             if(ab.getCedula().equals(cedula)){
               System.out.println("Cedula: "+ ab.getCedula() + "Nombre: " + ab.getNombre() + " Apellido: " + ab.getApellido() + "Cantidad: " + ab.getCantidad());
              
             }else{
                 System.out.println("EL CLIENTE NO EXISTE");
             }
        }
       return null;
    }

  
}
