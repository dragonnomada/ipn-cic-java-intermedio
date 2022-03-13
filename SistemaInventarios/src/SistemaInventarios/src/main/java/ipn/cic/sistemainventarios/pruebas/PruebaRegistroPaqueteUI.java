package ipn.cic.sistemainventarios.pruebas;

import ipn.cic.sistemainventarios.clasess.Paquete;
import ipn.cic.sistemainventarios.components.RegistroPaquete;
import ipn.cic.sistemainventarios.uis.RegistroPaqueteUI;

public class PruebaRegistroPaqueteUI {

    public static void main(String[] args) {
        RegistroPaquete registroPaquete = new RegistroPaquete();
        
        RegistroPaqueteUI ui = registroPaquete.sendFormularioRegistroPaqueteUI();
        
        ui.capturar();
        
        Paquete paquete = registroPaquete.sendPaquete();
        
        paquete.describir();
    }
    
}
