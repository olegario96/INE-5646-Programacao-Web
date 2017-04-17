/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execao;

/**
 *
 * @author olegario
 */
public class ExecaoPessoaEmOutroAssento extends Exception {
    
    private String numAssento;
    
    public ExecaoPessoaEmOutroAssento(String numAssento) {
        this.numAssento = numAssento;
    }
}
