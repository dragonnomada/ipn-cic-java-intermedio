import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class App6 {
    private JPanel panel1;
    private JTextField textField1;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JButton agregarButton;
    private JTable table1;

    public App6() {
        String[] columns = new String[] { "Nombre", "Edad", "Género"};

        DefaultTableModel model = new DefaultTableModel(null, columns);

        table1.setModel(model);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                int edad = (Integer) spinner1.getValue();
                String genero = (String) comboBox1.getSelectedItem();
                model.addRow(new Object[] { nombre, edad, genero });
                System.out.printf("Agregado: %s %d %s\n", nombre, edad, genero);
                textField1.setText("");
                spinner1.setValue(18);
                comboBox1.setSelectedIndex(0);
            }
        });

        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table1.getSelectedRow();
                    String nombre = (String) table1.getValueAt(row, 0);
                    int edad = (Integer) table1.getValueAt(row, 1);
                    String genero = (String) table1.getValueAt(row, 2);
                    System.out.printf("Seleccionado: %s %d %s\n", nombre, edad, genero);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        comboBox1 = new JComboBox<>(new Object[] { "Hombre", "Mujer" });
    }
}
