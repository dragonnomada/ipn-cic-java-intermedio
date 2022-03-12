package ipn.cic.s2_pruebas;

import ipn.cic.s2_paqueteria.Paquete;
import ipn.cic.s2_paqueteria.PaqueteAlmacenado;

public class Prueba1 {
    
    public static void main(String[] args) {
        
        // Objeto paquete1 de la clase Paquete
        Paquete paquete1 = new Paquete();
        
        // A nivel objeto, sólo podemos acceder a los miembros públicos
        paquete1.densidadPaquete();
        
        // paquete1.ancho = 2; // ERROR: No hay acceso a estos atributos
        
        PaqueteAlmacenado paqueteAlmacenado1 = new PaqueteAlmacenado();
        
        // A nivel objeto, sólo podemos acceder a los miembros públicos
        paqueteAlmacenado1.densidadPaquete();
        
        paqueteAlmacenado1.saludar();
        
    }
    
}
