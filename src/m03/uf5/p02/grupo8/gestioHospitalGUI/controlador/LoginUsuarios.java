/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p02.grupo8.gestioHospitalGUI.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jmartin
 */
public class LoginUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = null;
        //Statement sentencia = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("Indiqui el nom d'usuari: ");
        String usuari = sc.nextLine();
        System.out.print("Indiqui la contrasenya: ");
        String contrasenya = sc.nextLine();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuaris", "admin_hospital_grup07", "admin");
            //sentencia = con.createStatement();
            //String consulta = "SELECT * FROM login WHERE nom_usuari = '" + usuari
            //        + "' AND password='" + contrasenya + "';";
            String consulta = "SELECT * FROM login WHERE nom_usuari = ? AND password = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, usuari);
            sentencia.setString(2, contrasenya);
            ResultSet resultat = sentencia.executeQuery();

            while (resultat.next()) {
                System.out.println(resultat.getString("nom_usuari") + ":"
                        + resultat.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
