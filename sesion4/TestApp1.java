import javax.swing.*;

public class TestApp1 {

    public static void main(String[] args) {
        App1 app1 = new App1();

        JFrame frame = new JFrame();

        frame.add(app1.getPanel1());

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
