
package Datos;

import Modelo.Cliente;


public interface IArchivo {
    
     Cliente buscarAlumno(String cedula) throws Exception;
}
