/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.modelo;

/**
 *
 * @author Christian
 */
public class ExcepcionsHospital extends Exception {

    public static final String LONGITUD_NO_CORRECTA = "La longitud debe estar entre 8 y 9";
    public static final String PARTE_NUMERICA_NO_CORRECTA = "La parte numerica del DNI debe ser un numero";
    public static final String PARTE_LETRA_NO_CORRECTA = "La parte de la letra tiene que estar en un numero entre la A y la Z";
    public static final String FORMATO_NO_CORRECTO = "El DNI es incorrecto";
    public static final String FORMATO_SS_INCORRECTO ="El numero de la seguridad social es incorrecto";
    public static final String FORMATO_NO_TRUE_FALSE="Tienes que escribir o true o false";
    public ExcepcionsHospital(String mensaje) {
        super(mensaje);
    }
    
}
