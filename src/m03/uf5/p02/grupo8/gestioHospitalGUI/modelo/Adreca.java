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
public class Adreca {
   String ciutat, codiPostal, carrer, planta, porta;
   int numero;
   
   public Adreca(String ciutat, String codiPostal, String carrer, String planta, String porta, int numero)
   {
       this.ciutat = ciutat;
       this.codiPostal = codiPostal;
       this.carrer = carrer;
       this.planta = planta;
       this.porta = porta;
       this.numero = numero;
   }
   
  public String getCiutat()
  {
      return ciutat;
  }
  
  public String getCodiPostal()
  {
      return codiPostal;
  }
  
  public String getCarrer()
  {
      return carrer;
  }
  
  public String getPlanta()
  {
      return planta;
  }
  
  public String getPorta()
  {
      return porta;
  }
  
  public int getNumero()
  {
      return numero;
  }
}
