/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Cidade;
import Modelo.Pais;
import Modelo.Passageiro;
import Modelo.Viagem;
import java.util.List;

/**
 *
 * @author olegario
 */
public class GeradorPaginaRelator {
    
    private StringBuilder sb;
    
    public GeradorPaginaRelator() {
        this.sb = new StringBuilder("");
    }
    
    public String gerarPagina(List<Passageiro> passageiros, List<Cidade> cidades,
        List<Pais> paises, List<Viagem> viagens) {
        
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Servlet ServletRelator</title>");            
        sb.append("</head>");
        sb.append("<body>");
        
        sb.append("<h2>"+"Paises</h2>");
        sb.append("<ol>");
        for(Pais pais: paises) {
            sb.append("<li>").append(pais.getNome()).append("</li>");
        } 
        sb.append("</ol>");
        
        sb.append("<h2>"+"Cidades</h2>");
        sb.append("<ol>");
        for(Cidade cidade: cidades) {
            sb.append("<li>").append(cidade.getNome()).append("</li>");
        } 
        sb.append("</ol>");
        
        sb.append("<h2>"+"Viagens</h2>");
        sb.append("<ol>");
        for(Viagem viagem: viagens) {
            sb.append("<li>").append(viagem.toString()).append("</li>");
        } 
        sb.append("</ol>");
        
        sb.append("<h2>"+"Passageiros</h2>");
        sb.append("<ol>");
        for(Passageiro passageiro: passageiros) {
            sb.append("<li>").append(passageiro.getNome()).append("</li>");
        } 
        sb.append("</ol>");
        
        sb.append("</body>");
        sb.append("</html>");
        
        return sb.toString();
    }
}
