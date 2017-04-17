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
public class GeradorPaginaLiberador {

    private StringBuilder sb;

    public GeradorPaginaLiberador() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(boolean erro) {
        String mensagem;
        if (erro) {
            mensagem = "O assento não está cadastrado!";
        } else {
            mensagem = "Assento liberado com sucesso!";
        }
        
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>INE 5646 - Turismo</title>");            
        sb.append("</head>");
        sb.append("<h1>");
        sb.append(mensagem);
        sb.append("</h1>");
        sb.append("</html>");
        
        return sb.toString();
    }  
}
