import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {

    public static void main(String[] args) {

        Connection conn;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "sesion6";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "password";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();

            conn = DriverManager.getConnection(url + dbName, user, password);

            System.out.println("Conectado correctamente a la base de datos");

            conn.close();

            System.out.println("Conexión cerrada exitosamente");
        } catch (ClassNotFoundException e) {
            System.out.println("La clase del drive no existe: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("El método no existe: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("La invocación falló: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Acceso ilegal: " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("La instancia falló: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Falló SQL: " + e.getMessage());
        }

    }

}
