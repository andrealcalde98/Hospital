/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
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
import m03.uf5.p02.grupo8.gestioHospitalGUI.controlador.LeerEscribirVisita;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.GestioHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Historial;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Malaltia;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Metge;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Pacient;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Visita;

/**
 *
 * @author Christian
 */
public class JframeRegistrarVisita {

    protected JFrame ventana2;
    private JPanel pBuscarPacient;
    private JPanel pMetge;
    private JPanel pPacient;
    private JPanel pButtons;
    private JPanel pBuscar;
    private JPanel pMalaltia;
    private JLabel lblFecha;
    private JTextField txtFfecha;
    private JLabel lblHora;
    private JTextField txtFhora;
    private JLabel lblnom;
    private JTextField txtFnom;
    private JLabel lblcognom1;
    private JTextField txtFcognom1;
    private JLabel lblcognom2;
    private JTextField txtFcognom2;
    private JLabel lblSegSocial;
    private JTextField txtFsegSocial;
    private JLabel lblTelefono;
    private JTextField txtFtelefono;
    private JLabel lblBuscarPerPacient;
    private JLabel lblBuscarNifPacient;
    private JTextField txtFbuscarNifPacient;
    private JLabel lblBuscarSegSocialPacient;
    private JTextField txtFbuscarSegSocialPacient;
    private JLabel lblBuscarPerMetge;
    private JLabel tituloPacient;
    private JLabel tituloMetge;
    private JLabel lblBuscarCognomMetge;
    private JTextField txtFBuscarCognomMetge;
    private JLabel lblBuscarCodiMetge;
    private JTextField txtFBuscarCodiMetge;
    private JLabel lblBuscarNomMetge;
    private JTextField txtFbuscarNomMetge;
    private JButton btnBuscar;
    private JButton btnCancelar;
    private JLabel lblnomMetge;
    private JTextField txtFnomMetge;
    private JLabel lblCognom1Metge;
    private JTextField txtFCognom1Metge;
    private JLabel lblCognom2Metge;
    private JTextField txtFCognom2Metge;
    private JLabel lblSegSocialMetge;
    private JTextField txtFSegSocialMetge;
    private JLabel lblTelefonoMetge;
    private JTextField txtFTelefonoMetge;
    private JLabel lblNumEmpleatMetge;
    private JTextField txtFNumEmpleatMetge;
    private JLabel lblNumSalariMensual;
    private JTextField txtFSalariMensual;
    private JLabel lblCodiCompte;
    private JTextField txtFCodiCompte;
    private JButton btnVisita;
    private JLabel tituloBuscarPerMalaltia;
    private JLabel lblbuscarMalaltia;
    private JTextField txtFbuscarMalaltia;
    private JLabel lblCodiMalaltia;
    private JTextField txtFcodiMalaltia;
    private JLabel lblNomMalaltia;
    private JTextField txtFnomMalaltia;
    private JLabel lblTractamentMalaltia;
    private JTextField txtFtractamentMalaltia;
    private JLabel lblCausaMalaltia;
    private JTextField txtFcausaMalaltia;
    private JLabel lblDuradaMalaltia;
    private JTextField txtFduradaMalaltia;

