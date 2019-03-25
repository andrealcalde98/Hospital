package m03.uf6.p1.grup07.controlador;

import m03.uf6.p1.grup07.modelo.MostrarHistorial;
import m03.uf6.p1.grup07.modelo.Historial;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import m03.uf6.p1.grup07.modelo.ExcepcionsHospital;

public class LeerEscribirVisita {

    public static ArrayList leeCSV() throws FileNotFoundException, ExcepcionsHospital {
        File fichero = new File("visita.csv");
        Scanner sc = new Scanner(fichero);

        ArrayList<MostrarHistorial> pa = new ArrayList<>();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            MostrarHistorial his = new MostrarHistorial(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            pa.add(his);
        }
        return pa;
    }

    public static boolean escribeCSV2(ArrayList<Historial> h) {
        try {
            String nombreFichero = "visita.csv";
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(h.get(0).getCodi() + "," + h.get(0).getNif() + "," + h.get(0).getVisita().get(0).getData() + "," + h.get(0).getVisita().get(0).getmetge().getnom() + ","
                    + h.get(0).getVisita().get(0).getmetge().getcognom1() + "," + h.get(0).getVisita().get(0).getmetge().getcognom2() + "," + h.get(0).getVisita().get(0).getmalaltia().getNom());

            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
        return true;
    }
}
