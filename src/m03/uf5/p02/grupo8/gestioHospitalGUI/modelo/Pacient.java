/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import m03.uf5.p02.grupo8.gestioHospitalGUI.controlador.leerEscribirPacientes;

/**
 *
 * @author Christian
 */
public class Pacient extends Persona {

    public Pacient(String nom, String cognom1, String cognom2, String numSegSocial, String NIF, String telefon) throws ExcepcionsHospital {
        super(nom, cognom1, cognom2, numSegSocial, NIF, telefon);
        super.nomMetge = nom;
        super.cognom1 = cognom1;
        super.cognom2 = cognom2;
        super.numSegSocial = numSegSocial;
        super.NIF = NIF;
        super.telefon = telefon;
    }

    public String toString() {
        return "Nom: " + nomMetge
                + " cognom1: " + cognom1
                + " cognom2: " + cognom2
                + " numSegSocial: " + numSegSocial
                + " NIF: " + NIF
                + " telefon: " + telefon;
    }

    public static ArrayList<Pacient> obtenerPacientes() throws FileNotFoundException, ExcepcionsHospital {
        ArrayList<Pacient> p;
        p = leerEscribirPacientes.leeCSV();

        return p;

    }

    public static Boolean añadirPaciente(Pacient p) {
        boolean ok = leerEscribirPacientes.escribeCSV2(p);
        return ok;
    }

}
