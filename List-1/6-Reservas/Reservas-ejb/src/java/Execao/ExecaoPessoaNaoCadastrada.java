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
public class ExecaoPessoaNaoCadastrada extends Exception {
    
    private Long idPessoa;
    
    public ExecaoPessoaNaoCadastrada(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}
