package repaso;

import javax.swing.*;

public class TestApp2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        //JPanel panel = new JPanel();

        JButton button = new JButton("Hola pulsame");

        //panel.add(button);

        frame.add(button);

        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
