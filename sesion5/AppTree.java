import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class AppTree {
    private JTree tree1;
    public JPanel panel1;

    public AppTree() {
        DefaultMutableTreeNode nodeRoot = new DefaultMutableTreeNode("Raíz");

        DefaultTreeModel model = new DefaultTreeModel(nodeRoot);

        DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode nodeB = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("C");

        model.insertNodeInto(nodeA, nodeRoot, 0);
        model.insertNodeInto(nodeB, nodeRoot, 1);
        model.insertNodeInto(nodeC, nodeRoot, 2);

        tree1.setModel(model);

        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

            }
        });
    }
}
