package entidades;

import entidades.Carro;
import entidades.LineaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-04T09:43:56")
@StaticMetamodel(Linea.class)
public class Linea_ { 

    public static volatile SingularAttribute<Linea, LineaPK> lineaPK;
    public static volatile SingularAttribute<Linea, Carro> carroRentado;
    public static volatile SingularAttribute<Linea, Integer> carroid;
    public static volatile SingularAttribute<Linea, Integer> cantidad;

}