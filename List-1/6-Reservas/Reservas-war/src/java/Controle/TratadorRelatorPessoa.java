/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Pessoa;
import Servico.Servicos;
import Visao.GeradorPaginaRelatorPessoa;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorRelatorPessoa {

    public TratadorRelatorPessoa() {
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        GeradorPaginaRelatorPessoa gerador = new GeradorPaginaRelatorPessoa();
        Long id = Long.parseLong(request.getParameter("campoIdPessoa"));
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        
        Pessoa pessoa = s.procuraPessoa(id, tempo);
        html = gerador.gerarPagina(pessoa);
        
        return html;
    }
}
