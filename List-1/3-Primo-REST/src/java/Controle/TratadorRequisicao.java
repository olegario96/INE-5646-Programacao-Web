package Controle;

import Modelo.Testador;
import Visao.GeradorHTML;
import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olegario
 */
public class TratadorRequisicao {
    
  public TratadorRequisicao() {
        
  }
    
  public String tratar_requisicao(String numero, String host, String porta, 
      String servico) {
      
    String pagina;
    Testador testador;
    String http = "http://";
    Boolean resultado = null;
    GeradorHTML gerador = new GeradorHTML();
      
    try {
      long primo = Long.parseLong(numero);
      Client cliente = ClientBuilder.newClient();
      String url = http+host+":"+porta+"/"+servico+"/"+numero;
      WebTarget wt = cliente.target(url);
        
      String arrayDivisores = wt.request().get().readEntity(String.class);
        
      int[] divisores = new Gson().fromJson(arrayDivisores, int[].class);
        
      testador = new Testador();
      resultado = testador.testa_primo(divisores);
      pagina = gerador.gerar_html(resultado, numero);
    } catch (NumberFormatException e) {
      pagina = gerador.gerar_html(resultado, numero);
    }
    return pagina;
  }
}
