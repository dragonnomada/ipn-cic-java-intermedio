import javax.swing.*;

public class TestApp5 {

    public static void main(String[] args) {
        App5 app5 = new App5();

        JFrame frame = new JFrame();

        frame.add(app5.getPanel1());

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
