/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Servico.Servicos;
import Visao.GeradorPaginaCadastradorAssento;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorServletCadastradorAssento {

    public TratadorServletCadastradorAssento() {
        
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        boolean erro = false;
        String html;
        String numeroAssento = request.getParameter("campoNumeroAssento");
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        GeradorPaginaCadastradorAssento gerador = new GeradorPaginaCadastradorAssento();
        
        try {
            s.cadastraAssento(numeroAssento, tempo);
            html = gerador.gerarPagina(erro);
        } catch (Exception e) {
            html = gerador.gerarPagina(erro);
        }
        
        return html;
    }
}
