/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author olegario
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    private Long id;
    @Column(length=30, nullable=false)
    private String nome;
    
    @OneToOne(mappedBy = "pessoa")
    private Assento assento;
    
    public Pessoa() {
        
    }
    
    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }    

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
    
    public Assento getAssento() {
        return assento;
    }
    
    public void setAssento(Assento assento) {
        this.assento = assento;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Pessoa[ id=" + id + " ]";
    }
    
}
