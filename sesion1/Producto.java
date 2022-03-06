class Producto {

  String sku;
  String nombre;
  Integer existencias;
  Double precio;

  Integer cambioExtencias(Integer nuevasExtencias) {
    Integer diferencia = this.existencias - nuevasExtencias;
    this.existencias = nuevasExtencias;
    return diferencia;
  }

  boolean altaExistencias(Integer existencias) {
    if (existencias <= 0) {
      return false;
    }
    this.existencias += existencias;
    return true;
  }

  boolean bajaExistencias(Integer existencias) {
    if (existencias <= 0) {
      return false;
    }
    this.existencias -= existencias;
    return true;
  }
}
