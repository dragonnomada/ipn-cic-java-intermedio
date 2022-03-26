import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoUI {
    private JPanel mainPanel;
    private JButton button1;
    private JLabel label1;

    public DemoUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Hi");
            }
        });
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
