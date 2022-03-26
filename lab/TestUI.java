import javax.swing.*;

public class TestUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DemoUI demoUI = new DemoUI();

        frame.add(demoUI.getMainPanel());

        frame.setVisible(true);

    }

}
