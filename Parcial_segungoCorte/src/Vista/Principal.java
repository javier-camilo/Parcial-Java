/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.*;
import java.util.Scanner;
/**
 *
 * @author zarel
 */
public class Principal {

 
           
    public static void main(String[] args) throws Exception {
        Scanner a = new  Scanner(System.in);
        Administrador administrador = new Administrador();
        String cedula;
        
        int opcion, elegir;
        do{  
            System.out.println("[::::::MENU::::::]");
            System.out.println("1. GESTIONAR MATERIAL");
            System.out.println("2. GESTIONAR CLIENTE");
            System.out.println("3. GESTION DE PRESTAMO");
            System.out.println("4. BUSCAR CLIENTE");
            System.out.println("5. SALIR");
            System.out.println("REGISTRAR UNA OPCION: ");
            opcion = a.nextInt();
          
         
            switch(opcion){
                case 1: administrador.GestionDeMaterial(); break;
                case 2: administrador.GestionDeCliente(); break;
                case 3: administrador.GestionDePrestamo(); break;
                case 4: 
                    a.nextLine();
                    System.out.println("REGISTRE CLIENTE A BUSCAR: ");
                    cedula = a.nextLine();
                    administrador.buscarCLiente(cedula); break;
                case 5: System.out.println("GRACIAS, VUELVA PRONTO"); break;
                default: System.out.println("NUMERO INCORRECTO, POR FAVOR INTENTE DE NUEVO"); break;
            }
            
            System.out.println("\nDESEA CONTNUA EN EL MENU [1->SI]::[2->NO1]: ");
            elegir = a.nextInt();
            
        }while(elegir != 2);
        
        
    }
    
}
