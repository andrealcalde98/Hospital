/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.modelo;

import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import static java.time.Duration.ofHours;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author Christian ferran albert
 */
public class GestioHospital {

    public static void main(String[] args) throws ExcepcionsHospital {
        Hospital h = new Hospital("Institut Catala de medicina de la Salut");
        menu(h.pacient, h.metge, h.malaltia, h.historial, h.visita);
    }

    public static void menu(List<Pacient> pacient, List<Metge> metge, List<Malaltia> malaltia, List<Historial> historial, List<Visita> visita) throws ExcepcionsHospital {
        Scanner in = new Scanner(System.in);
        boolean salir = false;
        boolean repetir = true;
        int opcion;
        do {
            try {
                while (!salir) {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                            UF5P01 - GESTIO HOSPITAL                    ");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("1. Registrar visita ");
                    System.out.println("2. Nou pacient ");
                    System.out.println("3. Mostrar pacient ");
                    System.out.println("4. Mostrar metge ");
                    System.out.println("5. Veure Historial ");
                    System.out.println("6. Sortir ");
                    System.out.println("");
                    System.out.print("Escribe una de las opciones: ");
                    opcion = in.nextInt();
                    in.nextLine();
                    System.out.println("");
                    System.out.println("Has seleccionado la opcion " + opcion);
                    switch (opcion) {
                        case 1:
                            //registrarVisita(pacient, metge, malaltia, visita);
                            break;
                        case 2:
                            //nouPacient(pacient);
                            break;
                        case 3:
                            /*    buscarPacient(pacient, 0, "");*/
                            break;
                        case 4:

                            break;
                        case 5:
                            MostrarHistorial(historial);
                            break;
                        case 6:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo numeros entre 1 y 6");
                    }
                }
                repetir = false;
            } catch (InputMismatchException e) {
                in.next();
                System.out.println("Tienes que introducir un numero!!");
            }
        } while (repetir);
    }

    public static int buscarPacient(ArrayList<Pacient> pacient, int option, String comprobar) {
        Scanner in = new Scanner(System.in);

        if (pacient.isEmpty()) {
            /* System.out.println("----------------------------------------------------");
            System.out.println("No hi ha pacients ");
            System.out.println("----------------------------------------------------");
            ;
             */
            return -1;
        } else {

            /* System.out.println("Introdueix per que vols buscar 1. NIF 2.Num.Seguretat Social");*/

 /*int option = in.nextInt();
            System.out.println("OPCION " + option);
             */
 /*NIF*/
            if (option == 1) {
                for (int i = 0; i < pacient.size(); i++) {
                    if (pacient.get(i).NIF.equalsIgnoreCase(comprobar)) {
                        return i;
                    }

                }
                /*SS*/
            } else if (option == 2) {
                for (int i = 0; i < pacient.size(); i++) {
                    if (pacient.get(i).numSegSocial.equalsIgnoreCase(comprobar)) {
                        return i;
                    }
                }
                /*else {
                System.out.println("----------------------------------------------------");
                System.out.println("Introdueix 1 per a NIF i 2 per Num.Seguretat Social");
                System.out.println("----------------------------------------------------");
            }*/
            
            }
            return -1;
        }

    }

