package m03.uf6.p1.grup07.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import m03.uf6.p1.grup07.controlador.LeerEscribirVisita;

public class MostrarHistorial {

    private int codi;
    private String nif;
    private String fecha;
    private String nomMetge;
    private String cogMetge;
    private String cog2Metge;
    private String nomMalaltia;

    public MostrarHistorial(int codi, String nif, String fecha, String nomMetge, String cogMetge, String cog2Metge, String nomMalaltia) {

        this.codi = codi;
        this.nif = nif;
        this.fecha = fecha;
        this.nomMetge = nomMetge;
        this.cogMetge = cogMetge;
        this.cog2Metge = cog2Metge;
        this.nomMalaltia = nomMalaltia;
    }

    public static ArrayList<MostrarHistorial> leerHistorial() throws FileNotFoundException, ExcepcionsHospital {
        ArrayList<MostrarHistorial> p = new ArrayList<>();
        
        p = LeerEscribirVisita.leeCSV();
        return p;
    }

    /**
     * @param codi the codi to set
     */
    public void setCodi(int codi) {
        this.codi = codi;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @param nomMetge the nomMetge to set
     */
    public void setNomMetge(String nomMetge) {
        this.nomMetge = nomMetge;
    }

    /**
     * @param cogMetge the cogMetge to set
     */
    public void setCogMetge(String cogMetge) {
        this.cogMetge = cogMetge;
    }

    /**
     * @param cog2Metge the cog2Metge to set
     */
    public void setCog2Metge(String cog2Metge) {
        this.cog2Metge = cog2Metge;
    }

    /**
     * @param nomMalaltia the nomMalaltia to set
     */
    public void setNomMalaltia(String nomMalaltia) {
        this.nomMalaltia = nomMalaltia;
    }

    /**
     * @return the codi
     */
    public int getCodi() {
        return codi;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the nomMetge
     */
    public String getNomMetge() {
        return nomMetge;
    }

    /**
     * @return the cogMetge
     */
    public String getCogMetge() {
        return cogMetge;
    }

    /**
     * @return the cog2Metge
     */
    public String getCog2Metge() {
        return cog2Metge;
    }

    /**
     * @return the nomMalaltia
     */
    public String getNomMalaltia() {
        return nomMalaltia;
    }

}
