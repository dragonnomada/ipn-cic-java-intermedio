package repaso;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class TestMySQL {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";

        Class.forName(driver).getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";

        Connection conn = DriverManager.getConnection(url, user, password);

        Statement statement1 = conn.createStatement(); // Sin parámetros
        // SELECT * FROM usuarios WHERE id = 10;

        PreparedStatement statement = conn.prepareStatement("SELECT NOW(), 10 * ?"); // Con parámetros
        // SELECT * FROM usuarios WHERE id = ?;
        // 1 - 10

        statement.setInt(1, 100);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getInt(2));

        conn.close();

    }

}
