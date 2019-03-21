/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;

/**
 *
 * @author Christian
 */
public class JframeMenu extends MouseAdapter {

    protected JFrame ventanaMenu;
    private JPanel pPrincipal;
    private JLabel titulo;
    private JButton registrarVisita;
    private JButton btnNouPacient;
    private JButton btnBuscarPacient;
    private JButton btnMostrarHistorial;
    private JButton btnAñadirMalaltia;
    private JButton btnMostrarMalaltias;
    private JButton btnAñadirMedico;
    private JButton salir;
    public JframeMenu() {
        System.out.println(UIManager.getSystemLookAndFeelClassName());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        ventanaMenu = new JFrame("Menu Gestió Hospital");
        pPrincipal = new JPanel(new GridLayout(0, 1));
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titulo = new JLabel("Menu de Gestio Hospital");
        registrarVisita = new JButton("Registrar Visita");
        btnNouPacient = new JButton("Nou Pacient");
        btnBuscarPacient = new JButton("Buscar Pacient");
        btnMostrarHistorial = new JButton("Mostrar Historial");
        btnAñadirMalaltia = new JButton("Afegir malaltia");
        btnMostrarMalaltias = new JButton("Mostar malaltias");
        btnAñadirMedico = new JButton("Afegir metge");
        salir = new JButton("Salir");

        pPrincipal.add(titulo);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(registrarVisita);
        registrarVisita.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(btnNouPacient);
        btnNouPacient.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(btnBuscarPacient);
        btnBuscarPacient.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        btnMostrarHistorial.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(btnMostrarHistorial);
        btnMostrarHistorial.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(btnAñadirMalaltia);
        btnAñadirMalaltia.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(btnMostrarMalaltias);
        btnMostrarMalaltias.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(btnAñadirMedico);
        btnAñadirMedico.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.add(salir);
        salir.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ventanaMenu.add(pPrincipal);
        ventanaMenu.setLocationRelativeTo(null);
        ventanaMenu.pack();
        ventanaMenu.setVisible(true);
        ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registrarVisita.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JframeRegistrarVisita re = new JframeRegistrarVisita();
                re.ventana2.setVisible(true);
                ventanaMenu.setVisible(false);
            }
        });

        btnNouPacient.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JFrameNouPacient np = new JFrameNouPacient();
                np.ventana.setVisible(true);
                ventanaMenu.setVisible(false);
            }
        });

        btnBuscarPacient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrameBuscaPacient bp = new JFrameBuscaPacient();
                bp.buscaPacient();
                ventanaMenu.setVisible(false);

            }

        });

      
        btnAñadirMalaltia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JframeAñadirMalaltia ad = new JframeAñadirMalaltia();
                ad.JframeAñadirMalaltia();
                ventanaMenu.setVisible(false);
            }

        });
        btnMostrarMalaltias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JframeMostrarMalaltias ad = new JframeMostrarMalaltias();
                ad.JframeMostrarMalaltias();
                ventanaMenu.setVisible(false);
            }

        });
        btnAñadirMedico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JframeAñadirMedico ad;
                    ad = new JframeAñadirMedico();
                    ad.JframeAñadirMedico();
                    ventanaMenu.setVisible(false);
            }

        });
        btnMostrarHistorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrameMostrarHistorial ad;
                ad = new JFrameMostrarHistorial();
                ad.JFrameMostrarHistorial();
                ventanaMenu.setVisible(false);
            }

        });
        salir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);

            }
        });

    }

    public void agregarFrame(JFrame j) {
        ventanaMenu = j;
    }

    public static void main(String[] args) {
        new JframeMenu();
    }
}
