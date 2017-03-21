/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.exemplorest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author olegario
 */
@Path("divisores/{numero}")
public class DivisorREST {
  @GET
  @Produces("application/json")
  public String divisores(@PathParam("numero") int numero) {
    List<Integer> listaDivisores = new ArrayList<Integer>();
      
    if (numero <= 0) {
      listaDivisores.clear();
    } else if (numero == 1) {
      listaDivisores.add(1);
    } else {
      listaDivisores.add(1);
      
      for (int i = 2; i < numero/2; ++i) {
        if (numero % i == 0) {
          listaDivisores.add(i);
        }
      }
      listaDivisores.add(numero);
    }
      
    
    return new Gson().toJson(listaDivisores);
  }
}
