/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.modelo;

import java.util.List;

public class Comprovar {

    public static boolean comprovarNIF(String dni, List<Pacient> pacient) {
        for (int i = 0; i < pacient.size(); i++) {
            if (pacient.get(i).getNIF().equalsIgnoreCase(dni)) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }
        public static boolean comprovarSS(String ss, List<Pacient> pacient) {
        for (int i = 0; i < pacient.size(); i++) {
            if (pacient.get(i).getNIF().equalsIgnoreCase(ss)) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

}
