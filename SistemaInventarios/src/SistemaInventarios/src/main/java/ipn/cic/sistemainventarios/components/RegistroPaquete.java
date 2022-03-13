package ipn.cic.sistemainventarios.components;

import ipn.cic.sistemainventarios.clasess.Paquete;
import ipn.cic.sistemainventarios.uis.RegistroPaqueteUI;
import java.util.Scanner;

public class RegistroPaquete {

    Paquete ultimoPaqueteRegistrado;
    
    public void capturaPaquete() {
        this.ultimoPaqueteRegistrado = null;
        
        // TODO: Devolver un paquete registrado
        Paquete paquete = new Paquete();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Ingresa los datos del paquete\n");
        
        System.out.printf("Id: ");
        int id = sc.nextInt();sc.nextLine();
        
        System.out.printf("Código: ");
        String codigo = sc.nextLine();
        
        System.out.printf("Número de Guía: ");
        String guia = sc.nextLine();
        
        System.out.printf("Ancho: ");
        double ancho = sc.nextDouble();sc.nextLine();
        
        System.out.printf("Alto: ");
        double alto = sc.nextDouble();sc.nextLine();
        
        System.out.printf("Largo: ");
        double largo = sc.nextDouble();sc.nextLine();
        
        System.out.printf("Peso: ");
        double peso = sc.nextDouble();sc.nextLine();
        
        sc.close();
        
        paquete.setId(id);
        paquete.setCodigo(codigo);
        paquete.setGuia(guia);
        paquete.setAncho(ancho);
        paquete.setAlto(alto);
        paquete.setLargo(largo);
        paquete.setPeso(peso);
        
        this.ultimoPaqueteRegistrado = paquete;
    } 
    
    public Paquete sendPaquete() {
        return this.ultimoPaqueteRegistrado;
    }
    
    public RegistroPaqueteUI sendFormularioRegistroPaqueteUI() {
        // TODO: Construir la interfaz del registro del paquete
        RegistroPaqueteUI ui = new RegistroPaqueteUI();
        
        // TODO: Ajustar la interfaz
        ui.setRegistroPaquete(this);
        
        return ui;
    }
    
}
