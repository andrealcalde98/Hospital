/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import m03.uf6.p1.grup07.modelo.ExcepcionsHospital;
import m03.uf6.p1.grup07.modelo.Pacient;

/**
 *
 * @author Albert
 */
public class leerEscribirPacientes {

    public static ArrayList leeCSV() throws FileNotFoundException, ExcepcionsHospital {

        File fichero = new File("pacient.csv");
        Scanner sc = new Scanner(fichero);
        ArrayList<Pacient> pa = new ArrayList<>();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            Pacient p = new Pacient(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
            pa.add(p);
        }
        return pa;
    }

    public static boolean escribeCSV2(Pacient m) {
        try {
            String nombreFichero = "pacient.csv";
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(m.getnom() + "," + m.getcognom1() + "," + m.getcognom2() + "," + m.getnumSegSocial() + "," + m.getNIF() + "," + m.gettelefon());

            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
        return true;
    }
}
