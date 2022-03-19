public class ReporteCalificaciones {

    private int total;
    private double minimo;
    private double maximo;
    private double suma;
    private double promedio;

    public ReporteCalificaciones(int total, double minimo, double maximo, double suma) {
        this.total = total;
        this.minimo = minimo;
        this.maximo = maximo;
        this.suma = suma;
        this.promedio = this.suma / this.total;
    }

    public int getTotal() {
        return total;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getSuma() {
        return suma;
    }

    public double getPromedio() {
        return promedio;
    }
}
