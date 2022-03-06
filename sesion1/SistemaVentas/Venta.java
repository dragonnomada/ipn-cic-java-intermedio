package SistemaVentas;

import java.util.ArrayList;
import java.util.List;

public class Venta {
 
    Vendedor vendedor;
    Cliente cliente;
    List<Producto> productos = new ArrayList<Producto>();

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public boolean quitarProducto(Producto producto) {
        return this.productos.remove(producto);
    }

    public void limpiarVenta() {
        this.productos.clear();
    }

    public void finalizarCompra() {
        System.out.printf("Vendedor: %s\n", this.vendedor.nombre);
        System.out.printf("Cliente: %s\n", this.cliente.nombre);
        System.out.printf("Productos:\n");
        double total = 0;
        for (Producto producto : this.productos) {
            System.out.printf("[%s] %s $%.2f\n", producto.id, producto.nombre, producto.precio);
            total += producto.precio;
        }
        System.out.printf("Total: $%.2f\n", total);
        this.limpiarVenta();
    }

}
