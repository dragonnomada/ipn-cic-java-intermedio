import javax.swing.*;

public class TestUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        JButton button = new JButton("Hola mundo");

        panel.add(button);

        frame.add(panel);

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
