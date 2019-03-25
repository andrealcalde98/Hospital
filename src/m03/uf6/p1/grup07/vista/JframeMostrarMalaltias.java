package m03.uf6.p1.grup07.vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import m03.uf6.p1.grup07.modelo.ExcepcionsHospital;
import m03.uf6.p1.grup07.modelo.Malaltia;

public class JframeMostrarMalaltias extends JFrame {

    JButton salir = new JButton("Salir");

    public void JframeMostrarMalaltias() {
        mostrarMalatia();
    }

    public void mostrarMalatia() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Mostrar malaltias");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        JPanel pPrincipal = new JPanel();

        ArrayList<Malaltia> malaltia = new ArrayList();

        try {
            malaltia = Malaltia.leerMalaltias();
        } catch (FileNotFoundException | ExcepcionsHospital ex) {
            Logger.getLogger(JframeMostrarMalaltias.class.getName()).log(Level.SEVERE, null, ex);
        }

        String columnNames[] = new String[]{"Codi", "Nom", "Tractament", "Causa Baixa", "Durada Tractament"};

        Object data[][] = new String[malaltia.size()][5];

        for (int i = 0; i < data.length; i++) {

            data[i][0] = Integer.toString(malaltia.get(i).getCodi());
            data[i][1] = malaltia.get(i).getNom();
            data[i][2] = malaltia.get(i).getTracatament();
            data[i][3] = Boolean.toString(malaltia.get(i).getCausaBaixa());
            data[i][4] = malaltia.get(i).getduradaTractament();

        }
        salir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.setVisible(false);
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);
            }
        });
        JTable table = new JTable(data, columnNames);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        JScrollPane pane = new JScrollPane(table);

        pPrincipal.add(pane);
        pPrincipal.add(salir);
        ventana.add(pPrincipal);
        ventana.pack();
        ventana.setVisible(true);

    }

}
