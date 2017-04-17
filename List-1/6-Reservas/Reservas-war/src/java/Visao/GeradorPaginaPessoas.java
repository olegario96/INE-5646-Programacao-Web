/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Pessoa;
import java.util.List;

/**
 *
 * @author olegario
 */
public class GeradorPaginaPessoas {
    
    StringBuilder sb;

    public GeradorPaginaPessoas() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(List<Pessoa> pessoas) {
        String menssagem;
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>INE 5646 - Turismo</title>");            
        sb.append("</head>");
        
        for (Pessoa pessoa : pessoas) {
            sb.append("<p>");
            menssagem = "Nome: "+pessoa.getNome()+"<br/>";
            if (pessoa.getAssento() != null){
                menssagem += "Assento: "+pessoa.getAssento().getNumero()+"<br/>";
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
