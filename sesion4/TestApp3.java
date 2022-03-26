import javax.swing.*;

public class TestApp3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        App3 app3 = new App3();

        frame.add(app3.getPanel1());

        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
