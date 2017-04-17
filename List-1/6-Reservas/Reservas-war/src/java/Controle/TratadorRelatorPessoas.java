package Controle;


import Modelo.Pessoa;
import Servico.Servicos;
import Visao.GeradorPaginaPessoas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olegario
 */
public class TratadorRelatorPessoas {

    public TratadorRelatorPessoas() {
    }
    
    public String tratadorRequisicao(Servicos s, HttpServletRequest request) {
        String html;
        Long tempo = Long.parseLong(request.getParameter("campoTempo"));
        GeradorPaginaPessoas gerador = new GeradorPaginaPessoas();
        List<Pessoa> pessoas = s.procuraTodasPessoas(tempo);
        
        html = gerador.gerarPagina(pessoas);
        return html;
    }
}
