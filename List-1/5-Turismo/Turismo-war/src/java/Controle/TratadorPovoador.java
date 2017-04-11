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
import Visao.GeradorPaginaPovoador;
import java.util.List;

/**
 *
 * @author olegario
 */
public class TratadorPovoador {
    
    public TratadorPovoador() {
        
    }
    
    public String tratarResiquicao(BeanSessao bs) {
        GeradorPaginaPovoador gerador = new GeradorPaginaPovoador();
        
        povoarPaises(bs);
        povoarCidades(bs);
        povoarPassageiros(bs);
        povoarViagens(bs);
        
        return gerador.gerarPagina();
    }
    
    public void povoarPaises(BeanSessao bs) {
        bs.guardaPais(new Pais("BRA", "Brasil"));
        bs.guardaPais(new Pais("FRA", "França"));
        bs.guardaPais(new Pais("EUA", "Estados Unidos da América"));
    }
    
    public void povoarCidades(BeanSessao bs) {
        Cidade cidade;
        Pais brasil = bs.encontraPaisId("BRA");
        Pais franca = bs.encontraPaisId("FRA");
        Pais eua = bs.encontraPaisId("EUA");
        
        cidade = new Cidade("Rio de Janeiro");
        brasil.adicionaCidade(cidade);
        bs.guardaCidade(cidade);
        
        cidade = new Cidade("Paris");
        franca.adicionaCidade(cidade);
        bs.guardaCidade(cidade);
        
        cidade = new Cidade("New York");
        eua.adicionaCidade(cidade);
        bs.guardaCidade(cidade);
    } 
    
    public void povoarViagens(BeanSessao bs) {
        Cidade rio = bs.encontraCidadeNome("Rio de Janeiro");
        Cidade paris = bs.encontraCidadeNome("Paris");
        Viagem viagem;
        
        viagem = new Viagem(3, 500);
        viagem.setCidade(rio);
        bs.guardaViagem(viagem);
        
        viagem = new Viagem(5, 1000);
        viagem.setCidade(paris);;
        bs.guardaViagem(viagem);
    }
    
    public void povoarPassageiros(BeanSessao bs) {
        Passageiro passageiro = new Passageiro("Fulano de Tal");
        passageiro.setId(1010L);
        bs.guardaPassageiro(passageiro);
        
        passageiro = new Passageiro("Irmão do Fulano de Tal");
        passageiro.setId(2010L);
        bs.guardaPassageiro(passageiro);
        
        passageiro = new Passageiro("Beltrano Amarento");
        passageiro.setId(3010L);
        bs.guardaPassageiro(passageiro);
    }
    
    public void agendarViagens(BeanSessao bs) {
        List<Viagem> viagens = bs.encontreTodasViagens();
        Long idViagem1 = viagens.get(0).getId();
        Long idViagem2 = viagens.get(1).getId();
        
        bs.agendaViagem(1010L, idViagem1);
        bs.agendaViagem(1010L, idViagem2);
        bs.agendaViagem(2010L, idViagem1);
    }
    
}
