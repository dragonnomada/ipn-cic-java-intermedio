package ipn.cic.s2_paqueteria;

public class PaqueteAlmacenado extends Paquete {
    
    private String almacen = "Almacén por Defecto";
    int numEstante = 1;
    int numRepisa = 1;
    int posicion = 1;
    int existencias = 0;
    
    public void saludar() {
        // this - Es la referencia al objeto desde adentro
        
        //this.id = 456; // ERROR: No hay acceso al `id` de padre porque es privado 
        
        this.firmarPaquete("SALUDO");
        this.densidadPaquete();
    }
    
}
