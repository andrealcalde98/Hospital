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
import java.util.ArrayList;
import java.util.Scanner;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.ExcepcionsHospital;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Malaltia;
import m03.uf5.p02.grupo8.gestioHospitalGUI.modelo.Metge;

/**
 *
 * @author Albert
 */
public class LeerEscribirMetge {

    public static ArrayList leeCSV() throws FileNotFoundException, ExcepcionsHospital {
        File fichero = new File("metge.csv");
        Scanner sc = new Scanner(fichero);
        ArrayList<Metge> pa = new ArrayList<>();

        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            Metge p = new Metge(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], Integer.parseInt(datos[6]), Integer.parseInt(datos[7]), datos[8]);
            pa.add(p);
        }
        return pa;
    }
//String nom, String cognom1, String cognom2, String numSegSocial, String NIF, String telefon,int numEmpleat, int salariMensual, String CodiCompteCorrent

    public static boolean escribeCSV2(Metge m) {

        try {
            String nombreFichero = "metge.csv";
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(m.getnom() + "," + m.getcognom1() + "," + m.getcognom2() + "," + m.getnumSegSocial() + "," + m.getNIF() + "," + m.gettelefon() + ","
                    + m.getNumEmpleat() + "," + m.getSalariMensual() + "," + m.getCompteCorrent());

            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
        return true;
    }
}
