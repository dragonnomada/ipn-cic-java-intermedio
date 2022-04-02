import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMenus {
    private JPanel panel1;
    // 1. Generar un JMenuBar
    private JMenuBar menuBar1;

    public AppMenus() {
        // 2. Inicializar el JMenuBar
        menuBar1 = new JMenuBar();

        // 3. Crear menús e items
        JMenu menu1 = new JMenu("Menu 1");

        JMenu item1 = new JMenu("Item 1");
        JMenuItem item1_1 = new JMenuItem("Item 1.1");
        JMenuItem item2 = new JMenuItem("Item 2");

        // 4. Agregar los items dentro de menús u otros items
        item1.add(item1_1);
        menu1.add(item1);
        menu1.add(item2);

        // 5. Agregar los menús dentro de la barra de menús
        menuBar1.add(menu1);

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(item2,
                        "Se ha pulsado el item 2",
                        "Item 2",
                        JOptionPane.INFORMATION_MESSAGE
                    );
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    // 6. Publicamos la barra de menús con un Getter
    public JMenuBar getMenuBar1() {
        return menuBar1;
    }
}
