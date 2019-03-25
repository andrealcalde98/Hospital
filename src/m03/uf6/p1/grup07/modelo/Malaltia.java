/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.modelo;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import m03.uf6.p1.grup07.controlador.leerEscribirMalaltias;
import m03.uf6.p1.grup07.controlador.leerEscribirPacientes;

/**
 *
 * @author Christian
 */
public class Malaltia {

    private int codi = 0;
    protected String nomMalaltia;
    private String tractament;
    private boolean causaBaixa = false;
    /* Duration duradaTractament; */
    private String duradaTractament;

    public Malaltia(int codi, String nom, String tractament, boolean causaBaixa, String duradaTractament) {
        this.codi = codi;
        this.nomMalaltia = nom;
        this.tractament = tractament;
        this.causaBaixa = causaBaixa;
        this.duradaTractament = duradaTractament;
    }

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nomMalaltia;
    }

    public String getTracatament() {
        return tractament;
    }

    public Boolean getCausaBaixa() {
        return causaBaixa;
    }

    public String getduradaTractament() {
        return duradaTractament;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nomMalaltia = nom;
    }

    public void setTractament(String tractament) {
        this.tractament = tractament;
    }

    public void setCausaBaixa(boolean causaBaixa) {
        this.causaBaixa = causaBaixa;
    }

    public void setDuradaTractament(String duradaTractament) {
        this.duradaTractament = duradaTractament;
    }

    public String toString() {
        return "Codi Malaltia: " + codi
                + " Nom Malaltia: " + nomMalaltia
                + " Durada Malaltia: " + duradaTractament;
    }

    public static boolean escribirMalaltias(Malaltia p) throws FileNotFoundException, ExcepcionsHospital {
        boolean ok = leerEscribirMalaltias.escribeCSV2(p);
        return ok;
    }

    public static ArrayList<Malaltia> leerMalaltias() throws FileNotFoundException, ExcepcionsHospital {
        ArrayList<Malaltia> p;
        p = leerEscribirMalaltias.leeCSV();
        return p;

    }
}
