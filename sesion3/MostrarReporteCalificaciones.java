public class MostrarReporteCalificaciones {

    private ReporteCalificaciones reporte;

    // Require: reporteCalificaciones
    public void setReporte(ReporteCalificaciones reporte) {
        this.reporte = reporte;
    }

    public void mostrar() {
        if (this.reporte == null) {
            System.out.println("No hay reporte");
            return;
        }

        System.out.println("Reporte de Calificaciones:");
        System.out.printf("Total: %d\n", this.reporte.getTotal());
        System.out.printf("Mínimo: %.2f\n", this.reporte.getMinimo());
        System.out.printf("Máximo: %.2f\n", this.reporte.getMaximo());
        System.out.printf("Suma: %.2f\n", this.reporte.getSuma());
        System.out.printf("Promedio: %.2f\n", this.reporte.getPromedio());
    }

}
