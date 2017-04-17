/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Execao.ExecaoAssentoJaOcupado;
import Execao.ExecaoAssentoNaoCadastrado;
import Execao.ExecaoPessoaEmOutroAssento;
import Execao.ExecaoPessoaNaoCadastrada;

/**
 *
 * @author olegario
 */
public class GeradorPaginaReservador {

    private StringBuilder sb;

    public GeradorPaginaReservador() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(Exception e) {
        String mensagem = "";
        
        if (e == null) {
            mensagem = "Reserva efetuada com sucesso!";
        } else {
            if (e instanceof ExecaoAssentoJaOcupado) {
                mensagem = "O assento já está ocupado!";
            } else if (e instanceof ExecaoAssentoNaoCadastrado) {
                mensagem = "O assento não está cadastrado!";
            } else if (e instanceof ExecaoPessoaEmOutroAssento) {
               mensagem = "Essa pessoa já está cadastrada em outro assento!";
            } else if (e instanceof ExecaoPessoaNaoCadastrada) {
               mensagem = "Essa pessoa não está cadastrada!";
            }
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
