package Modelo;

import Modelo.Viagem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-10T22:46:29")
@StaticMetamodel(Passageiro.class)
public class Passageiro_ { 

    public static volatile ListAttribute<Passageiro, Viagem> viagens;
    public static volatile SingularAttribute<Passageiro, String> nome;
    public static volatile SingularAttribute<Passageiro, Long> id;

}