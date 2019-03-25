/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import m03.uf6.p1.grup07.controlador.LeerEscribirMetge;

/**
 *
 * @author Christian
 */
public class Metge extends Persona {

   public int numEmpleat, salariMensual;
    String codiCompteCorrent;

    public Metge(String nom, String cognom1, String cognom2, String numSegSocial, String NIF, String telefon,
            int numEmpleat, int salariMensual, String CodiCompteCorrent) throws ExcepcionsHospital {
        super(nom, cognom1, cognom2, numSegSocial, NIF, telefon);
        
        this.numEmpleat = numEmpleat;
        this.salariMensual = salariMensual;
        this.codiCompteCorrent = CodiCompteCorrent;
    }

    public int getNumEmpleat() {
        return numEmpleat;
    }

    public int getSalariMensual() {
        return salariMensual;
    }

    public String getCompteCorrent() {
        return codiCompteCorrent;
    }

    @Override
    public String toString() {
        return "Nom Metge: " + nomMetge
                + " Prmer Cognom Metge: " + cognom1
                + " Segon COgnom Metge: " + cognom2
                + " Telefon: " + telefon;
    }

    public static Boolean añadirMetge(Metge p) {
        boolean ok = LeerEscribirMetge.escribeCSV2(p);
        return ok;
    }

    public static ArrayList<Metge> obtenerMetge() throws FileNotFoundException, ExcepcionsHospital {
        ArrayList<Metge> p;
        p = LeerEscribirMetge.leeCSV();

        return p;
    }
}
