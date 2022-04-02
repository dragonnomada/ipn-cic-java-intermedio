import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class AppTreeClientes {
    private JTree tree1;
    public JPanel panel1;

    public AppTreeClientes() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Cliente");

        DefaultTreeModel model = new DefaultTreeModel(root);

        DefaultMutableTreeNode nodeInformacionCliente = new DefaultMutableTreeNode("Información");
        DefaultMutableTreeNode nodeReservacionesCliente = new DefaultMutableTreeNode("Reservaciones");
        DefaultMutableTreeNode nodeReportesCliente = new DefaultMutableTreeNode("Reportes");

        DefaultMutableTreeNode nodeReservacion1 = new DefaultMutableTreeNode("Reservación 1");
        DefaultMutableTreeNode nodeReservacion2 = new DefaultMutableTreeNode("Reservación 2");
        DefaultMutableTreeNode nodeReservacion3 = new DefaultMutableTreeNode("Reservación 3");
        DefaultMutableTreeNode nodeReservacion4 = new DefaultMutableTreeNode("Reservación 4");

        DefaultMutableTreeNode nodeReporte1 = new DefaultMutableTreeNode("Reporte 1");
        DefaultMutableTreeNode nodeReporte2 = new DefaultMutableTreeNode("Reporte 2");

        model.insertNodeInto(nodeInformacionCliente, root, 0);
        model.insertNodeInto(nodeReservacionesCliente, root, 1);
        model.insertNodeInto(nodeReportesCliente, root, 2);

        model.insertNodeInto(nodeReservacion1, nodeReservacionesCliente, 0);
        model.insertNodeInto(nodeReservacion2, nodeReservacionesCliente, 1);
        model.insertNodeInto(nodeReservacion3, nodeReservacionesCliente, 2);
        model.insertNodeInto(nodeReservacion4, nodeReservacionesCliente, 3);

        model.insertNodeInto(nodeReporte1, nodeReportesCliente, 0);
        model.insertNodeInto(nodeReporte2, nodeReportesCliente, 1);

        tree1.setModel(model);

        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println(e.getPath());
                System.out.println(tree1.getLastSelectedPathComponent());
            }
        });
    }
}
