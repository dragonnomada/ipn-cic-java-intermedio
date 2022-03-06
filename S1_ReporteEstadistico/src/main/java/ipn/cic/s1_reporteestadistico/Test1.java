package ipn.cic.s1_reporteestadistico;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<Double> valores = new ArrayList<Double>();
        
        valores.add(1d);
        valores.add(4d);
        valores.add(2d);
        valores.add(6.5d);
        valores.add(1.5d);
        
        ReporteMuestra reporte1 = new ReporteMuestra(valores);
        
        reporte1.imprimir();
        
        Muestra muestra = new Muestra();
        
        muestra.addValor(1d);
        muestra.addValor(4d);
        muestra.addValor(2d);
        muestra.addValor(6.5d);
        muestra.addValor(1.5d);
        
        ReporteMuestra reporte2 = new ReporteMuestra(muestra);
        
        reporte2.imprimir();
        
    }
    
}
