import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean mostrarMenu = true;

        CapturarCalificaciones capturarCalificaciones = new CapturarCalificaciones();
        ProcesarCalificaciones procesarCalificaciones = new ProcesarCalificaciones();
        MostrarReporteCalificaciones mostrarReporteCalificaciones = new  MostrarReporteCalificaciones();

        while (mostrarMenu) {
            System.out.println("Sistema de Calificaciones");
            System.out.println("-----------------------------------");
            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Procesar calificaciones");
            System.out.println("3. Mostrar Reporte calificaciones");
            System.out.println("------------------------------------");
            System.out.println("4. Salir");

            System.out.println("Opción > ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    capturarCalificaciones.capturar(scanner);
                    break;
                case 2:
                    // Ofrece -> calificaciones <- Requiere
                    procesarCalificaciones.setCalificaciones(
                            capturarCalificaciones.getCalificaciones()
                    );
                    procesarCalificaciones.procesar();
                    break;
                case 3:
                    mostrarReporteCalificaciones.setReporte(
                            procesarCalificaciones.getReporte()
                    );
                    mostrarReporteCalificaciones.mostrar();
                    break;
                case 4:
                    System.out.println("Adiós");
                    mostrarMenu = false;
                    break;
            }
        }

        scanner.close();

    }

}