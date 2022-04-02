import javax.swing.*;

public class TestAppTreeClientes {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        AppTreeClientes app = new AppTreeClientes();

        frame.add(app.panel1);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
