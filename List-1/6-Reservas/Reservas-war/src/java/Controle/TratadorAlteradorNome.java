/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Execao.ExecaoPessoaNaoCadastrada;
import Servico.Servicos;
import Visao.GeradorPaginaAlteradorNome;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorAlteradorNome {

    public TratadorAlteradorNome() {
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        GeradorPaginaAlteradorNome gerador = new GeradorPaginaAlteradorNome();
        String nome = request.getParameter("campoNovoNome");
        Long id = Long.parseLong(request.getParameter("campoIdPessoa"));
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        
        try {
            s.alteraNomePessoa(id, nome, tempo);
            html = gerador.gerarPagina(null);
        } catch (ExecaoPessoaNaoCadastrada ex) {
            html = gerador.gerarPagina(ex);
        }
        
        return html;
    }
}
