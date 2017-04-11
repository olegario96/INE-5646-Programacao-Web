package Modelo;

import Modelo.Cidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-10T22:46:29")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> nome;
    public static volatile SingularAttribute<Pais, String> id;
    public static volatile ListAttribute<Pais, Cidade> cidades;

}