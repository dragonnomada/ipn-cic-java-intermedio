import javax.swing.*;

public class TestAppMenus {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        AppMenus app = new AppMenus();

        frame.add(app.getPanel1());

        // 7. Establecemos la barra de menú en la ventana
        frame.setJMenuBar(app.getMenuBar1());

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
