/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.vista;

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
import javax.swing.UnsupportedLookAndFeelException;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Metge;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Pacient;

public class JframeAñadirMedico {

    /*iString nom, String cognom1, String cognom2, String numSegSocial, String NIF, String telefon,
            int numEmpleat, int salariMensual, String CodiCompteCorrent ;
     */
    private JButton afegir = new JButton("Afegir");
    private JButton salir = new JButton("Salir");

    private JLabel nom = new JLabel("Nom");
    private JTextField mostrarNom = new JTextField();
    private JLabel cog = new JLabel("Cognom");
    private JTextField mostrarCog = new JTextField();
    private JLabel cog2 = new JLabel("Segon cognom");
    private JTextField mostrarSegCog = new JTextField();
    private JLabel ss = new JLabel("Numero de la seguretat Social");
    private JTextField mostrarSs = new JTextField();
    private JLabel nif = new JLabel("NIF");
    private JTextField mostrarNif = new JTextField();
    private JLabel telf = new JLabel("Telefon");
    private JTextField mostrarTelf = new JTextField();
    private JLabel codiEmpleat = new JLabel("Numero de empleat");
    private JTextField mostrarCodiEmpleat = new JTextField();
    private JLabel salariMensual = new JLabel("Salari Menusal");
    private JTextField mostrarSalariMensual = new JTextField();
    private JLabel compte = new JLabel("Codi Compte corrent");
    private JTextField mostrarCompte = new JTextField();

    public void JframeAñadirMedico() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Afegir metge");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        JPanel pPrincipal = new JPanel();
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        pPrincipal.setLayout(new GridLayout(0, 1));

        pPrincipal.add(nom);
        pPrincipal.add(mostrarNom);
        pPrincipal.add(cog);
        pPrincipal.add(mostrarCog);
        pPrincipal.add(cog2);
        pPrincipal.add(mostrarSegCog);
        pPrincipal.add(ss);
        pPrincipal.add(mostrarSs);
        pPrincipal.add(nif);
        pPrincipal.add(mostrarNif);
        pPrincipal.add(telf);
        pPrincipal.add(mostrarTelf);
        pPrincipal.add(salariMensual);
        pPrincipal.add(mostrarSalariMensual);
        pPrincipal.add(codiEmpleat);
        pPrincipal.add(mostrarCodiEmpleat);
        pPrincipal.add(compte);
        pPrincipal.add(mostrarCompte);

        pPrincipal.add(afegir);
        pPrincipal.add(salir);

        ventana.add(pPrincipal);
        ventana.pack();
        ventana.setVisible(true);

        afegir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    if (mostrarNom.getText().length() == 0 || mostrarCog.getText().length() == 0 || mostrarSegCog.getText().length() == 0
                            || mostrarSs.getText().length() == 0 || mostrarNif.getText().length() == 0 || mostrarTelf.getText().length() == 0
                            || mostrarSalariMensual.getText().length() == 0) {
                        showMessageDialog(null, "Error al introduir les dades ");
                    } else {
                        afegirMetge();
                    }
                } catch (ExcepcionsHospital | FileNotFoundException ex) {
                    Logger.getLogger(JframeAñadirMedico.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        salir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.setVisible(false);
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);
            }
        });
    }

    public void afegirMetge() throws ExcepcionsHospital, FileNotFoundException {

        String nom = mostrarNom.getText();
        String cog = mostrarCog.getText();
        String cog2 = mostrarSegCog.getText();
        String ss = mostrarSs.getText();
        String nif = mostrarNif.getText();
        String telf = mostrarTelf.getText();
        int codEmpleat = Integer.parseInt(mostrarCodiEmpleat.getText());
        int salari = Integer.parseInt(mostrarSalariMensual.getText());
        String compte = mostrarCompte.getText();

        Metge metge = new Metge(nom, cog, cog2, ss, nif, telf, codEmpleat, salari, compte);
        boolean ok = Metge.añadirMetge(metge);

        if (ok == true) {
            showMessageDialog(null, "Creado correcamtent");
            mostrarNom.setText("");
            mostrarCog.setText("");
            mostrarSegCog.setText("");
            mostrarSs.setText("");
            mostrarNif.setText("");
            mostrarTelf.setText("");
            mostrarCodiEmpleat.setText("");
            mostrarSalariMensual.setText("");
            mostrarCompte.setText("");
        }
    }

}
