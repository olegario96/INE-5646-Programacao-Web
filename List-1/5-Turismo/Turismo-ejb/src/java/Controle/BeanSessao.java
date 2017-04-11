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
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author olegario
 */
@Stateless
@LocalBean
public class BeanSessao {

    @PersistenceContext
    private EntityManager em;
    
    public Pais guardaPais(Pais p) {
        em.persist(p);
        return p;
    }
    
    public Cidade guardaCidade(Cidade c) {
        em.persist(c);
        return c;
    }
    
    public Viagem guardaViagem(Viagem v) {
        em.persist(v);
        return v;
    }
    
    public Passageiro guardaPassageiro(Passageiro p) {
        em.persist(p);
        return p;
    }
    
    public Pais encontraPaisId(String id) {
        return em.find(Pais.class, id);
    }
    
    public Cidade encontraCidadeNome(String nome) {
        final String query = "select c from Cidade c where c.nome = :nome";
        
        try {
            Cidade c = em.createQuery(query, Cidade.class).setParameter("nome", nome).getSingleResult();
            return c;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void agendaViagem(Long idPassageiro, Long idViagem) {
        Passageiro p = em.find(Passageiro.class, idPassageiro);
        Viagem v = em.find(Viagem.class, idViagem);
        v.adicionaPassageiro(p);
    }
    
    public List<Pais> encontreTodosPaises() {
        String query = "select p from Pais p order by p.nome";
        return em.createQuery(query, Pais.class).getResultList();
    }
    
    public List<Cidade> encontreTodasCidades() {
        String query = "select c from Cidade c order by c.pais.nome";
        return em.createQuery(query, Cidade.class).getResultList();
    }
    
    public List<Viagem> encontreTodasViagens() {
        String query = "select v from Viagem v order by v.id";
        return em.createQuery(query, Viagem.class).getResultList();
    }
    
    public List<Passageiro> encontreTodosPassageiros() {
        String query = "select p from Passageiro p order by p.id";
        return em.createQuery(query, Passageiro.class).getResultList();
    }
    
    public void apagaDados() {
        String[] querys = {"delete from Passageiro", "delete from Viagem", 
                           "delete from Cidade", "delete from Pais"};
        
        for (int i = 0; i < querys.length; ++i) {
            em.createQuery(querys[i]).executeUpdate();
        }
    }
}
