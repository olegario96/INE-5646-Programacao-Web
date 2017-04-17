/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Servico.Servicos;
import Visao.GeradorPaginaCadastradorPessoa;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorCadastradorPessoa {

    public TratadorCadastradorPessoa() {
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        GeradorPaginaCadastradorPessoa gerador = new GeradorPaginaCadastradorPessoa();
        String nome = request.getParameter("campoNomePessoa");
        Long id = Long.parseLong(request.getParameter("campoIdPessoa"));
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        
        s.cadastraPessoa(id, nome, tempo);
        html = gerador.gerarPagina();
        
        return html;
    }
}
