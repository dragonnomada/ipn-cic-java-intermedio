import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CapturarCalificaciones {

    List<Double> calificaciones;

    public CapturarCalificaciones() {
        this.calificaciones = new ArrayList<>();
    }

    // Ofrece: calificaciones
    public List<Double> getCalificaciones() {
        return this.calificaciones;
    }

    public void capturar(Scanner scanner) {

        this.calificaciones.clear();

        System.out.println("Número de calificaciones: ");
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.printf("Dame la calificación %d: \n", i + 1);

            double calificacion = scanner.nextDouble();

            this.calificaciones.add(calificacion);
        }


    }

}
