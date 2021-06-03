package entidades;

import entidades.Billete;
import entidades.BilletesxrentaPK;
import entidades.Renta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T03:15:14")
@StaticMetamodel(Billetesxrenta.class)
public class Billetesxrenta_ { 

    public static volatile SingularAttribute<Billetesxrenta, BilletesxrentaPK> billetesxrentaPK;
    public static volatile SingularAttribute<Billetesxrenta, Integer> cantidad;
    public static volatile SingularAttribute<Billetesxrenta, Billete> billete;
    public static volatile SingularAttribute<Billetesxrenta, Renta> renta;

}