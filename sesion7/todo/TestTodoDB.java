package todo;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class TestTodoDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        TodoDB db = new TodoDB();

        db.agregarTodo("Prueba 2 - Generado desde la prueba TestTodoDB");

        db.close();

    }

}
