import java.util.List;

public class ProcesarCalificaciones {

    private List<Double> calificaciones;
    private ReporteCalificaciones reporte;

    // Require: calificaciones
    public void setCalificaciones(List<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

    // Ofrece: reporteCalificaciones
    public ReporteCalificaciones getReporte() {
        return this.reporte;
    }

    public void procesar() {
        int total = this.calificaciones.size();
        double minimo = Double.MAX_VALUE;
        double maximo = Double.MIN_VALUE;
        double suma = 0.0;
        for (double calificacion : this.calificaciones) {
            if (calificacion < minimo) {
                minimo = calificacion;
            }
            if (calificacion > maximo) {
                maximo = calificacion;
            }
            suma = suma + calificacion;
        }
        reporte = new ReporteCalificaciones(total, minimo, maximo, suma);
    }

}
