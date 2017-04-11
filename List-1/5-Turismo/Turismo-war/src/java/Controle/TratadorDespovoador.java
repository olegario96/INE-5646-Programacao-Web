/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.GeradorPaginaDespovoador;

/**
 *
 * @author olegario
 */
public class TratadorDespovoador {
    
    public TratadorDespovoador() {
        
    }
    
    public String tratarResiquicao(BeanSessao bs) {
        GeradorPaginaDespovoador gerador = new GeradorPaginaDespovoador();
        
        apagarDados(bs);
        
        return gerador.gerarPagina();
    }
    
    public void apagarDados(BeanSessao bs) {
        bs.apagaDados();
    }
}
