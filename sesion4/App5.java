import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class App5 {
    private JButton button1;
    private JTextField textField1;
    private JProgressBar progressBar1;
    private JButton button2;
    private JSlider slider1;
    private JLabel label1;
    private JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    public App5() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recupera el texto del TextField 1
                String texto = textField1.getText();
                // Ajusta el texto del Label 1
                label1.setText(texto);
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider1.getValue();
                progressBar1.setValue(value);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (slider1.isEnabled()) {
                    slider1.setEnabled(false);
                    button2.setText("Desbloquear");
                } else {
                    slider1.setEnabled(true);
                    button2.setText("Bloquear");
                }
            }
        });
    }
}
