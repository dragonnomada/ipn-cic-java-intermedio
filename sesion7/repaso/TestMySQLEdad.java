package repaso;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class TestMySQLEdad {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";

        Class.forName(driver).getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement statement = conn.prepareStatement("SELECT ? >= 18");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dame tu edad:");
        int edad = scanner.nextInt(); scanner.nextLine();

        scanner.close();

        statement.setInt(1, edad);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        System.out.println(resultSet.getBoolean(1));

        conn.close();

    }

}
