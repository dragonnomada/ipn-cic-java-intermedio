import javax.swing.*;

public class TestApp6 {

    public static void main(String[] args) {

        App6 app6 = new App6();

        JFrame frame = new JFrame();

        frame.add(app6.getPanel1());

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
