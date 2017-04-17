/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Assento;
import Servico.Servicos;
import Visao.GeradorPaginaAssentos;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class TratadorRelatorAssentos {

    public TratadorRelatorAssentos() {
    }
    
    public String tratarRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        GeradorPaginaAssentos gerador = new GeradorPaginaAssentos();
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        List<Assento> assentos = s.procuraTodosAssentos(tempo);
        
        html = gerador.gerarPagina(assentos);
        
        return html;
    }
}
