# Clases, Contructores, Polimorfismo, Herencia, Interfaces y Clases Abstractas

![Logo CIC](./figuras/logo.png)

    Diplomado de Java - Módulo I
    Departamento de Diplomados y Extensión Profesional
    Centro de Investigación en Cómputo
    Instituto Politécnico Nacional

---

[![Alan Badillo Salas](https://avatars.githubusercontent.com/u/79223578?s=40&v=4 "Alan Badillo Salas")](https://github.com/dragonnomada) Por [Alan Badillo Salas](https://github.com/dragonnomada)

---

## Clases

Una clase es un diseño que especifica cómo serán construidos los objetos (o instancias) a partir de atributos y métodos.

> Tabla de Conceptos de Clases

Concepto | Significado
--- | ---
`Clase` | Abstraer el diseño basado en **atributos** y **métodos**.
`Atributo` | Un dato que puede ser retenido en un objeto, por ejemplo, un número, un texto, un booleano, etc. Los atributos describen al objeto. Entre todos los atributos forman el *estado* del objeto.
`Método` | Es una función que puede recibir parámetros y se puede aplicar sobre un objeto, por ejemplo, para cambiar su estado (`setters`), para obtener su estado (`getters`) o para generar valores del estado del objeto (`funciones o acciones`).
`Objeto` | Es una instancia de la clase, es decir, un espacio en memoria *heap*, que reserva todo lo necesario para guardar los valores de cada atributo. El objeto se contruye a partir del diseño de una clase y toma valores independientes de otros objetos. Cada objeto forma una referencia.

    SINTAXIS:

    class <Nombre> {

        // ATRIBUTOS
        <acceso> <tipo1> <atributo1>;
        <acceso> <tipo2> <atributo2>;
        ...

        // MÉTODOS
        <acceso> <tipo1 retorno> <nombre1>([<tipo y parámetro1>, ...]) {
            ...
            return <retorno de tipo1>
        }
        <acceso> <tipo2 retorno> <nombre2>([<tipo y parámetro1>, ...]) {
            ...
            return <retorno de tipo2>
        }
        ...

    }

> Ejemplo: La clase Persona

```java
class Persona {

    private String nombre;
    private int edad;

    // Getters
    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Métodos
    public String describir() {
        return String.format("%s (%d años)", this.nombre, this.edad);
    }

}
```

Generalmente las clases están relacionadas a entidades, cómo tablas en bases de datos o estructuras que podrán ser compartidas por internet.

### Ejercicio 1.1

* Definir una clase que modele un Reloj.
    - ¿Qué atributos tiene?
    - ¿Qué métodos tiene?
* Definir una clase que modele una Cafetera.
    - ¿Qué atributos tiene?
    - ¿Qué métodos tiene?
* Definir una clase que modele una Cerradura Digital.
    - ¿Qué atributos tiene?
    - ¿Qué métodos tiene?
    - ¿Cómo funciona?

## Constructores

Un constructor es un método especial llamado igual que la clase y que no tiene retorno. Sirve para poder inicializar el estado inicial que tendrá el objeto una vez que sea instanciado (cuando se llame a `new`).

    SINTAXIS:

    class <Nombre> {

        // ATRIBUTOS

        <acceso> <Nombre>([<tipo parámetro1>, ...]) {
            // TODO: Inicializar los atributos
        }

        // MÉTODOS

    }

* **Nota:** Por defecto las clases ya poseen un constructor por defecto que no recibe parámetros y no hace nada. Sin embargo, si hay al menos un constructor definido, ya no habrá contructor por defecto.

> Ejemplo: La clase Elevador

```java
class Elevador {

    int pisos;

    public Elevador() {
        this.pisos = 2;
    }

    public Elevador(int pisos) {
        this.pisos = pisos;
    }

    // MÉTODO (abrirPuertas, cerrarPuertas, subir, bajar, ...)

}
```

En el ejemplo anterior tendríamos dos formas de crear objetos de la clase `Elevador`.

    1. Elevador elevador1 = new Elevador(); // pisos = 2
    2. Elevador elevador2 = new Elevador(15); // pisos = 15

### Ejercicio 1.2

* Crear una clase llamada `Bebida` que tenga los atributos: `color`, `cantidadAlcohol`, `sabor`, `popularidad`.
* Crear los siguientes constructores `Bebida(color)`, `Bebida(cantidadAlcohol)`, `Bebida(color, sabor)`, `Bebida(color, sabor, cantidadAlcohol, popularidad)`.

## Polimorfismo

El polimorfismo nos permite crear una *sobrecarga* de métodos y comportamientos. A través de métodos podemos suponer que un método puede implementar dos o más tipos de lógicas, si se pasan distintos parámentros entre cada lógica. Por ejemplo, que un objeto sea capaz de realizar una venta sin cliente `generarVenta()` o realizar la venta envíando un cliente `generarVenta(cliente)`.

Existe también otro tipo de polimorfismo sobre *interfaces* que veremos después.

> Ejemplo: La clase Venta

```java
class Venta {

    // ATRIBUTOS
    ...

    // MÉTODOS
    ...

    public boolean generarVenta() {
        Cliente cliente = new Cliente("Ventanilla");
        // TODO: Realizar la venta sobre el cliente de vetanilla
    }
    public boolean generarVenta(Cliente cliente) {
        // TODO: Realizar la venta sobre el cliente pasado por parámetro
    }

}
```

### Ejercicio 1.3

* Definir una clase `Contador` con el atributo `int contado` y los métodos `incrementar()`, `incremetar(int pasos)`, `decrementar()` y `decrementar(int pasos)`, `imprimir()`.
* Crear una clase de pruebas para ver si funciona.

## Herencia

La herencia es la capacidad de construir una clase basada en otra. La clase derivada o "heradada" contendrá todas las definiciones de atributos y métodos de su *clase superior* (*clase padre*) que sean accesibles mediante `public` o `protected`. Sin embargo, si el acceso es de tipo `private`, no se podrán acceder.

> Puntos importantes sobre la herencia

1. Sólo se podrá tener una clase superior/padre.
2. Sólo se podrán acceder los miembros de acceso `public` y `protected`.
3. No se podrán derivar clases marcadas con `final`.
4. En el constructor de la clase derivada/hija tendremos que llamar a algún constructor de la clase superior/padre, siempre que no tenga el constructor por defecto.
5. Se pueden definir nuevos atributos y métodos o reemplazarlos si ya existen.
6. Una clase derivada se puede comportar como una clase superior, es decir, una clase hija se puede comportar como una clase padre, incluso una clase abuelo, bisabuelo, etc.

> 1. Sólo se podrá tener una clase superior/padre.

```java
class Padre {
    ...
}

// ERROR: No se pueden extender dos clases al mismo tiempo
class Hijo extends Padre, Otra {
    ...
}
```

> 2. Sólo se podrán acceder los miembros de acceso `public` y `protected`.

```java
class Padre {

    public int a;
    protected int b;
    private int c;

    ...
}

class Hijo extends Padre {
    ...

    void imprimir() {
        System.out.printf("%d\n", this.a); // CORRECTO: `a` es público
        System.out.printf("%d\n", this.b); // CORRECTO: `b` es interno
        System.out.printf("%d\n", this.c); // ERROR: `c` es privado (sólo dentro de Padre)
    }

}
```

> 3. No se podrán derivar clases marcadas con `final`.

```java
final class Padre {
    ...
}

// ERROR: La clase Padre es final
class Hija extends Padre {
    ...
}
```

> 4. En el constructor de la clase derivada/hija tendremos que llamar a algún constructor de la clase superior/padre, siempre que no tenga el constructor por defecto.

```java
class Padre {

    public Padre(int a) {
        ...
    }

    public Padre(int a, int b) {
        ...
    }

}

class Hija extends Padre {

    public Hija(int c) {
        super(c * 100); // Padre(int a)
        // super(a, b); // Padre(int a, int b)
    }

}
```

> 5. Se pueden definir nuevos atributos y métodos o reemplazarlos si ya existen.

```java
class Padre {
    
    void imprimir() { ... }
    void calcular(int x, int y) { ... }

}

class Hijo extends Padre {

    // Reemplazar
    @Override
    void imprimir() { ... }

    // Extender
    void calcular() { ... }

    // Agregar
    void obtenerDivisa() { ... }

}
```

> 6. Una clase derivada se puede comportar como una clase superior, es decir, una clase hija se puede comportar como una clase padre, incluso una clase abuelo, bisabuelo, etc.

```java
class Padre {

    int a;
    int b;
    int c;

}

class Hijo extends Padre {

    int x;
    int y;

}

class Nieta extends Hijo {

    int z;

}

Nienta n = new Nieta();

// n.a
// n.b
// n.c
// n.x
// n.y
// n.z

Padre p = n;
Hijo h = n;
```

> Ejemplo: La clase Archivo

```java
class File {

    String path;
    int size;

}

class SystemFile extends File {

    String name;
    String ext;

}

class IOFile extends SystemFile {

    byte[] data;

}

IOFile file = new IOFile();

Util.checkFile(file); // checkFile(File file); IOFile --> SystemFile --> File

Util.checkSystemFile(file); // checkFile(File file); IOFile --> SystemFile --> File

Util.checkIOFile(file); // checkFile(File file); IOFile --> SystemFile --> File

File file2 = new File();

Util.checkSystemFile(file2); // ERROR: SystemFile?
Util.checkIOFile(file2); // ERROR: IOFile?
```

### Ejercicio 1.4

* Crear la clase `RobotLineal` con los métodos `avanzar()`, `retroceder()`.
* Crear la clase derivada `Robot2D` que reemplace los métodos de avanzar y retroceder agregando un ángulo y calculando a dónde tiene que avanzar y retroceder.

> Ejemplo

    class RobotLineal {

        double x;

        void avanzar() {
            x += 1;
        }

        void retroceder() {
            x -= 1;
        }

        // TODO: agregar imprimir()
    }

    class Robot2D extends RobotLineal {

        double y;
        double a;

        @Override            
        void avanzar() {
            x = ???;
            y = ???;
        }

        @Override    
        void retroceder() {
            x = ???;
            y = ???;
        }

        // TODO: modificar imprimir()

    }

## Interfaces

Las interfaces son definiciones de conjuntos de métodos que pueden ser implementados por las clases o clases abstractas. Sirven para formar estereotipos que le indiquen a la clase qué métodos necesita implementar para que otras clases utilicen modelos basados en interfaces y no en instancias.

    SINTAXIS:

    interface <Nombre> [implements <Otras Interfaces ...>] {

        public <método1>([<tipo parámetro1>, ...]);
        public <método2>([<tipo parámetro1>, ...]);
        ...

    }

Por ejemplo, nosotros en un sistema de ventas logramos detectar un conjunto de métodos que pueden abstraídos para realizar una transacción.

> Ejemplo: Interfaz `TransaccionVenta`

```java
interface TransaccionVenta {

    public boolean carritoAbierto(Carrito carrito);

    public boolean totalValido(Carrito carrito, double total);

    public double obtenerTotalCarrito(Carrito carrito);

    public boolean realizarVenta(Vendedor vendedor, Cliente cliente, Carrito carrito);

}
```

Entonces las clases y otros métodos podrían recibir a la interfaz como estereotipo, para poder hacer transacciones y generalmente son usadas para establecer consultas, transacciones y demás elementos que se puedan implementar de distintas formas.

> Ejemplo: Se muestra el uso de la interfaz como un servicio

```java
public boolean hacerVenta(TransaccionVenta servicioVenta) {
    if (servicioVenta.carritoAbierto(this.carritoCache)) {
        double totalCache = servicioVenta.obtenerTotalCarrito(this.carritoCache);
        if (servicioVenta.totalValido(this.carritoReal, totalCache)) {
            if (servicioVenta.realizarVenta(this.vendedor, this.cliente, this.carritoCache)) {
                // TODO: Venta exitosa
                return true;
            } else {
                // TODO: No se pudo realizar la venta
                return false;
            }
        } else {
            // TODO: El total no coincide entre cache y real
            return false;
        }
    } else {
        // TODO: Informar al usuario que el carrito no está abierto
        return false;
    }
}
```

Las interfaces nos permitirán utilizar métodos como servicios, sin tener que esperar a que alguien los implemente. Además nos dará la posibilidad de implimentar de múltiples formas la misma interfaz. Por ejemplo, en escenarios móviles, de escritorio, de servidores, basados en la nube o de pruebas. Todo dependiendo de cómo se implemente la interfaz en cada escenario.

Quiénes usen la interfaz no deberán preocuparse de cómo fueron implementados, si usaron bases de datos, servicios en la nube, archivos de excel, o cualquier otra cosa que hayan necesitado al implementar los métodos.

Las interfaces generan comportamientos, no sabemos cómo están implementadas, pero si el comportamiento que producirán. Esto es muy bueno en desarrollos del BDD (`Behavior Development Driven`).

Las clases pueden implementar más de una interfaz y se dice, que la clase adquiere los comportamientos de cada interfaz.

> Ejemplo: Una clase que se comporta como Serializable y Almacenable

```java
interface Serializable {
    public byte[] serializar();
    public void deserializar(byte[]);
}

interface Almacenable {
    public boolean save(File file);
    public boolean load(File file);
}

class Persona implements Serializable, Almacenable {

    ...

    @Override
    public byte[] serializar() {
        // TODO: Convertir nuestros atributos en bytes
        return ...
    }

    @Override
    public void deserializar(byte[]) {
        // TODO: Convertir nuestros atributos en bytes
    }
    
    @Override
    public boolean save(File file) {
        // TODO: Abrir el archivo y guardar nuestro contenido (bytes?)
        return ...
    }

    @Override
    public boolean load(File file) {
        // TODO: Abrir el archivo y cargamos nuestro contenido (bytes?)
        return ...
    }

}
```

### Ejercicio 1.5

* Diseña las interfaces necesarias que agrupen todas las operaciones posibles en una tienda de renta de películas.

> Ejemplo:

    interface BuscarPelicula {
        ???
    }

    interface ExistenciasPelicula {
        ???
    }

    interface RentaPelicula {
        ???
    }

    interface DevolucionPelicula {
        ???
    }

## Clases Abstractas

Las clases abstractas son un intermedio entre lo que es una clase normal y lo que es una interfaz. Las clases abstractas nos van permitir implementar algunos métodos y otros dejarlos sin implementar. A diferencia de las interfaces que no nos permiten implementar nada en los métodos.

> Ejemplo: Robot

```java
abstract class Robot {

    double x;
    double y;

    abstract public double radio();
    abstract public double angulo();

    public void moverAdelante() {
        double r = this.radio();
        double a = this.angulo();
        this.x += r * Math.cos(a);
        this.y += r * Math.sin(a);
    }

}

class RobotTerrestre extends Robot {

    @Override
    public double radio() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public double angulo() {
        return Math.atan2(y, x);
    }


}
```

### Ejercicio 1.6

* Definir una clase `Contador` que soporte hasta `3` conteos (`a`, `b`, `c`).
* Cómo podemos agregar métodos abstractos que nos permitan usar ese contador como un reloj de `horas`, `minutos` y `segundos`.
