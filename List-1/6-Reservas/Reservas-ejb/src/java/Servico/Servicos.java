/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Execao.ExecaoPessoaNaoCadastrada;
import Execao.ExecaoPessoaEmOutroAssento;
import Execao.ExecaoAssentoNaoCadastrado;
import Execao.ExecaoAssentoJaOcupado;
import Modelo.Assento;
import Modelo.Pessoa;
import java.util.List;
import java.security.SecureRandom;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author olegario
 */
@Stateless
@LocalBean
public class Servicos {

    @PersistenceContext
    private EntityManager em;
    
    public void cadastraAssento(String numAssento, Long tempo) {
        Assento assento = new Assento(numAssento);
        em.persist(assento);
        dormir(tempo);
    }
    
    public void reservaAssento(Long idPessoa, String numAssento,
        Long tempo) throws ExecaoPessoaNaoCadastrada, ExecaoAssentoNaoCadastrado,
        ExecaoAssentoJaOcupado, ExecaoPessoaEmOutroAssento {
        
        Pessoa pessoa = em.find(Pessoa.class, idPessoa, LockModeType.PESSIMISTIC_WRITE);
        if (pessoa == null) {
            throw new ExecaoPessoaNaoCadastrada(idPessoa);
        }
        
        if (pessoa.getAssento() != null) {
            if (!(pessoa.getAssento().getNumero().equals(numAssento))) {
                throw new ExecaoPessoaEmOutroAssento(pessoa.getAssento().getNumero());
            }
        } else {
            String consulta;
            TypedQuery<Assento> query;
            Assento assento;
            
            consulta = "select assento from Assento assento where assento.numero = :numAssento";
            query = em.createQuery(consulta, Assento.class).setLockMode(LockModeType.PESSIMISTIC_WRITE);
            
            try {
                assento = query.setParameter("numAssento", numAssento).getSingleResult();
                if (assento.getPessoa() != null) {
                    throw new ExecaoAssentoJaOcupado();
                }
                pessoa.setAssento(assento);
                assento.setPessoa(pessoa);
            } catch (NoResultException e) {
                throw new ExecaoAssentoNaoCadastrado(numAssento);
            }
        }
        dormir(tempo);
    }
    
    public void liberaAssento(String numAssento, Long tempo) throws 
        ExecaoAssentoNaoCadastrado {
        
        String consulta;
        TypedQuery<Assento> query;
        Assento assento;
        
        consulta = "select assento from Assento assento where assento.numero = :numAssento";
        query = em.createQuery(consulta, Assento.class).setLockMode(LockModeType.PESSIMISTIC_WRITE);
        
        try {
            assento = query.setParameter("numAssento", numAssento).getSingleResult();
            if (assento.getPessoa() != null){
                assento.getPessoa().setAssento(null);
            }
            assento.setPessoa(null);
        } catch (NoResultException e) {
            throw new ExecaoAssentoNaoCadastrado(numAssento);
        }
        dormir(tempo);
    }
    
    public Assento procuraAssento(String numAssento, Long tempo) {
        String consulta;
        TypedQuery<Assento> query;
        Assento assento;
        
        consulta = "select assento from Assento assento where assento.numero = :numAssento";
        query = em.createQuery(consulta, Assento.class).setLockMode(LockModeType.OPTIMISTIC);
        
        try {
            assento = query.setParameter("numAssento", numAssento).getSingleResult();
        } catch (NoResultException e) {
            assento = null;
        }
        
        dormir(tempo);
        return assento;
    }
    
    public List<Assento> procuraTodosAssentos(Long tempo) {
        String query = "select a from Assento a order by a.id";
        return em.createQuery(query, Assento.class).getResultList();
    }
    
    public void cadastraPessoa(Long idPessoa, String nome, Long tempo) {
        Pessoa pessoa = new Pessoa(idPessoa, nome);
        em.persist(pessoa);
        dormir(tempo);
    }
    
