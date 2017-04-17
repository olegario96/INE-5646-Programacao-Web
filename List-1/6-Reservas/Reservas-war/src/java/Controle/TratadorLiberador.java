/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Execao.ExecaoAssentoNaoCadastrado;
import Servico.Servicos;
import Visao.GeradorPaginaLiberador;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorLiberador {

    public TratadorLiberador() {
    }

    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        boolean erro = false;
        String html;
        GeradorPaginaLiberador gerador = new GeradorPaginaLiberador();
        
        try {
            String numAssento = request.getParameter("campoNumeroAssento");
            Long tempo = Long.parseLong(request.getParameter("campoTempo"));
            s.liberaAssento(numAssento, tempo);
        } catch (ExecaoAssentoNaoCadastrado e) {
            erro = true;
        }
        
        html = gerador.gerarPagina(erro);
        return html; 
    }
}
