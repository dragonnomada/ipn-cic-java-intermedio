package ipn.cic.sistemainventarios.clasess;

public class Paquete {
    
    int id;
    String codigo;
    String guia;
    double ancho;
    double alto;
    double largo;
    double peso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void describir() {
        System.out.printf("[%d] %s %s %.2f x %.2f x %.2f / %.2f", 
                this.id, this.codigo, this.guia, this.ancho, this.alto, this.largo, this.peso);
    }
    
}
