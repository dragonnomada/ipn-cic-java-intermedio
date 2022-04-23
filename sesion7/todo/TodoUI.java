package todo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoUI extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton agregarButton;
    private JTable table1;

    private TodoDB db;

    public TodoUI() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        this.db = new TodoDB();

        this.add(panel1);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.actualizarTodos();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = textField1.getText();

                if (titulo.length() == 0) {
                    JOptionPane.showMessageDialog(panel1, "No se puede poner un TODO vacío", "Error al agregar el TODO", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    db.agregarTodo(titulo);
                    textField1.setText("");
                    actualizarTodos();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (table1.getSelectedRow() >= 0 && !e.getValueIsAdjusting()) {
                    if (table1.getSelectedColumn() == 2) {
                        int id = (Integer) table1.getModel().getValueAt(table1.getSelectedRow(), 0);
                        String titulo = (String) table1.getModel().getValueAt(table1.getSelectedRow(), 1);
                        boolean completado = (Boolean) table1.getModel().getValueAt(table1.getSelectedRow(), 2);
                        System.out.println(new Todo(id, titulo, completado));
                        try {
                            // TODO: Bloquear la interfaz
                            db.completarTodo(id, completado);
                            // TODO: Desbloquear la interfaz
                            actualizarTodos();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        table1.getSelectionModel().clearSelection();
                    }
                }
            }
        });
    }

    public void actualizarTodos() {
        ArrayList<Todo> todos = null;

        try {
            todos = db.obtenerTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (todos != null) {

            DefaultTableModel model = new DefaultTableModel(null, new String[] { "ID", "Título", "Completado" });

            for (Todo todo : todos) {
                model.addRow(new Object[] { todo.getId(), todo.getTitulo(), todo.isCompletado() });
            }

            table1.setModel(model);

        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        TodoUI todoApp = new TodoUI();

    }

    private void createUIComponents() {
        table1 = new JTable() {

            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
    }
}
