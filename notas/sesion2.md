# Herencia y Polimorfismo

![Logo CIC](./figuras/logo.png)

    Diplomado de Java - Módulo I
    Departamento de Diplomados y Extensión Profesional
    Centro de Investigación en Cómputo
    Instituto Politécnico Nacional

---

[![Alan Badillo Salas](https://avatars.githubusercontent.com/u/79223578?s=40&v=4 "Alan Badillo Salas")](https://github.com/dragonnomada) Por [Alan Badillo Salas](https://github.com/dragonnomada)

---

## Herencia

La herencia puede entenderse como la extensión de una clase (superior) en otra clase (inferior), derivando el diseño de la clase superior en la clase inferior.

La herencia permite extender el diseño de una clase (atributos y métodos), para que estos incrementen o sean reemplazados según convenga.

### A. Superclases y subclases

Se considera una `Superclase` a cualquier clase que haya sido derivada. Se considera una `Subclase` a cualquier clase que haya extendido (heredado) a alguna superclase.

> Ejemplo 2.1 - La clase de `Paquete` y `PaqueteAlmacenado`

    [Paquete]
        [-] idPaquete : Entero
        [-] ancho     : Entero
        [-] alto      : Entero
        [-] largo     : Entero
        [-] peso      : Decimal
    
    [PaqueteAlmacenado] < [Paquete]
        [-] almacen      : [Almacen]
        [-] numEstante   : Entero
        [-] numRepisa    : Entero
        [-] posicion     : Entero
        [-] existencias  : Entero

### B. Relación entre las superclases y las subclases

La `Subclase` contiene todos los miembros de la `Superclase`, sin embargo, sólo puede acceder a los miembros públicos y protegidos, pero no a los privados.

La `Superclase` no sabe nada acerca de las `subclase`, ni siquiera de su existencia, por lo que no puede acceder a ningún miembro.

> Ejemplo 2.2 - Acceso de los miembros de `Paquete` desde `PaqueteAlmacenado`

    [Paquete]
        [-] abrirPaquete : () -> *
        [#] firmarPaquete : (firma : Texto) -> Booleano
        [+] densidadPaquete : () -> Decimal

    [PaqueteAlmacenado]
        [#] firmarPaquete    : <<derivado y protegido>>
        [+] densidadPaquete  : <<derivado y público>>

Como podemos observar del `Ejemplo 2.2`, el `PaqueteAlmacenado` tendrá acceso al método `firmarPaquete` ya que está marcado como protegido (`[#]`), es decir, que la clase `Paquete` permite que accedan a este método todas sus clases derivadas. También tendremos acceso al método `densidadPaquete`, ya que la clase `Paquete` la ha marcado público (`[+]`), y permite que cualquiera acceda a este miembro, incluyendo sus clases derivadas y clases no derivadas. Sin embargo, el método `abrirPaquete` ha sido marcado por la clase `Paquete` como privado (`-`), esto impide que cualquier clase, derivada o no, pueda acceder a este miembro. Estos últimos se consideran miembros privados o internos de clase, y nadie podrá usarlos más que la propia clase.

### C. Los constructores en las subclases

Si una `Superclase` define al menos un constructor, alguno de estos deberá ser llamado obligatoriamente dentro de la `Subclase`, para construir correctamente a la superclase.

> Ejemplo 2.3 - El constructor de la clase `Paquete` y la clase `PaqueteAlmacenado`

```java
public class Paquete {

    // ... Atributos
    int id;
    int ancho;
    int alto;
    int largo;
    double peso;

    // Constructor del paquete mediante su id
    public Paquete(int id) {
        this.id = id; 
        this.ancho = 1; 
        this.alto = 1; 
        this.largo = 1; 
        this.peso = 1.0;
    }
    
    // Constructor del paquete mediante su id y dimensiones
    public Paquete(int id, int ancho, int alto, int largo) {
        this.id = id; 
        this.ancho = ancho; 
        this.alto = alto; 
        this.largo = largo; 
        this.peso = 1.0;
    }

    // ... Métodos

}

public class PaqueteAlmacenado {
    
    // ... Atributos
    Almacen almacen;
    int numEstante;
    int numRepisa;
    int posicion;
    int existencias;

    // Constructor del paquete almacenado usando el constructor por id
    public PaqueteAlmacenado(int id) {
        super(id);

        this.almacen = new Almacen();
        this.numEstante = 0;
        this.numRepisa = 0;
        this.posicion = 0;
        this.existencias = 0;
    }
    
    // Constructor del paquete almacenado usando el constructor por id y dimensiones
    public PaqueteAlmacenado(int id, int largo, int numEstante, int numRepisa) {
        super(id, largo, largo, largo);

        this.almacen = new Almacen();
        this.numEstante = numEstante;
        this.numRepisa = numRepisa;
        this.posicion = 0;
        this.existencias = 0;
    }

    // ... Métodos

}
```

Observa que la subclase `PaqueteAlmacenado` decide a qué constructor de la superclase llamar y bajo qué parámetros.

### D. Jerarquía de clases

Una serie de superclases y subclases de la misma clase base forman una jeraquía de herencia descendente. Sin embargo, en el caso de existir ramificaciones se perderá la relación entre clases hermanas.

> Ejemplo 2.4 - Jerarquía de las clases de un sistema de paquetería

    [Paquete]
        └─────── [PaqueteAlmacenado]
        │                └─────── [PaqueteExhibidor]
        │                └─────── [PaqueteZonaEntrega]
        └─────── [PaqueteTransportado]
                         └─────── [PaqueteEntregado]
                         └─────── [PaqueteRechazado]
                         └─────── [PaquetePerdido]

    JERARQUÍA
        [Paquete] > [PaqueteAlmacenado] > [PaqueteExhibidor]
        [Paquete] > [PaqueteAlmacenado] > [PaqueteZonaEntrega]
        [Paquete] > [PaqueteTransportado] > [PaqueteEntregado]
        [Paquete] > [PaqueteTransportado] > [PaqueteRechazado]
        [Paquete] > [PaqueteTransportado] > [PaquetePerdido]

En las jerarquías, las subclases se podrán comportar como una superclase. Por ejemplo, la clase `PaqueteExhibidor` se podrá comportar como la clase `PaqueteAlmacenado` y la clase `Paquete`, pero no como la clase `PaqueteTransportado`, porque está fuera de su jerarquía.

### E. Referencias a objetos de una subclase

Los objetos creados de subclases se pueden entender como objetos "más generales" que los objetos creados por superclases. Es decir, un objeto generado por una subclase contendrá todas las definiciones de cualquiera de su superclase, además de otras adicionales.

> Ejemplo 2.5 - Objetos de la subclase `PaqueteExhibidor`

    PaqueteExhibidor paqueteExhibido = new PaqueteExhibidor(...);

    // JERARQUÍA: [Paquete] > [PaqueteAlmacenado] > [PaqueteExhibidor]

    // `printInfoAlmacen` proporcionado por `PaqueteAlmacenado`
    paqueteExhibido.printInfoAlmacen();


    // `printInfoPaquete` proporcionado por `Paquete`
    paqueteExhibido.printInfoPaquete();

### Ejercicio 2.1

* Diseña una jerarquía de clases para un sistema productos, considerando el producto tal cual, los productos de limpieza, productos alimenticios, productos para automóviles y de estos productos específicos como limpieza de baño, limpieza de cocina, alimentos perecederos, alimentos no perecederos, productos para el interior del automóvil, para el exterior, etc.

## Polimorfismo

El polimorfismo nos permitirá tratar objetos de subclases, como objetos de superclases. Esto facilitará el uso de los objetos en diferentes escenarios. Por ejemplo, tratar un `PaqueteExhibidor` como un simple `Paquete` o un `PaqueteAlmacen`.

### A. Demostración de comportamiento polimórfico

Pensemos en una demostración sencilla. Supongamos que existe una clase llamada `Transporte`, la cual recibe un paquete general para ser transportado, esto mediante el método `transportar(paquete)`. Entonces, podemos crear cualquier clase de paquete y darselo al transporte para que este paquete sea transportado.

> Ejemplo 2.6 - La clase `Transporte`, la clase `Paquete` y sus derivados

    Transporte camionetaDHL = new Transporte("Camioneta", "DHL");

    PaqueteAlmacenado cajaSabritas = new PaqueteAlmacenado(23, "Sabritas");

    camionetaDHL.transportar(cajaSabritas);

    PaqueteTransportado cajaRefrescos = new PaqueteTransportado(57, "Refrescos");

    camionetaDHL.transportar(cajaRefrescos);

Podemos observar que el transporte acepta cualquier tipo de paquete. Ya que todos los paquetes derivan de la superclase `Paquete`. Sin embargo, es posible que algunos paquetes no fueran aceptados si se cambiara el método `transportar` para que sólo acepte objetos de la superclase `PaqueteTransportado` y sus derivados.

### B. Downcasting

El proceso **Downcasting** o máscara gruesa, se refiere a definir un objeto de alguna superclase como un objeto de una superclase, para después recuperar la información de una subclase intermedia en la jerarquía.

> Ejemplo 2.7 - Las clases `Paquete`, `PaqueteAlmacenado` y `PaqueteZonaEntrega` en el `Downcasting`

    // JERARQUÍA: [Paquete] > [PaqueteAlmacenado] > [PaqueteZonaEntrega]

    Paquete cajaSabritas = PaqueteZonaEntrega(23, "Sabritas", "Zona Plaza Sur").

    cajaSabritas.<<métodos de Paquete>>

    // DOWNCASTING: PaqueteAlmacenado

    PaqueteAlmacenado cajaSabritasAlmacenado = (PaqueteAlmacenado)cajaSabritas;

    cajaSabritasAlmacenado.<<métodos de PaqueteAlmacenado>>

    // DOWNCASTING: PaqueteZonaEntrega

    PaqueteZonaEntrega cajaSabritasEntrega = (PaqueteZonaEntrega)cajaSabritas;

    cajaSabritasEntrega.<<métodos de PaqueteZonaEntrega>>

Veamos que la diferencia en cada *downcasting* es que podemos acceder a los diferentes métodos definidos en el casting. Aquí planificamos ir desde la mayor jerarquía hasta la menor, para no perder generalidad desde un principio.

### C. Upcasting

El proceso **Upcasting** es similar al *downcasting*, pero en este caso ascendemos según se requiera desde una subclase.

> Ejemplo 2.8 - Las clases `Paquete`, `PaqueteAlmacenado` y `PaqueteZonaEntrega` en el `Upcasting`

    // JERARQUÍA: [Paquete] > [PaqueteAlmacenado] > [PaqueteZonaEntrega]

    PaqueteZonaEntrega cajaSabritasEntrega = PaqueteZonaEntrega(23, "Sabritas", "Zona Plaza Sur").

    cajaSabritasEntrega.<<métodos de PaqueteZonaEntrega>>

    // UPCASTING: PaqueteAlmacenado

    PaqueteAlmacenado cajaSabritasAlmacenado = (PaqueteAlmacenado)cajaSabritasEntrega;

    cajaSabritasAlmacenado.<<métodos de PaqueteAlmacenado>>

    // DOWNCASTING: Paquete

    Paquete cajaSabritas = (Paquete)cajaSabritasEntrega;
    
    cajaSabritas.<<métodos de Paquete>>

Veamos que la diferencia en cada *upcasting* es que podemos acceder a los diferentes métodos definidos en el casting. Aquí no es necesario planificar la jerarquía mayor, sólo ir ascendiendo según se requiera.

### Ejercicio 2.2

* Implementa métodos que consuman distintos niveles en las jerarquías de los productos y utiliza el `downcasting` y el `upcasting` para consumirlos.
