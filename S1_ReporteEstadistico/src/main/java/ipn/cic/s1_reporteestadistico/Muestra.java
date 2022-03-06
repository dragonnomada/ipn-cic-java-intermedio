package ipn.cic.s1_reporteestadistico;

import java.util.ArrayList;
import java.util.List;

public class Muestra {

    List<Double> valores = new ArrayList<Double>();
    
    public void addValor(double valor) {
        this.valores.add(valor);
    }
    
    public int getTotal() {
        return this.valores.size();
    }
    
    public double getMinimo() {
        double minimo = this.valores.get(0);
        
        for (int i = 0; i < this.valores.size(); i++) {
            double valor = this.valores.get(i);
            if (valor < minimo) {
                minimo = valor;
            }
        }
        
        return minimo;
    }
    
    public double getMaximo() {
        double  maximo = this.valores.get(0);
        
        for (int i = 0; i < this.valores.size(); i++) {
            double valor = this.valores.get(i);
            if (valor > maximo) {
                maximo = valor;
            }
        }
        
        return maximo;
    }
    
    public double getSuma() {
        double suma = 0;
        
        for (double valor : this.valores) {
            suma = suma + valor; // suma += valor
        }
        
        return suma;
    }
    
    public double getSuma2() {
        double suma2 = 0;
        
        for (double valor : this.valores) {
            suma2 = suma2 + valor * valor; // suma += Math.pow(valor, 2)
        }
        
        return suma2;
    }
    
    public double getPromedio() {
        double suma = this.getSuma();
        
        return suma / this.valores.size();
    }
    
    public double getVarianza() {
        double suma = 0;
        
        double promedio = this.getPromedio();
        
        for (double valor : this.valores) {
            suma += Math.pow(valor - promedio, 2);
        }
        
        return suma / this.valores.size();
    }
    
    public double getDesviacionEstandar() {
        return Math.sqrt(this.getVarianza());
    }
    
}
