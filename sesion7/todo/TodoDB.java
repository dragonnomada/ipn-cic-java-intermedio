package todo;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class TodoDB {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password = "password";

    private Connection connection;

    public TodoDB() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName(this.driver).getDeclaredConstructor().newInstance();

        this.connection = DriverManager.getConnection(this.url, this.user, this.password);

        this.crearTabla();
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void crearTabla() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS todos (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "titulo VARCHAR(255) NOT NULL," +
                        "completado BOOLEAN DEFAULT 0)"
        );

        statement.execute();

        statement.close();
    }

    public void agregarTodo(String titulo) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO todos (titulo) VALUES (?)"
        );

        statement.setString(1, titulo);

        statement.execute();

        statement.close();
    }

    public void completarTodo(int id, boolean completado) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE todos SET completado=? WHERE id=?"
        );

        statement.setBoolean(1, completado);
        statement.setInt(2, id);

        statement.execute();

        statement.close();
    }

    public ArrayList<Todo> obtenerTodos() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT id, titulo, completado FROM todos"
        );

        ResultSet resultSet = statement.executeQuery();

        ArrayList<Todo> todos = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String titulo = resultSet.getString(2);
            boolean completado = resultSet.getBoolean(3);
            Todo todo = new Todo(id, titulo, completado);
            todos.add(todo);
        }

        resultSet.close();
        statement.close();

        return todos;
    }

}
