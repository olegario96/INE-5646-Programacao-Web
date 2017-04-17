/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Execao.ExecaoAssentoJaOcupado;
import Execao.ExecaoAssentoNaoCadastrado;
import Execao.ExecaoPessoaEmOutroAssento;
import Execao.ExecaoPessoaNaoCadastrada;
import Servico.Servicos;
import Visao.GeradorPaginaReservador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorReservador {

    public TratadorReservador() {
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        
            String html;
            GeradorPaginaReservador gerador = new GeradorPaginaReservador();
        try {
            
            Long id = Long.parseLong(request.getParameter("campoIdPessoa"));
            String numAssento = request.getParameter("campoNumeroAssento");
            Long tempo = Long.parseLong(request.getParameter("campoTempo"));
            s.reservaAssento(id, numAssento, tempo);
            html = gerador.gerarPagina(null);
        } catch (ExecaoPessoaNaoCadastrada | ExecaoAssentoNaoCadastrado | ExecaoAssentoJaOcupado | ExecaoPessoaEmOutroAssento ex) {
            Logger.getLogger(TratadorReservador.class.getName()).log(Level.SEVERE, null, ex);
            html = gerador.gerarPagina(ex);
        }
        
        return html;
    }
    
}
