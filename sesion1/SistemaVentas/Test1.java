package SistemaVentas;

public class Test1 {
    
    public static void main(String[] args) {
        Vendedor vendedorPepe = new Vendedor();
        vendedorPepe.id = 1;
        vendedorPepe.nombre = "Pepe";
        
        Cliente ClientePaco = new Cliente();
        ClientePaco.id = 1001;
        ClientePaco.nombre = "Paco";

        Venta venta = new Venta();
        venta.vendedor = vendedorPepe;
        venta.cliente = ClientePaco;

        Producto productoCoca = new Producto();
        productoCoca.id = 20001;
        productoCoca.nombre = "Coca Cola 600ml";
        productoCoca.precio = 18.5;
        productoCoca.extistencias = 23;
        
        Producto productoMarias = new Producto();
        productoMarias.id = 20002;
        productoMarias.nombre = "Galletas Marías";
        productoMarias.precio = 9.5;
        productoMarias.extistencias = 133;

        Producto productoGansito = new Producto();
        productoGansito.id = 20003;
        productoGansito.nombre = "Gansito";
        productoGansito.precio = 10.5;
        productoGansito.extistencias = 2;

        venta.agregarProducto(productoCoca);
        venta.agregarProducto(productoMarias);
        venta.agregarProducto(productoCoca);
        venta.agregarProducto(productoGansito);

        venta.finalizarCompra();

    }

}
