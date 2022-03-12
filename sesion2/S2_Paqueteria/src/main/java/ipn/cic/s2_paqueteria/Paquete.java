package ipn.cic.s2_paqueteria;

public class Paquete {
    
    private int id = 123;
    private int ancho = 1;
    private int alto = 1;
    private int largo = 1;
    private double peso = 1;
    
    private void abrirPaquete() {
        System.out.printf("El paque %d ha sido abierto\n", this.id);
    }
    
    protected boolean firmarPaquete(String firma) {
        System.out.printf("El paque %d ha sido firmado con la firma %s\n", this.id, firma);
        return true;
    }
    
    public double densidadPaquete() {
        double densidad = this.peso / (this.ancho * this.alto * this.largo);
        System.out.printf("El paque %d tiene una densidad de %.2f\n", this.id, densidad);
        return densidad;
    }
    
}
