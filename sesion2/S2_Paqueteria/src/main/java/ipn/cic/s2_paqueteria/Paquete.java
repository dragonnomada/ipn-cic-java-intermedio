package ipn.cic.s2_paqueteria;

public class Paquete {
    
    private int id;
    private int ancho;
    private int alto;
    private int largo;
    private double peso;
    
    private void abrirPaquete() {
        System.out.printf("El paque %d ha sido abierto\n", this.id);
    }
    
    protected boolean firmarPaquete(String firma) {
        System.out.printf("El paque %d ha sido firmado con la firma %s\n", this.id, firma);
        return true;
    }
    
    public double densidadPaquete() {
        double densidad = (this.ancho * this.alto * this.largo) / this.peso;
        System.out.printf("El paque %d tiene una densidad de %.2f\n", this.id, densidad);
        return densidad;
    }
    
}
