package entidades;

import entidades.Billetesxrenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T03:15:14")
@StaticMetamodel(Billete.class)
public class Billete_ { 

    public static volatile SingularAttribute<Billete, Integer> denominacion;
    public static volatile SingularAttribute<Billete, Integer> id;
    public static volatile SingularAttribute<Billete, Integer> cantidad;
    public static volatile CollectionAttribute<Billete, Billetesxrenta> billetesxrentaCollection;

}