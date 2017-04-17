/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Assento;
import Servico.Servicos;
import Visao.GeradorPaginaRelatorAssento;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorRelatorAssento {

    public TratadorRelatorAssento() {
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        GeradorPaginaRelatorAssento gerador = new GeradorPaginaRelatorAssento();
        String numAssento = request.getParameter("campoNumeroAssento");
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        
        Assento assento = s.pesquiseAssentoPorNumero(numAssento, tempo);
        html = gerador.gerarPagina(assento);
        
        return html;
    }    
}
