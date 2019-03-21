/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.modelo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Christian
 */
public abstract class Persona {

    String nomMetge, cognom1, cognom2, numSegSocial, NIF, telefon;
    Adreca adreca;

    public Persona(String nom, String cognom1, String cognom2, String numSegSocial, String NIF, String telefon) throws ExcepcionsHospital {
        boolean ok = false;
        this.nomMetge = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.numSegSocial = numSegSocial;
        this.NIF = NIF;
        this.telefon = telefon;
    }

    public Adreca getAdreca() {
        return this.adreca;
    }

    public String getnom() {
        return nomMetge;
    }

    public String getcognom1() {
        return cognom1;
    }

    public String getcognom2() {
        return cognom2;
    }

    public String getnumSegSocial() {
        return numSegSocial;
    }

    public String getNIF() {
        return NIF;
    }

    public String gettelefon() {
        return telefon;
    }

    public static void comprovarDNI(String nif) throws ExcepcionsHospital {
        final int DIVISOR = 23;
        char asignarLetra[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
            'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        if (!(nif.length() >= 8 && nif.length() <= 9)) {
            throw new ExcepcionsHospital(ExcepcionsHospital.LONGITUD_NO_CORRECTA);
        }

        String parte_numerica = nif.substring(0, nif.length() - 1);
        int numeroNIF = 0;

        try {
            numeroNIF = Integer.parseInt(parte_numerica);
        } catch (NumberFormatException e) {
            throw new ExcepcionsHospital(ExcepcionsHospital.PARTE_NUMERICA_NO_CORRECTA);
        }

        char letra = nif.substring(nif.length() - 1, nif.length()).toUpperCase().charAt(0);

        if (!(letra >= 'A' && letra <= 'Z')) {
            throw new ExcepcionsHospital(ExcepcionsHospital.PARTE_LETRA_NO_CORRECTA);
        }
        int resto = numeroNIF % DIVISOR;
        String nuevoDNI = numeroNIF + "" + asignarLetra[resto];
        if (!(nuevoDNI.equals(nif))) {
            throw new ExcepcionsHospital(ExcepcionsHospital.FORMATO_NO_CORRECTO);
        }
    }

    /*public static void comprovarSegSocial(String numSegSocial) throws ExcepcionsHospital{
        int d = 0;
        int resto = 0;
        int rest = 0;
        String a = numSegSocial.substring(0,2); 
        int primerValor = Integer.parseInt(a);
        String b = numSegSocial.substring(2, 10);
        int segundoValor = Integer.parseInt(b);
        String c = numSegSocial.substring(10, 12);
        int tercerValor = Integer.parseInt(c);
        String e = numSegSocial.substring(2, 10);
        int cuartoValor = Integer.parseInt(e);
        int incr = 2;
        String digito = numSegSocial.substring(incr, incr - 1); 
        int numeroDigito = Integer.parseInt(digito);
        if (primerValor < 10000000) 
        {
            d = segundoValor + primerValor * 10000000; 
            resto = d % 97;
            if (resto == tercerValor)
            {
                throw new ExcepcionsHospital(ExcepcionsHospital.FORMATO_SS_INCORRECTO);
            } 	
        } else {
            while (numeroDigito == 0)
            {
                digito = numSegSocial.substring(incr + 1, 1);//cogemos el digito siguiente y lo comprobamos que sea igual a cero.
                e = numSegSocial.substring(incr + 1, numSegSocial.length() - incr - 3);//asignamos a e la cadena sin el digito anteriormente comprobado
                incr++; //incrementamos la variable para para comprobar el siguente digito
            }
            d = primerValor + cuartoValor;//asignamos a e el valor de a concatenado con b sin cero 
            rest = d % 97;
            if (rest == tercerValor) {
               throw new ExcepcionsHospital(ExcepcionsHospital.FORMATO_SS_INCORRECTO);
            }

        }
    }*/
}

