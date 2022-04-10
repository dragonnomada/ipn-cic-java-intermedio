import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppNuevaPrueba {
    private JTextField textField1;
    private JButton agregarPruebaButton;
    private JPanel panel1;

    public AppNuevaPrueba() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Connection conn;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "sesion6";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "password";

        Class.forName(driver).getDeclaredConstructor().newInstance();

        conn = DriverManager.getConnection(url + dbName, user, password);

        agregarPruebaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Conectado correctamente a la base de datos");

                PreparedStatement statement = null;
                try {
                    statement = conn.prepareStatement("INSERT INTO prueba (nombre) values (?)");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    statement.setString(1, textField1.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                int count = 0;
                try {
                    count = statement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                System.out.printf("Se insertaron %d registros\n", count);

                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFrame frame = new JFrame();

        AppNuevaPrueba app = new AppNuevaPrueba();

        frame.add(app.panel1);

        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
