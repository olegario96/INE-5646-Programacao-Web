/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Pessoa;

/**
 *
 * @author olegario
 */
public class GeradorPaginaRelatorPessoa {
    
    private StringBuilder sb;

    public GeradorPaginaRelatorPessoa() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(Pessoa pessoa) {
        String menssagem;
        
        if (pessoa == null) {
            menssagem = "A pessoa informada não existe";
        } else{ 
            menssagem = "Nome da pessoa: "+pessoa.getNome()+"<br/>";
            if (pessoa.getAssento() != null) {
                menssagem += "Assento reservado: "+pessoa.getAssento().getNumero();
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
