package entidades;

import entidades.Renta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T17:02:28")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, Date> fecha;
    public static volatile CollectionAttribute<Periodo, Renta> rentaCollection;
    public static volatile SingularAttribute<Periodo, Integer> id;

}