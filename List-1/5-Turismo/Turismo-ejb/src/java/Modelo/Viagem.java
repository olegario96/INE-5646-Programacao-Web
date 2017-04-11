/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author olegario
 */
@Entity
public class Viagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numDias;
    private Integer preco;

    public Viagem() {
    }
    
    
    public Viagem(Integer numDias, Integer preco) {
        this.numDias = numDias;
        this.preco = preco;
    }
    
    @ManyToMany
    List<Passageiro> passageiros;
    
    @ManyToOne
    Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getNumDias() {
        return numDias;
    }
    
    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
    }
    
    public Integer getPreco() {
        return preco;
    }
    
    public void setPreco(Integer preco) {
        this.preco = preco;
    }
    
    public List<Passageiro> getPassageiros() {
        return passageiros;
    }
    
    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }
    
    public Cidade getCidade() {
        return cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    } 
    
    public void adicionaPassageiro(Passageiro passageiro) {
        this.passageiros.add(passageiro);
        List<Viagem> viagens = passageiro.getViagens();
        viagens.add(this);
        passageiro.setViagens(viagens);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viagem)) {
            return false;
        }
        Viagem other = (Viagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ine5646.turismo.ejb.Viagem[ id=" + id + " ]";
    }
    
}
