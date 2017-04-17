/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Execao.ExecaoPessoaNaoCadastrada;
import Servico.Servicos;
import Visao.GeradorPaginaDeletador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorDeletador {

    public TratadorDeletador() {
    }
   
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        GeradorPaginaDeletador gerador = new GeradorPaginaDeletador();
        Long id = Long.parseLong(request.getParameter("campoIdPessoa"));
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        try {
            s.removePessoa(id, tempo);
            html = gerador.gerarPagina(null);
        } catch (ExecaoPessoaNaoCadastrada ex) {
            html = gerador.gerarPagina(ex);
        }
        
        return html;
    }
}
