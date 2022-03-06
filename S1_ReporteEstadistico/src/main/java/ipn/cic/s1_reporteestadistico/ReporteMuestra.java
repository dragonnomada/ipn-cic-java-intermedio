/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipn.cic.s1_reporteestadistico;

import java.util.List;

public class ReporteMuestra {
    
    Muestra muestra; // Objeto llamado muestra de la clase Muestra
    
    public ReporteMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
    
    public ReporteMuestra(List<Double> valores) {
        this.muestra = new Muestra(); // Crea un nuevo objeto de la clase Muestra
        
        // Recorre cada valor de la lista de números
        for (double valor : valores) {
            // Agregamos el valor a la muestra
            this.muestra.addValor(valor);
        }
    }
    
    public void imprimir() {
        int total = this.muestra.getTotal();
        double minimo = this.muestra.getMinimo();
        double maximo = this.muestra.getMaximo();
        double suma = this.muestra.getSuma();
        double suma2 = this.muestra.getSuma2();
        double promedio = this.muestra.getPromedio();
        double varianza = this.muestra.getVarianza();
        double desviacionEstandar = this.muestra.getDesviacionEstandar();
        
        System.out.printf("Muestra: %d\n", total);
        System.out.printf("Mínimo: %.2f\n", minimo);
        System.out.printf("Máximo: %.2f\n", maximo);
        System.out.printf("Suma: %.2f\n", suma);
        System.out.printf("Suma2: %.2f\n", suma2);
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.printf("Varianza: %.2f\n", varianza);
        System.out.printf("Desviación Estándar: %.2f\n", desviacionEstandar);
        
    }
    
}
