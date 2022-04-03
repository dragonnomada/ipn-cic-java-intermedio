import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoCliente {
    private JTextField textField1;
    private JTextField textField2;
    private JButton agregarButton;
    private JPanel panel1;
    private JFrame frame;

    public NuevoCliente(AppSistemaClientesProductos app) {
        frame = new JFrame();
        frame.add(panel1);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.crearCliente(textField1.getText(), textField2.getText());
                frame.dispose();
            }
        });
    }
}
