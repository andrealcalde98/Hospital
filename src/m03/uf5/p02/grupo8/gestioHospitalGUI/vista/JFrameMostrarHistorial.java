package m03.uf5.p02.grupo8.gestioHospitalGUI.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;
import static m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.GestioHospital.MostrarHistorial;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.*;

public class JFrameMostrarHistorial {

    private JFrame ventana;
    private JPanel pCampos;
    private JLabel buscaID;
    private JTextField introID;
    private JPanel pButtons;
    private JButton buscar;
    private JButton salir;
    private JTable table;
    
    public void JFrameMostrarHistorial() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        ventana = new JFrame("Mostrar Historial");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        pButtons = new JPanel(new FlowLayout());
        pCampos = new JPanel(new GridLayout(1, 1));
        JPanel pPrincipal = new JPanel();

        buscaID = new JLabel("Introduce el numero de historial");
        introID = new JTextField();

        buscar = new JButton("Buscar");
        JButton salir = new JButton("Salir");
        pCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pCampos.add(buscaID);
        pCampos.add(introID);
        pButtons.add(buscar);
        pButtons.add(salir);
        ArrayList<MostrarHistorial> mostrar = new ArrayList();

        Object data[][] = new String[0][7];
        String columnNames[] = new String[]{"Codi", "NIF", "Nom Metge", "Cognom Metge", "Segon Cognom Metge", "Data", "Nom Malaltia"};

        for (int i = 0; i < data.length; i++) {
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = "";
            data[i][4] = "";
            data[i][5] = "";
            data[i][6] = "";
        }
        
        table = new JTable(data, columnNames);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        JScrollPane pane = new JScrollPane(table);
        pPrincipal.add(pane);

        ventana.add(pCampos, BorderLayout.NORTH);
        ventana.add(pButtons, BorderLayout.SOUTH);
        ventana.add(pPrincipal, BorderLayout.CENTER);
        ventana.pack();
        ventana.setVisible(true);

        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.setVisible(false);
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);
            }

        });

        buscar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (introID.getText().length() == 0) {
                    showMessageDialog(null, "Introdueix el codi de pacient");
                }

                table.remove(pane);
                pPrincipal.remove(pane);

                ArrayList<MostrarHistorial> mostrar = new ArrayList();
                try {
                    mostrar = MostrarHistorial.leerHistorial();
                } catch (FileNotFoundException | ExcepcionsHospital ex) {
                    Logger.getLogger(JFrameMostrarHistorial.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error" + ex.getMessage());
                }
                int id = Integer.parseInt(introID.getText());
                Object data[][] = new String[mostrar.size()][7];
                for (int i = 0; i < mostrar.size(); i++) {
                    if (mostrar.get(i).getCodi() == id) {
                        for (int j = 0; j < mostrar.size(); j++) {
                            data[j][0] = Integer.toString(mostrar.get(i).getCodi());
                            data[j][1] = mostrar.get(i).getNif();
                            data[j][2] = mostrar.get(i).getNomMetge();
                            data[j][3] = mostrar.get(i).getCogMetge();
                            data[j][4] = mostrar.get(i).getCog2Metge();
                            data[j][5] = mostrar.get(i).getFecha();
                            data[j][6] = mostrar.get(i).getNomMalaltia();
                        }
                    }
                }

                table = new JTable(data, columnNames);
                table.getTableHeader().setReorderingAllowed(false);
                table.setEnabled(false);
                JScrollPane pane = new JScrollPane(table);
                pPrincipal.remove(pane);
                pPrincipal.add(pane);
                ventana.pack();
                ventana.setVisible(true);
            }
        });

    }

}
