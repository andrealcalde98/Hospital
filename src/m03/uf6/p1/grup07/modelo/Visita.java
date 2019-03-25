/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.modelo;

import java.time.*;
import java.util.ArrayList;
import m03.uf6.p1.grup07.controlador.LeerEscribirVisita;
import m03.uf6.p1.grup07.controlador.leerEscribirPacientes;

/**
 *
 * @author Christian
 */
public class Visita {

    String data;
    Metge metge;
    Malaltia malaltia;

    public Visita(String data, Metge metge, Malaltia malaltia) {
        this.data = data;
        this.metge = metge;
        this.malaltia = malaltia;
    }

    public String getData() {
        return data;
    }

    public Metge getmetge() {
        return metge;
    }

    public Malaltia getmalaltia() {
        return malaltia;
    }

    public static boolean escribirVisita(ArrayList<Historial> h) {
        boolean ok = LeerEscribirVisita.escribeCSV2(h);
        return ok;

    }
}
