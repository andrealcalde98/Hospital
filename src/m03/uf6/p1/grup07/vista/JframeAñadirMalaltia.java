/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.vista;

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
import javax.swing.JTextField;
import javax.swing.UIManager;
import m03.uf6.p1.grup07.modelo.ExcepcionsHospital;
import m03.uf6.p1.grup07.modelo.Malaltia;

/**
 *
 * @author Albert
 */
public class JframeAñadirMalaltia {

    JButton afegir = new JButton("Afegir");
    JButton salir = new JButton("Salir");
    JLabel codi = new JLabel("Codi");
    JTextField mostrarCodi = new JTextField();
    JLabel nom = new JLabel("Nom");
    JTextField mostrarNom = new JTextField();
    JLabel tractament = new JLabel("Tractament");
    JTextField mostrarTractament = new JTextField();
    JLabel baixa = new JLabel("Cusa baixa (true/false)");
    JTextField mostrarBaixa = new JTextField();
    JLabel duradaTractament = new JLabel("Durada Tractament");
    JTextField mostrarDuradaTractament = new JTextField();

    public void JframeAñadirMalaltia() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Afegir malaltia");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        JPanel pPrincipal = new JPanel();
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        pPrincipal.setLayout(new GridLayout(0, 1));
        pPrincipal.add(codi);
        pPrincipal.add(mostrarCodi);
        pPrincipal.add(nom);
        pPrincipal.add(mostrarNom);
        pPrincipal.add(tractament);
        pPrincipal.add(mostrarTractament);
        pPrincipal.add(baixa);
        pPrincipal.add(mostrarBaixa);
        pPrincipal.add(duradaTractament);
        pPrincipal.add(mostrarDuradaTractament);
        pPrincipal.add(afegir);
        pPrincipal.add(salir);
        ventana.add(pPrincipal);
        ventana.pack();
        ventana.setVisible(true);
        mostrarCodi.setEditable(false);
        mostrarCodi.setText(Integer.toString(buscaID()));

        salir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.setVisible(false);
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);

            }
        });

        afegir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                afegirMalaltias();
            }
        });

    }

    public void afegirMalaltias() {
        try {
            int a = buscaID();
            int codi = a;
            String nom = mostrarNom.getText();
            String tractament = mostrarTractament.getText();
            String durada = mostrarDuradaTractament.getText();
            Boolean baixa = Boolean.valueOf(mostrarBaixa.getText());
            Malaltia mal = new Malaltia(codi, nom, tractament, baixa, durada);

            boolean creado = Malaltia.escribirMalaltias(mal);
            if (creado == true) {
                showMessageDialog(null, "Creado correcamtent");

            }
        } catch (FileNotFoundException | ExcepcionsHospital ex) {
            Logger.getLogger(JframeAñadirMalaltia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int buscaID() {
        ArrayList<Malaltia> malaltia = new ArrayList();

        try {
            malaltia = Malaltia.leerMalaltias();
            int a = malaltia.size();
            return a + 1;
        } catch (FileNotFoundException | ExcepcionsHospital ex) {
            Logger.getLogger(JframeAñadirMalaltia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return malaltia.size() + 1;

    }
}
