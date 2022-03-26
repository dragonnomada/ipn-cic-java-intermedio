import javax.swing.*;

public class TestApp4 {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        App4 app4 = new App4();

        frame.add(app4.getPanel1());

        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
