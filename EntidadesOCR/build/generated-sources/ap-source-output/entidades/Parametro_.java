package entidades;

import entidades.Renta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-04T08:14:00")
@StaticMetamodel(Parametro.class)
public class Parametro_ { 

    public static volatile CollectionAttribute<Parametro, Renta> rentaCollection;
    public static volatile SingularAttribute<Parametro, Integer> valor;
    public static volatile SingularAttribute<Parametro, Integer> tasacarros;
    public static volatile SingularAttribute<Parametro, Integer> id;

}