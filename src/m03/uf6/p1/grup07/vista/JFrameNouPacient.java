/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import m03.uf6.p1.grup07.modelo.Pacient;

/**
 *
 * @author Christian
 */
public class JFrameNouPacient extends MouseAdapter {

    protected JFrame ventana;
    private JPanel pPrincipal;
    private JLabel titulo;
    private JLabel nomPacient;
    private JTextField nomPacientIntroduir;
    private JLabel cognom1;
    private JTextField cognom1Introduir;
    private JLabel cognom2;
    private JTextField cognom2Introduir;
    private JLabel segSocial;
    private JTextField segSocialIntroduir;
    private JLabel NIF;
    private JTextField NIFIntroduir;
    private JLabel telefon;
    private JTextField TelefonIntroduir;
    private JButton btnCrear;
    private JButton btnCancelar;
    private JPanel pButtons;

    public JFrameNouPacient() {
        System.out.println(UIManager.getSystemLookAndFeelClassName());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        ventana = new JFrame("Creacio nou Pacient");
        pPrincipal = new JPanel(new GridLayout(0, 1));
        titulo = new JLabel("Crear Pacient");
        nomPacient = new JLabel("Nom Pacient: ");
        nomPacientIntroduir = new JTextField();
        cognom1 = new JLabel("Cognom Pacient: ");
        cognom1Introduir = new JTextField();
        cognom2 = new JLabel("Segon cognom Pacient: ");
        cognom2Introduir = new JTextField();
        segSocial = new JLabel("Numero de seguretat social: ");
        segSocialIntroduir = new JTextField();
        NIF = new JLabel("NIF: ");
        NIFIntroduir = new JTextField();
        telefon = new JLabel("Telefon: ");
        TelefonIntroduir = new JTextField();
        btnCrear = new JButton("Crear pacient");
        btnCancelar = new JButton("Cancelar");
        pButtons = new JPanel(new FlowLayout());

        pPrincipal.add(titulo);
        titulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pPrincipal.add(nomPacient);
        pPrincipal.add(nomPacientIntroduir);
        pPrincipal.add(cognom1);
        pPrincipal.add(cognom1Introduir);
        pPrincipal.add(cognom2);
        pPrincipal.add(cognom2Introduir);
        pPrincipal.add(segSocial);
        pPrincipal.add(segSocialIntroduir);
        pPrincipal.add(NIF);
        pPrincipal.add(NIFIntroduir);
        pPrincipal.add(telefon);
        pPrincipal.add(TelefonIntroduir);

        pButtons.add(btnCancelar);
        pButtons.add(btnCrear);

        ventana.add(pButtons, BorderLayout.SOUTH);
        ventana.add(pPrincipal);
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCancelar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.setVisible(false);
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);
            }
        });

        btnCrear.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (nomPacientIntroduir.getText().length() == 0 || cognom1Introduir.getText().length() == 0 || cognom2Introduir.getText().length() == 0
                            || segSocialIntroduir.getText().length() == 0 || NIFIntroduir.getText().length() == 0 || TelefonIntroduir.getText().length() == 0) {
                        showMessageDialog(null, "Introduiex correctament les dades");

                    } else {
                        afegirPacient();
                    }
                } catch (ExcepcionsHospital ex) {
                    Logger.getLogger(JFrameNouPacient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }


    public void afegirPacient() throws ExcepcionsHospital {

        String nom = nomPacientIntroduir.getText();
        String cog = cognom1Introduir.getText();
        String cog2 = cognom2Introduir.getText();
        String numSs = segSocialIntroduir.getText();
        String nif = NIFIntroduir.getText();
        String telf = TelefonIntroduir.getText();

        Pacient pacient = new Pacient(nom, cog, cog2, numSs, nif, telf);
        boolean ok = Pacient.añadirPaciente(pacient);
        if (ok == true) {
            showMessageDialog(null, "Creat correcamtent");
            nomPacientIntroduir.setText("");
            cognom1Introduir.setText("");
            cognom2Introduir.setText("");
            segSocialIntroduir.setText("");
            NIFIntroduir.setText("");
            TelefonIntroduir.setText("");

        }
    }
}
