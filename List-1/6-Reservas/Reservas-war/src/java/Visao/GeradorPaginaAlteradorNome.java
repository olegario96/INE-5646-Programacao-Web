/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.awt.SystemColor;

/**
 *
 * @author olegario
 */
public class GeradorPaginaAlteradorNome {
    
    private StringBuilder sb;

    public GeradorPaginaAlteradorNome() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(Exception e) {
        String menssagem;
        
        if (e == null) {
            menssagem = "Nome alterado com sucesso!";
        } else {
            menssagem = "Este ID não está cadastrado!";
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
