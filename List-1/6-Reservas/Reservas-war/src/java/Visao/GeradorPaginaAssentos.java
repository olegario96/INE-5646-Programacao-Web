/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Assento;
import java.util.List;

/**
 *
 * @author olegario
 */
public class GeradorPaginaAssentos {
    
    private StringBuilder sb;

    public GeradorPaginaAssentos() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(List<Assento> assentos) {
        String menssagem;
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>INE 5646 - Turismo</title>");            
        sb.append("</head>");
        
        for (Assento assento : assentos) {
            sb.append("<p>");
            menssagem = "Número do assento: "+assento.getNumero()+"<br/>";
            if (assento.getPessoa() != null) {
                menssagem += "Pessoa que reservou o assento: "+assento.getPessoa().getNome()+"<br/>";
            }
            sb.append(menssagem);
            sb.append("</p>");
            sb.append("<br/>");
        }
        
        sb.append("</h1>");
        sb.append("</html>");
        
        return sb.toString();
    }
}
