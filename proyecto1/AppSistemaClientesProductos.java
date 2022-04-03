import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppSistemaClientesProductos {
    private JTable table1;
    private JTable table2;
    private JTree tree1;
    private JTree tree2;
    private JPanel panel1;
    private JMenuBar menuBar1;
    private JFrame frame;

    ArrayList<Cliente> clientes = new ArrayList<>();

    public AppSistemaClientesProductos() {
        AppSistemaClientesProductos app = this;

        menuBar1 = new JMenuBar();

        JMenu menuClientes = new JMenu("Clientes");
        JMenuItem menuItemNuevoCliente = new JMenuItem("Nuevo Cliente");
        menuItemNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoCliente nuevoCliente = new NuevoCliente(app);
            }
        });
        menuClientes.add(menuItemNuevoCliente);
        menuBar1.add(menuClientes);

        JMenu menuProductos = new JMenu("Productos");
        JMenuItem menuItemNuevoProducto = new JMenuItem("Nuevo Producto");
        menuProductos.add(menuItemNuevoProducto);
        menuBar1.add(menuProductos);

        frame = new JFrame();

        frame.setJMenuBar(menuBar1);
        frame.add(panel1);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object object = tree1.getLastSelectedPathComponent();
                if (object instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) object;
                    if (treeNode.getUserObject() instanceof Cliente) {
                        Cliente cliente = (Cliente) treeNode.getUserObject();
                        System.out.println(cliente);
                        EditarCliente editarCliente = new EditarCliente(app, cliente);
                    }
                }
            }
        });

        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    if (table1.getSelectedRow() >= 0 && table1.getSelectedColumn() >= 0) {
                        int id = (Integer) table1.getValueAt(table1.getSelectedRow(), table1.getSelectedColumn());
                        //System.out.println(id);
                        for (Cliente cliente : clientes) {
                            if (cliente.getId() == id) {
                                System.out.println(cliente);
                                EditarCliente editarCliente = new EditarCliente(app, cliente);
                            }
                        }
                    }
                }
            }
        });
    }

    public void crearCliente(String nombre, String telefono) {
        int id = clientes.size() + 1;
        Cliente cliente = new Cliente(id, nombre, telefono);
        clientes.add(cliente);

        actualizarTablaClientes();
        actualizarArbolClientes();
    }

    public void actualizarTablaClientes() {
        DefaultTableModel tableModel = new DefaultTableModel(null, new String[] { "Id", "Nombre", "Teléfono" });

        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[] { cliente.getId(), cliente.getNombre(), cliente.getTelefono() });
        }

        table1.setModel(tableModel);
        table1.setDefaultEditor(Object.class, null);
    }

    public void actualizarArbolClientes() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Clientes");

        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        int i = 0;
        for (Cliente cliente : clientes) {
            DefaultMutableTreeNode nodeCliente = new DefaultMutableTreeNode(cliente);
            treeModel.insertNodeInto(nodeCliente, root, i++);
        }

        tree1.setModel(treeModel);
    }

    public void editarCliente(Cliente cliente, String nombre, String telefono) {
        int index = clientes.indexOf(cliente);

        if (index >= 0) {
            clientes.set(index, new Cliente(cliente.getId(), nombre, telefono));
        }

        actualizarTablaClientes();
        actualizarArbolClientes();
    }

    public void eliminarCliente(Cliente cliente) {
        int index = clientes.indexOf(cliente);

        if (index >= 0) {
            clientes.remove(index);
        }

        actualizarTablaClientes();
        actualizarArbolClientes();
    }

    public static void main(String[] args) {
        AppSistemaClientesProductos app = new AppSistemaClientesProductos();
    }

}
