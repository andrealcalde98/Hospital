/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.modelo;

import java.time.Duration;
import static java.time.Duration.ofHours;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class Hospital {

    String nom;
    List<Pacient> pacient = new ArrayList();
    List<Metge> metge = new ArrayList();
    List<Malaltia> malaltia = new ArrayList();
    List<Historial> historial = new ArrayList();
    List<Visita> visita = new ArrayList();

    public Hospital(String nombre) throws ExcepcionsHospital {
        this.nom = nombre;
        Adreca p = new Adreca("Terrassa", "08223", "C/Provenca", "3", "4" ,10);
        Metge metge1 = new Metge("Manolo", "Garcia", " Martinez ", "01-1324", "63677711A", "664322121",1,1000,"4012-1231-1221-1232");
        Metge metge2 = new Metge(" Maria ", " Perez ", " Lopez ", " 01-1234 ", "75781392A", " 669928121",2,1000,"4012-1234-1234-1234");
 
        metge.add(0, metge1);
        metge.add(1, metge2);
        
        Malaltia malaltias1 = new Malaltia(1, "Gripe comun", "xarop", false , "2");

        malaltia.add(0, malaltias1);
        GestioHospital.menu(pacient, metge, malaltia, historial,visita);
    }


    public String getnom() {
        return nom;

    }
}
