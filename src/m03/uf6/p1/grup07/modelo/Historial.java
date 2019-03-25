    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf6.p1.grup07.modelo;

import java.util.ArrayList;


/**
 *
 * @author Christian
 */
public class Historial {

    int codi = 0;
    String nif;
    ArrayList <Visita> visita = new ArrayList();

    public Historial(int codi, String NIF, ArrayList<Visita> visita) {
        this.codi = codi;
        this.nif = NIF;
        this.visita = visita;
    }

    public int getCodi() {
        return codi;
    }
    public String getNif(){
        return nif;
    }
    public ArrayList<Visita> getVisita(){
        return visita;
    }

    @Override
    public String toString() {
        return "Codi: " + codi
                + "NIF: " + nif
                + "Visita: " + visita;
    }
    
  
}