    public JframeRegistrarVisita() {
        System.out.println(UIManager.getSystemLookAndFeelClassName());
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        ventana2 = new JFrame("Menu Registrar Visita");
        pBuscarPacient = new JPanel(new GridLayout(0, 1));
        pBuscar = new JPanel(new GridLayout(0, 1));
        pPacient = new JPanel(new GridLayout(0, 1));
        pMetge = new JPanel(new GridLayout(0, 1));
        pMalaltia = new JPanel(new GridLayout(1, 1));
        lblCodiMalaltia = new JLabel("Codi Malaltia");
        txtFcodiMalaltia = new JTextField();
        lblNomMalaltia = new JLabel("Nom Malaltia");
        txtFnomMalaltia = new JTextField();
        lblTractamentMalaltia = new JLabel("Tractament");
        txtFtractamentMalaltia = new JTextField();
        lblCausaMalaltia = new JLabel("Causa Malaltia");
        txtFcausaMalaltia = new JTextField();
        lblDuradaMalaltia = new JLabel("Durada Malaltia");
        txtFduradaMalaltia = new JTextField();

        pButtons = new JPanel(new FlowLayout());
        btnVisita = new JButton("Registrar Visita");
        tituloPacient = new JLabel("INFORMACIO PACIENT");
        tituloBuscarPerMalaltia = new JLabel("BUSCAR PER MALALTIA");
        tituloBuscarPerMalaltia.setBorder(BorderFactory.createLineBorder(Color.RED));
        tituloMetge = new JLabel("INFORMACIO METGE");
        tituloPacient.setBorder(BorderFactory.createLineBorder(Color.RED));
        tituloMetge.setBorder(BorderFactory.createLineBorder(Color.RED));
        lblBuscarPerMetge = new JLabel("BUSCAR PER METGE");
        lblBuscarPerMetge.setBorder(BorderFactory.createLineBorder(Color.RED));
        lblBuscarNomMetge = new JLabel("Buscar Nom Metge: ");
        txtFbuscarNomMetge = new JTextField();
        lblBuscarCognomMetge = new JLabel("Buscar Cognom Metge:");
        txtFBuscarCognomMetge = new JTextField();
        lblBuscarCodiMetge = new JLabel("Buscar Codi Metge:");
        txtFBuscarCodiMetge = new JTextField();
        lblBuscarPerPacient = new JLabel("BUSCAR PER PACIENT");
        lblBuscarPerPacient.setBorder(BorderFactory.createLineBorder(Color.RED));
        lblBuscarNifPacient = new JLabel("Buscar per NIF:");
        txtFbuscarNifPacient = new JTextField();
        lblBuscarSegSocialPacient = new JLabel("Buscar per Seguretat Social:");
        txtFbuscarSegSocialPacient = new JTextField();
        lblnomMetge = new JLabel("Nom Metge:");
        txtFnomMetge = new JTextField();
        lblbuscarMalaltia = new JLabel("Nom Malaltia");
        txtFbuscarMalaltia = new JTextField();
        lblCognom1Metge = new JLabel("Primer Cognom Metge:");
        txtFCognom1Metge = new JTextField();
        lblCognom2Metge = new JLabel("Segon Cognom Metge:");
        txtFCognom2Metge = new JTextField();
        lblSegSocialMetge = new JLabel("Numero Seguretat Social Metge:");
        txtFSegSocialMetge = new JTextField();
        lblTelefonoMetge = new JLabel("Numero Telefon Metge:");
        txtFTelefonoMetge = new JTextField();
        lblNumEmpleatMetge = new JLabel("Numero Empleat:");
        txtFNumEmpleatMetge = new JTextField();
        lblNumSalariMensual = new JLabel("Salari Mensual:");
        txtFSalariMensual = new JTextField();
        lblCodiCompte = new JLabel("Codi Compte Corrent:");
        txtFCodiCompte = new JTextField();
        lblFecha = new JLabel("Fecha visita:");
        txtFfecha = new JTextField();
        lblHora = new JLabel("Hora Visita:");
        txtFhora = new JTextField();
        lblnom = new JLabel("Nom Pacient:");
        txtFnom = new JTextField();
        lblcognom1 = new JLabel("Cognom Pacient:");
        txtFcognom1 = new JTextField();
        lblcognom2 = new JLabel("Segon Cognom Pacient:");
        txtFcognom2 = new JTextField();
        lblSegSocial = new JLabel("Numero Seguretat Social:");
        txtFsegSocial = new JTextField();
        lblTelefono = new JLabel("Numero Telefon:");
        txtFtelefono = new JTextField();
        btnBuscar = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");

        pBuscar.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.WHITE));
        pBuscar.add(lblBuscarPerPacient);
        pBuscar.add(lblBuscarNifPacient);
        pBuscar.add(txtFbuscarNifPacient);
        pBuscar.add(lblBuscarSegSocialPacient);
        pBuscar.add(txtFbuscarSegSocialPacient);
        pBuscar.add(lblBuscarPerMetge);
        pBuscar.add(lblBuscarNomMetge);
        pBuscar.add(txtFbuscarNomMetge);
        pBuscar.add(lblBuscarCognomMetge);
        pBuscar.add(txtFBuscarCognomMetge);
        pBuscar.add(lblBuscarCodiMetge);
        pBuscar.add(txtFBuscarCodiMetge);
        pBuscar.add(tituloBuscarPerMalaltia);
        pBuscar.add(lblbuscarMalaltia);
        pBuscar.add(txtFbuscarMalaltia);

        txtFnom.setEditable(false);
        txtFcognom1.setEditable(false);
        txtFcognom2.setEditable(false);
        txtFsegSocial.setEditable(false);
        txtFtelefono.setEditable(false);
        txtFcodiMalaltia.setEditable(false);
        txtFTelefonoMetge.setEditable(false);
        txtFCodiCompte.setEditable(false);
        txtFSalariMensual.setEditable(false);
        txtFnomMalaltia.setEditable(false);
        txtFnomMetge.setEditable(false);
        txtFcausaMalaltia.setEditable(false);
        txtFtractamentMalaltia.setEditable(false);
        txtFduradaMalaltia.setEditable(false);
        txtFCognom1Metge.setEditable(false);
        txtFCognom2Metge.setEditable(false);
        txtFSegSocialMetge.setEditable(false);
        txtFNumEmpleatMetge.setEditable(false);

        pMalaltia.add(lblCodiMalaltia);
        pMalaltia.add(txtFcodiMalaltia);
        pMalaltia.add(lblNomMalaltia);
        pMalaltia.add(txtFnomMalaltia);
        pMalaltia.add(lblTractamentMalaltia);
        pMalaltia.add(txtFtractamentMalaltia);
        pMalaltia.add(lblCausaMalaltia);
        pMalaltia.add(txtFcausaMalaltia);
        pMalaltia.add(lblDuradaMalaltia);
        pMalaltia.add(txtFduradaMalaltia);

        pPacient.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.WHITE));
        pPacient.add(tituloPacient);
        pPacient.add(lblFecha);
        pPacient.add(txtFfecha);
        pPacient.add(lblHora);
        pPacient.add(txtFhora);
        pPacient.add(lblnom);
        pPacient.add(txtFnom);
        pPacient.add(lblcognom1);
        pPacient.add(txtFcognom1);
        pPacient.add(lblcognom2);
        pPacient.add(txtFcognom2);
        pPacient.add(lblSegSocial);
        pPacient.add(txtFsegSocial);
        pPacient.add(lblTelefono);
        pPacient.add(txtFtelefono);

        pMetge.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.WHITE));
        pMetge.add(tituloMetge);
        pMetge.add(lblnomMetge);
        pMetge.add(txtFnomMetge);
        pMetge.add(lblCognom1Metge);
        pMetge.add(txtFCognom1Metge);
        pMetge.add(lblCognom2Metge);
        pMetge.add(txtFCognom2Metge);
        pMetge.add(lblSegSocialMetge);
        pMetge.add(txtFSegSocialMetge);
        pMetge.add(lblTelefonoMetge);
        pMetge.add(txtFTelefonoMetge);
        pMetge.add(lblNumEmpleatMetge);
        pMetge.add(txtFNumEmpleatMetge);
        pMetge.add(lblNumSalariMensual);
        pMetge.add(txtFSalariMensual);
        pMetge.add(lblCodiCompte);
        pMetge.add(txtFCodiCompte);

        pButtons.add(btnVisita);
        pButtons.add(btnBuscar);
        pButtons.add(btnCancelar);

        ventana2.add(pMalaltia, BorderLayout.NORTH);
        ventana2.add(pBuscar, BorderLayout.EAST);
        ventana2.add(pMetge, BorderLayout.WEST);
        ventana2.add(pPacient, BorderLayout.CENTER);
        ventana2.add(pButtons, BorderLayout.SOUTH);
        ventana2.pack();
        ventana2.setLocationRelativeTo(null);
        ventana2.setVisible(true);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registrarVisitaPacient();
                registrarVisitaMetge();
                registrarVisitaMalaltia();
            }
        });
        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana2.setVisible(false);
                JframeMenu menu = new JframeMenu();
                menu.ventanaMenu.setVisible(true);
            }

        });
        btnVisita.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    afegirVisita();
                } catch (ExcepcionsHospital ex) {
                    Logger.getLogger(JframeRegistrarVisita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void afegirVisita() throws ExcepcionsHospital {

        if (txtFnomMetge.getText().length() == 0 || txtFCognom1Metge.getText().length() == 0
                || txtFCognom2Metge.getText().length() == 0 || txtFSegSocialMetge.getText().length() == 0
                || txtFNumEmpleatMetge.getText().length() == 0 || txtFTelefonoMetge.getText().length() == 0
                || txtFSalariMensual.getText().length() == 0 || txtFCodiCompte.getText().length() == 0) {
            showMessageDialog(null, "Introduce los datos correctamente");
        } else {
        }
        //Campos metge
        String nomMetge = txtFnomMetge.getText();
        String cog = txtFCognom1Metge.getText();
        String cog2 = txtFCognom2Metge.getText();
        String ss = txtFSegSocialMetge.getText();
        String nif = txtFbuscarNifPacient.getText();
        String telf = txtFTelefonoMetge.getText();
        int codEmpleat = Integer.parseInt(txtFNumEmpleatMetge.getText());
        int salari = Integer.parseInt(txtFSalariMensual.getText());
        String compte = txtFCodiCompte.getText();

        //Campos Malaltia
        int codi = Integer.parseInt(txtFcodiMalaltia.getText());
        String nomMalaltia = txtFnomMalaltia.getText();
        String tractament = txtFtractamentMalaltia.getText();
        String durada = txtFduradaMalaltia.getText();
        Boolean baixa = Boolean.valueOf(txtFcausaMalaltia.getText());

        //Campos Visita
        String fechaHoraVisita = txtFfecha.getText() + "-" + txtFhora.getText();

        Metge metge = new Metge(nomMetge, cog, cog2, ss, nif, telf, codEmpleat, salari, compte);
        Malaltia malaltia = new Malaltia(codi, nomMalaltia, tractament, baixa, durada);
        Visita visita = new Visita(fechaHoraVisita, metge, malaltia);

        ArrayList<Visita> vis = new ArrayList<>();
        vis.add(visita);

        ArrayList<Pacient> pacient = new ArrayList();
        try {
            pacient = Pacient.obtenerPacientes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JframeRegistrarVisita.class.getName()).log(Level.SEVERE, null, ex);
        }
        String SsPacient = txtFsegSocial.getText();
        int pacientCodi = GestioHospital.buscarPacient(pacient, 2, SsPacient);

        String pacientNif = pacient.get(pacientCodi).getNIF();

        pacientCodi = pacientCodi + 1;

        Historial historial = new Historial(pacientCodi, pacientNif, vis);

        ArrayList<Historial> his = new ArrayList<>();
        his.add(historial);
        boolean ok = Visita.escribirVisita(his);
        if (ok == true) {
            showMessageDialog(null, "Registrada la visita ");

        }

    }

    public void registrarVisitaMalaltia() {
        ArrayList<Malaltia> malaltia = new ArrayList();
        try {
            malaltia = Malaltia.leerMalaltias();

        } catch (FileNotFoundException | ExcepcionsHospital ex) {
        }
        if (lblbuscarMalaltia.getText().length() >= 0) {
            String nom = txtFbuscarMalaltia.getText();
            int ma = GestioHospital.buscarMalaltia(malaltia, 1, nom);
            if (ma == -1) {
            } else {
                txtFcodiMalaltia.setText(Integer.toString(malaltia.get(ma).getCodi()));
                txtFnomMalaltia.setText(malaltia.get(ma).getNom());
                txtFtractamentMalaltia.setText(malaltia.get(ma).getTracatament());
                txtFcausaMalaltia.setText(Boolean.toString(malaltia.get(ma).getCausaBaixa()));
                txtFduradaMalaltia.setText(malaltia.get(ma).getduradaTractament());
            }

        }
    }

    public void registrarVisitaMetge() {
        ArrayList<Metge> metges = new ArrayList();
        try {
            metges = Metge.obtenerMetge();

        } catch (FileNotFoundException | ExcepcionsHospital ex) {
        }
        if (txtFbuscarNomMetge.getText().length() >= 0) {
            String nom = txtFbuscarNomMetge.getText();
            int me = GestioHospital.buscarMetge(metges, 1, nom);
            if (me == -1) {
            } else {
                txtFnomMetge.setText(metges.get(me).getnom());
                txtFCognom1Metge.setText(metges.get(me).getcognom1());
                txtFCognom2Metge.setText(metges.get(me).getcognom2());
                txtFSegSocialMetge.setText(metges.get(me).getnumSegSocial());
                txtFTelefonoMetge.setText(metges.get(me).gettelefon());
                txtFNumEmpleatMetge.setText(Integer.toString(metges.get(me).getNumEmpleat()));
                txtFSalariMensual.setText(Integer.toString(metges.get(me).getSalariMensual()));
                txtFCodiCompte.setText(metges.get(me).getCompteCorrent());
            }

        }
        if (txtFBuscarCognomMetge.getText().length() >= 0) {
            String cognom1 = txtFBuscarCognomMetge.getText();
            int meC = GestioHospital.buscarMetge(metges, 3, cognom1);
            if (meC == -1) {
            } else {
                txtFnomMetge.setText(metges.get(meC).getnom());
                txtFCognom1Metge.setText(metges.get(meC).getcognom1());
                txtFCognom2Metge.setText(metges.get(meC).getcognom2());
                txtFSegSocialMetge.setText(metges.get(meC).getnumSegSocial());
                txtFTelefonoMetge.setText(metges.get(meC).gettelefon());
                txtFNumEmpleatMetge.setText(Integer.toString(metges.get(meC).getNumEmpleat()));
                txtFSalariMensual.setText(Integer.toString(metges.get(meC).getSalariMensual()));
                txtFCodiCompte.setText(metges.get(meC).getCompteCorrent());
            }
        }
        if (txtFBuscarCodiMetge.getText().length() >= 0) {
            String numEmpleat = txtFBuscarCodiMetge.getText();
            int meCodi = GestioHospital.buscarMetge(metges, 4, numEmpleat);
            if (meCodi == -1) {
            } else {
                txtFnomMetge.setText(metges.get(meCodi).getnom());
                txtFCognom1Metge.setText(metges.get(meCodi).getcognom1());
                txtFCognom2Metge.setText(metges.get(meCodi).getcognom2());
                txtFSegSocialMetge.setText(metges.get(meCodi).getnumSegSocial());
                txtFTelefonoMetge.setText(metges.get(meCodi).gettelefon());
                txtFNumEmpleatMetge.setText(Integer.toString(metges.get(meCodi).getNumEmpleat()));
                txtFSalariMensual.setText(Integer.toString(metges.get(meCodi).getSalariMensual()));
                txtFCodiCompte.setText(metges.get(meCodi).getCompteCorrent());
            }
        }
    }

    public void registrarVisitaPacient() {
        ArrayList<Pacient> pacientes = new ArrayList();
        try {
            pacientes = Pacient.obtenerPacientes();

        } catch (FileNotFoundException | ExcepcionsHospital ex) {
        }

        if (txtFbuscarNifPacient.getText().length() >= 0) {
            String nif = txtFbuscarNifPacient.getText();
            int pa = GestioHospital.buscarPacient(pacientes, 1, nif);
            if (pa == -1) {
            } else {
                txtFnom.setText(pacientes.get(pa).getnom());
                txtFcognom1.setText(pacientes.get(pa).getcognom1());
                txtFcognom2.setText(pacientes.get(pa).getcognom2());
                txtFsegSocial.setText(pacientes.get(pa).getnumSegSocial());
                txtFtelefono.setText(pacientes.get(pa).gettelefon());

            }
        }
        if (txtFbuscarSegSocialPacient.getText().length() >= 0) {
            String numSegSocial = txtFbuscarSegSocialPacient.getText();
            int paC = GestioHospital.buscarPacient(pacientes, 2, numSegSocial);
            if (paC == -1) {
            } else {
                txtFnom.setText(pacientes.get(paC).getnom());
                txtFcognom1.setText(pacientes.get(paC).getcognom1());
                txtFcognom2.setText(pacientes.get(paC).getcognom2());
                txtFsegSocial.setText(pacientes.get(paC).getnumSegSocial());
                txtFtelefono.setText(pacientes.get(paC).gettelefon());

            }
        }
    }
}
