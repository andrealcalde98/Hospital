/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Malaltia;

/**
 *
 * @author Albert
 */
public class leerEscribirMalaltias {

    public static ArrayList leeCSV() throws FileNotFoundException, ExcepcionsHospital {
        File fichero = new File("malaltia.csv");
        Scanner sc = new Scanner(fichero);
        ArrayList<Malaltia> pa = new ArrayList<>();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            Malaltia p = new Malaltia(Integer.parseInt(datos[0]), datos[1], datos[2], Boolean.parseBoolean(datos[3]), datos[4]);
            pa.add(p);
        }
        return pa;
    }

    public static boolean escribeCSV2(Malaltia m) {
        try {
            String nombreFichero = "malaltia.csv";
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(m.getCodi() + "," + m.getNom() + "," + m.getTracatament() + "," + m.getCausaBaixa() + "," + m.getduradaTractament());
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
        return true;
    }
}
