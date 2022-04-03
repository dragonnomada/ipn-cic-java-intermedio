import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarCliente {
    private JTextField textField1;
    private JTextField textField2;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JPanel panel1;
    private JLabel label1;

    JFrame frame;

    public EditarCliente(AppSistemaClientesProductos app, Cliente cliente) {
        frame = new JFrame();

        frame.add(panel1);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        label1.setText(String.valueOf(cliente.getId()));
        textField1.setText(cliente.getNombre());
        textField2.setText(cliente.getTelefono());

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.editarCliente(cliente, textField1.getText(), textField2.getText());
                frame.dispose();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.eliminarCliente(cliente);
                frame.dispose();
            }
        });

    }

}
