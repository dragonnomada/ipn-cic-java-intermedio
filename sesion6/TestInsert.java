import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class TestInsert {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        Connection conn;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "sesion6";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "password";

        Class.forName(driver).getDeclaredConstructor().newInstance();

        conn = DriverManager.getConnection(url + dbName, user, password);

        System.out.println("Conectado correctamente a la base de datos");

        PreparedStatement statement = conn.prepareStatement("INSERT INTO prueba (nombre) values (?)");

        statement.setString(1, "Prueba 4");

        int count = statement.executeUpdate();

        System.out.printf("Se insertaron %d registros\n", count);

        statement.close();

        conn.close();

        System.out.println("Conexión cerrada exitosamente");

    }

}
