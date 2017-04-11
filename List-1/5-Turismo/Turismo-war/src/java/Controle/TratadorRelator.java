/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cidade;
import Modelo.Pais;
import Modelo.Passageiro;
import Modelo.Viagem;
import Visao.GeradorPaginaRelator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author olegario
 */
public class TratadorRelator {

    public TratadorRelator() {
    }
    
    public String tratarResiquicao(BeanSessao bs) {
        List<Passageiro> passgeiros = bs.encontreTodosPassageiros();
        List<Viagem> viagens = bs.encontreTodasViagens();
        List<Pais> paises = bs.encontreTodosPaises();
        List<Cidade> cidades = bs.encontreTodasCidades();
        
        GeradorPaginaRelator gerador = new GeradorPaginaRelator();
        String html = gerador.gerarPagina(passgeiros, cidades, paises, viagens);
        return html;
    }
}