    public Pessoa procuraPessoa(Long idPessoa, Long tempo) {
        String consulta;
        TypedQuery<Pessoa> query;
        Pessoa pessoa;
        
        consulta = "select pessoa from Pessoa pessoa where pessoa.id = :idPessoa";
        query = em.createQuery(consulta, Pessoa.class).setLockMode(LockModeType.PESSIMISTIC_READ);
        
        try {
            pessoa = query.setParameter("idPessoa", idPessoa).getSingleResult();
        } catch (NoResultException e) {
            pessoa = null;
        }
        
        dormir(tempo);
        return pessoa;
    }
    
    public List<Pessoa> procuraTodasPessoas(Long tempo) {
        String query = "select p from Pessoa p order by p.id";
        return em.createQuery(query, Pessoa.class).getResultList();
    }
    
    public void alteraNomePessoa(Long idPessoa, String nome, Long tempo) throws ExecaoPessoaNaoCadastrada{
        String consulta;
        TypedQuery<Pessoa> query;
        Pessoa pessoa;
        
        consulta = "select pessoa from Pessoa pessoa where pessoa.id = :idPessoa";
        query = em.createQuery(consulta, Pessoa.class).setLockMode(LockModeType.PESSIMISTIC_WRITE);
        
        try {
            pessoa = query.setParameter("idPessoa", idPessoa).getSingleResult();
            pessoa.setNome(nome);
        } catch (NoResultException e) {
            throw new ExecaoPessoaNaoCadastrada(idPessoa);
        }
        dormir(tempo);
    }
    
    public void removePessoa(Long idPessoa, Long tempo) throws ExecaoPessoaNaoCadastrada {
        String consulta;
        TypedQuery<Pessoa> query;
        Pessoa pessoa;
        
        consulta = "select pessoa from Pessoa pessoa where pessoa.id = :idPessoa";
        query = em.createQuery(consulta, Pessoa.class).setLockMode(LockModeType.PESSIMISTIC_WRITE);
        
        try {
            pessoa = query.setParameter("idPessoa", idPessoa).getSingleResult();
            if (pessoa.getAssento() != null) {
                 
           }
            em.remove(pessoa);
            dormir(tempo);
        } catch (NoResultException e) {
            dormir(tempo);
            throw new ExecaoPessoaNaoCadastrada(idPessoa);
        }
        
    }
    
    public void geraDados(int numPessoas, int numAssentos, Long tempo) {
        String generate;
        SecureRandom random = new SecureRandom();
        Pessoa[] pessoas = new Pessoa[numPessoas];
        Assento[] assentos = new Assento[numAssentos];
        
        apagueTudo(tempo);
        
        for (int i = 0; i < pessoas.length; ++i) {
            generate = new BigInteger(32, random).toString(16);
            pessoas[i] = new Pessoa(Long.valueOf(i), generate);
            cadastraPessoa(pessoas[i].getId(), pessoas[i].getNome(), tempo);
        }
        
        for (int i = 0; i < assentos.length; ++i) {
            generate = new BigInteger(16, random).toString(16);
            assentos[i] = new Assento(generate);
            cadastraAssento(assentos[i].getNumero(), tempo);
        }
        
        dormir(tempo);
   }
    
    private void dormir(Long tempo) {
        try {
            Thread.sleep(tempo * 1000);
        } catch (InterruptedException e) {
            
        }
    }
    
    public Assento pesquiseAssentoPorNumero(String numAssento, Long tempo) {
        String consulta;
        TypedQuery<Assento> q;
        Assento assento;
        
        consulta = "select assento from Assento assento where assento.numero = :numAssento";
        q = em.createQuery(consulta, Assento.class).setLockMode(LockModeType.PESSIMISTIC_READ);
        try {
            assento = q.setParameter("numAssento", numAssento).getSingleResult();
            dormir(tempo);
            return assento;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void apagueTudo(Long tempo) {
        String query1 = "select pessoa from Pessoa pessoa";
        String query2 = "select assento from Assento assento";
        
        List<Pessoa> pessoas = em.createQuery(query1, Pessoa.class).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
        List<Assento> assentos = em.createQuery(query2, Assento.class).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
        
        for (Pessoa pessoa: pessoas) {
            em.remove(pessoa);
        }
        for (Assento assento: assentos) {
            em.remove(assento);
        }
        dormir(tempo);
    }
}
