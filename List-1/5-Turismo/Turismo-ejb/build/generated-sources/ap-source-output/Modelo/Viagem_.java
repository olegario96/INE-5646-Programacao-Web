package Modelo;

import Modelo.Cidade;
import Modelo.Passageiro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-10T22:46:29")
@StaticMetamodel(Viagem.class)
public class Viagem_ { 

    public static volatile SingularAttribute<Viagem, Integer> preco;
    public static volatile SingularAttribute<Viagem, Cidade> cidade;
    public static volatile SingularAttribute<Viagem, Integer> numDias;
    public static volatile SingularAttribute<Viagem, Long> id;
    public static volatile ListAttribute<Viagem, Passageiro> passageiros;

}