/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Assento;

/**
 *
 * @author olegario
 */
public class GeradorPaginaRelatorAssento {
    
    StringBuilder sb;

    public GeradorPaginaRelatorAssento() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(Assento assento) {
        String menssagem = null;
        
        if (assento == null) {
            menssagem = "O asssento informado não existe";
        } else{ 
            menssagem = "Número do assento: "+assento.getNumero()+"<br/>";
            if (assento.getPessoa() != null) {
                menssagem += "Pessoa que reservou o assento: "+assento.getPessoa().getNome();
            }
        }
        
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>INE 5646 - Turismo</title>");            
        sb.append("</head>");
        sb.append("<h1>");
        sb.append(menssagem);
        sb.append("</h1>");
        sb.append("</html>");
        
        return sb.toString();
    }
    
}
