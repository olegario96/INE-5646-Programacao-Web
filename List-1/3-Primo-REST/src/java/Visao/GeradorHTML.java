/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

/**
 *
 * @author olegario
 */
public class GeradorHTML {
  private final String green = "green";
  private final String red = "red";
  private final String orange = "orange";
    
  public GeradorHTML() {
        
  }
  
  public String gerar_html(Boolean primo, String numero) {
    StringBuilder sb = new StringBuilder();
    
    sb.append("<!DOCTYPE html>");
    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>INE5646 - Primo - versão REST</title>");
    sb.append("</head>");
    sb.append("<body>");
    sb.append("<h1>INE5646 - primo</h1>");
    sb.append(gerar_mensagem(primo, numero));
    sb.append("</body>");
    sb.append("</html>");
    
    return sb.toString();
  }
    
  public String gerar_mensagem(Boolean primo, String numero) {
    String cor;
    String msg;
    StringBuilder sb = new StringBuilder("");
        
    if (primo == null) {
      cor = this.red;
      msg = "Isto não é um número!";
    } else if (primo) {
      cor = this.orange;
      msg = "Este não é um número primo!";
    } else {
      cor = this.green;
      msg = "Este é um número primo!";
    }
    
    return sb.append("<h2 style='color : ").append(cor).append("'>").append(numero).append(" : ").append(msg).append("</h2>").toString();
  }
}
