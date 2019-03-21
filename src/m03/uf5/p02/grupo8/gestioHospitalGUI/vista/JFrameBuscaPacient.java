/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.GestioHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Pacient;

/**
 *
 * @author Albert
 */
public final class JFrameBuscaPacient {

    JFrame ventanaBuscaPacient;
    JButton buscar = new JButton("Buscar");
    JButton salir = new JButton("Salir");
    JButton borrar = new JButton("Borrar datos");
    JLabel nombre = new JLabel("Nombre");
    JTextField mostrarNombre = new JTextField();
    JLabel apellido = new JLabel("Cognom");
    JTextField mostrarApellido = new JTextField();
    JLabel segApellido = new JLabel("Segon Cognom");
    JTextField mostrarSegApellido = new JTextField();
    JLabel ss = new JLabel("Numero de la Seguretat Social");
    JTextField mostrarSs = new JTextField();
    JLabel nif = new JLabel("NIF");
    JTextField mostrarNif = new JTextField();
    JLabel telefon = new JLabel("Telefon");
    JTextField mostrarTelefon = new JTextField();
    JLabel buscaNif = new JLabel("NIF");
    JTextField txtBuscaNif = new JTextField();
    JLabel buscaNombre = new JLabel("Buscar per : ");
    JLabel buscaSs = new JLabel("Seguretat social");
    JTextField txtBuscaSs = new JTextField();

    public void buscaPacient() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        ventanaBuscaPacient = new JFrame("Buscar pacient");
        ventanaBuscaPacient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaBuscaPacient.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JPanel pBusqueda = new JPanel();
        JPanel pPrincipal = new JPanel();

        pBusqueda.setLayout(new GridLayout(1, 1));

        pPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pPrincipal.setLayout(new GridLayout(0, 1));

        pBusqueda.add(buscaNombre);
        pBusqueda.add(buscaSs);
        pBusqueda.add(txtBuscaSs);
        pBusqueda.add(buscaNif);
        pBusqueda.add(txtBuscaNif);

        pPrincipal.add(pBusqueda);

        mostrarNombre.setEditable(false);
        mostrarApellido.setEditable(false);
        mostrarSegApellido.setEditable(false);
        mostrarSs.setEditable(false);
        mostrarNif.setEditable(false);
        mostrarTelefon.setEditable(false);

        pPrincipal.add(nombre);
        pPrincipal.add(mostrarNombre);
        pPrincipal.add(apellido);
        pPrincipal.add(mostrarApellido);
        pPrincipal.add(segApellido);
        pPrincipal.add(mostrarSegApellido);
        pPrincipal.add(ss);
        pPrincipal.add(mostrarSs);
        pPrincipal.add(nif);
        pPrincipal.add(mostrarNif);
        pPrincipal.add(telefon);
        pPrincipal.add(mostrarTelefon);

        panel.add(buscar);
        panel.add(borrar);
        panel.add(salir);
        pPrincipal.add(panel);
        ventanaBuscaPacient.add(pPrincipal);
        ventanaBuscaPacient.pack();

        ventanaBuscaPacient.setVisible(true);

        salir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);
                ventanaBuscaPacient.setVisible(false);
            }
        });

        buscar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent a) {
                buscarPaciente();
            }
        });
        borrar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent a) {
                mostrarNombre.setText("");
                mostrarApellido.setText("");
                mostrarSegApellido.setText("");
                mostrarSs.setText("");
                mostrarNif.setText("");
                mostrarTelefon.setText("");
                txtBuscaNif.setText("");
                txtBuscaSs.setText("");
            }
        });

    }

    public void buscarPaciente() {
        ArrayList<Pacient> pacientes = new ArrayList();
        try {
            pacientes = Pacient.obtenerPacientes();

        } catch (FileNotFoundException | ExcepcionsHospital ex) {
        }

        if (txtBuscaNif.getText().length() > 0) {
            String nif = txtBuscaNif.getText();
            int pa = GestioHospital.buscarPacient(pacientes, 1, nif);
            if (pa == -1) {
                showMessageDialog(null, "Introdueix  correctament les dades 1 ");
            } else {
                mostrarNombre.setText(pacientes.get(pa).getnom());
                mostrarApellido.setText(pacientes.get(pa).getcognom1());
                mostrarSegApellido.setText(pacientes.get(pa).getcognom2());
                mostrarSs.setText(pacientes.get(pa).getnumSegSocial());
                mostrarNif.setText(pacientes.get(pa).getNIF());
                mostrarTelefon.setText(pacientes.get(pa).gettelefon());
            }
        }
        if (txtBuscaSs.getText().length() > 0) {
            String ss = txtBuscaSs.getText();
            int pac = GestioHospital.buscarPacient(pacientes, 2, ss);
            if (pac == -1) {
                showMessageDialog(null, "Introdueix  correctament les dades 2");

            } else {
                mostrarNombre.setText(pacientes.get(pac).getnom());
                mostrarApellido.setText(pacientes.get(pac).getcognom1());
                mostrarSegApellido.setText(pacientes.get(pac).getcognom2());
                mostrarSs.setText(pacientes.get(pac).getnumSegSocial());
                mostrarNif.setText(pacientes.get(pac).getNIF());
                mostrarTelefon.setText(pacientes.get(pac).gettelefon());

            }
        }

    }
}
