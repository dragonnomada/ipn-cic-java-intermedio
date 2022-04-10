import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class TestSelect {

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

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM prueba");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("NOMBRE: " + resultSet.getString("nombre"));
            System.out.println("------------------------");
        }

        resultSet.close();
        statement.close();

        conn.close();

        System.out.println("Conexión cerrada exitosamente");

    }

}
