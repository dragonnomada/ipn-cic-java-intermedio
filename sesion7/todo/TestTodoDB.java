package todo;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class TestTodoDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        TodoDB db = new TodoDB();

        //db.agregarTodo("Prueba 2 - Generado desde la prueba TestTodoDB");

        db.completarTodo(1, true);
        db.completarTodo(2, false);
        db.completarTodo(3, true);

        db.close();

    }

}
