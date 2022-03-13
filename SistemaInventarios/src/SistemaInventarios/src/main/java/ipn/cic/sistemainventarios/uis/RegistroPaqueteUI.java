package ipn.cic.sistemainventarios.uis;

import ipn.cic.sistemainventarios.components.RegistroPaquete;

public class RegistroPaqueteUI {

    RegistroPaquete registroPaquete;
    
    public void setRegistroPaquete(RegistroPaquete registroPaquete) {
        this.registroPaquete = registroPaquete;
    }
    
    public void capturar() {
        System.out.println("Capturando paquete....");
        this.registroPaquete.capturaPaquete();
        System.out.println("Paquete capturado.");
    }
    
}
