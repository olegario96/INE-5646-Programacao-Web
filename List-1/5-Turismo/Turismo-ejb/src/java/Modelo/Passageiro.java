/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author olegario
 */
@Entity
public class Passageiro implements Serializable {

    @Id
    private Long id;
    private String nome;
    
    public Passageiro() {
        
    }
    
    public Passageiro(String nome) {
        this.nome = nome;
    }
    
    @ManyToMany
    private List<Viagem> viagens;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Viagem> getViagens() {
        return viagens;
    }
    
    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
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
        if (!(object instanceof Passageiro)) {
            return false;
        }
        Passageiro other = (Passageiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ine5646.turismo.ejb.Passageiro[ id=" + id + " ]";
    }
    
}