    /*

    public static void nouPacient(List<Pacient> pacient) throws ExcepcionsHospital {
        Scanner in = new Scanner(System.in);
        boolean salir = false;
        String nomMalaltia = null;
        do {

            System.out.print("Nom del Pacient: ");
            nomMalaltia = "";
            nomMalaltia = in.nextLine();
            System.out.print("Cognom del Pacient: ");
            String cog1 = "";
            cog1 = in.nextLine();
            System.out.print("Segon Cognom del Pacient: ");
            String cog2 = "";
            cog2 = in.nextLine();
            System.out.print("Numero de la seguretat Social: ");
            String ss = "";
            ss = in.nextLine();
            String nif = null;
            boolean ErrorNif = false;
            do {
                try {
                    System.out.print("NIF: ");
                    nif = "";
                    nif = in.nextLine();
                    Persona.comprovarDNI(nif);
                    ErrorNif = true;
                } catch (ExcepcionsHospital e) {
                    System.out.println(e.getMessage());
                }
            } while (!ErrorNif);

            System.out.print("Telefón: ");
            String telf = "";
            telf = in.nextLine();
            Pacient afegirPacient = new Pacient(nomMalaltia, cog1, cog2, ss, nif, telf);
            boolean existe;
            existe = Comprovar.comprovarNIF(nif, pacient) && Comprovar.comprovarSS(ss, pacient);
            if (existe == true) {
                System.out.println("------------ATENCIO------------");
                System.out.println("Aquest Usuari ja esta registrat");

            } else {
                pacient.add(afegirPacient);
            }
            System.out.println("S'ha creat el pacient amb DNI: " + nif);
            System.out.println("Vols Crear un altre Pacient? SI/NO");
            String s = in.nextLine();
            if (s.equalsIgnoreCase("si")) {
                salir = false;
            } else {
                salir = true;
            }
        } while (salir == false);

    }
     */
 /*
    public static void registrarVisita(List<Pacient> pacient, List<Metge> metge, List<Malaltia> malaltia, List<Visita> visita) {
        Scanner in = new Scanner(System.in);
        int codi = 0;
        System.out.println("Escull identificació del pacient:(1: NIF, 2.Seguretat Social, 3. Codi Historial)");
        int opcio = in.nextInt();
        String pa = "";
        if (opcio == 1) {
            in.nextLine();
            System.out.println("Introdueix NIF del pacient: ");
            String NIFp = in.nextLine();
            for (int i = 0; i < pacient.size(); i++) {
                if (pacient.get(i).getNIF().equalsIgnoreCase(NIFp)) {
                    pa = pacient.get(i).toString();
                    System.out.println(pa);
                }
            }
        } else if (opcio == 2) {
            in.nextLine();
            System.out.println("Introdueix el numero de la seguretat social");
            String ss = in.nextLine();

            for (int i = 0; i < pacient.size(); i++) {
                if (pacient.get(i).getnumSegSocial().equalsIgnoreCase(ss)) {

                    pa = pacient.toString();
                    System.out.println(pa);
                }

            }

        } else if (opcio == 3) {
            in.nextLine();
            System.out.println("Introduiex el codi historial");
            codi = in.nextInt();
            pa = pacient.toString();
            System.out.println(pa);

        }

        //--------------------------------
        System.out.println("Escull identificació del Metge:(1: Nom, 2.Cognom, 3. Codi Metge");
        int opcio2 = in.nextInt();
        String me = "";
        if (opcio2 == 1) {
            in.nextLine();
            System.out.println("Introdueix el nomMalaltia del Metge: ");
            String nomM = in.nextLine();
            for (int i = 0; i < metge.size(); i++) {
                if (metge.get(i).getnom().equalsIgnoreCase(nomM)) {
                    me = metge.get(i).toString();
                    System.out.println(me);

                }
            }
        } else if (opcio2 == 2) {
            in.nextLine();
            System.out.println("Introdueix el primer cognom del Metge: ");
            String PcogM = in.nextLine();
            for (int i = 0; i < metge.size(); i++) {
                if (metge.get(i).getcognom1().equalsIgnoreCase(PcogM)) {
                    me = metge.get(i).toString();
                    System.out.println(me);

                }
            }
        } else if (opcio2 == 3) {
            in.nextLine();
            System.out.println("Introduiex el codi Metge");
            codi = in.nextInt();
            me = metge.get(codi).toString();
            System.out.println(me);

        }

        System.out.println("Introduce fecha de la visita y hora en formato dd/mm/yyyy HH:mm:ss");
        String fecha = in.nextLine();
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse(fecha, sdf);
        System.out.println("-----------------------------------------------");
        System.out.println("                PACIENT REGISTRAT");
        System.out.println("-----------------------------------------------");
        System.out.println("Fecha y Hora visita: " + dt);
        System.out.println("Registre Pacient: " + pa);
        System.out.println("Registre Metge: " + me);
        String ma = "";
        ma = malaltia.get(0).toString();
        System.out.println(ma);
        Visita v = new Visita(dt, metge.get(codi), malaltia.get(0));
        visita.add(v);

//-------------------------------------------
    }
     */
    public static void registrarHistorial(int codi, String nif, ArrayList<Visita> visita) {

    }

    public static int buscarMetge(ArrayList<Metge> metge, int option, String comprobar) {
        Scanner in = new Scanner(System.in);

        if (metge.isEmpty()) {
            /* System.out.println("----------------------------------------------------");
            System.out.println("No hi ha pacients ");
            System.out.println("----------------------------------------------------");
            ;
             */
            return -1;
        } else {

            /* System.out.println("Introdueix per que vols buscar 1. NIF 2.Num.Seguretat Social");*/

 /*int option = in.nextInt();
            System.out.println("OPCION " + option);
             */
 /*NIF*/
            if (option == 1) {
                for (int i = 0; i < metge.size(); i++) {
                    if (metge.get(i).nomMetge.equalsIgnoreCase(comprobar)) {
                        return i;
                    }

                }
                /*SS*/
            } else if (option == 2) {
                for (int i = 0; i < metge.size(); i++) {
                    String pa = "";
                    pa = metge.get(i).toString();
                    System.out.println(pa);
                }
            } else if (option == 3) {
                for (int i = 0; i < metge.size(); i++) {
                    if (metge.get(i).cognom1.equalsIgnoreCase(comprobar))
                        return i;
                }
                
                } else if (option == 4) {
                    
                for (int i = 0; i < metge.size(); i++) {
                    String stringnNumEmpleat = String.valueOf(metge.get(i).numEmpleat);
                    if (stringnNumEmpleat.equalsIgnoreCase(comprobar))
                        return i;
                }
                    
                        
                
            }
            /*else {
                System.out.println("----------------------------------------------------");
                System.out.println("Introdueix 1 per a NIF i 2 per Num.Seguretat Social");
                System.out.println("----------------------------------------------------");
            }*/
        }
        return -1;
    }

    public static int buscarMalaltia(ArrayList<Malaltia> malaltia, int option, String comprobar) {
        Scanner in = new Scanner(System.in);

        if (malaltia.isEmpty()) {

            return -1;
        } else {
            if (option == 1) {
                for (int i = 0; i < malaltia.size(); i++) {
                    if (malaltia.get(i).nomMalaltia.equalsIgnoreCase(comprobar)) {
                        return i;
                    }

                }
            }
            return -1;

        }
    }

    public static void MostrarHistorial(List<Historial> historial) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digam el codi de l'historial que vols mostrar: ");
        int codi = in.nextInt();
        for (int i = 0; i < historial.size(); i++) {
            if (historial.get(i).codi == codi) {
                String h = historial.get(i).toString();
                System.out.println(h);
            }

        }
    }
}
