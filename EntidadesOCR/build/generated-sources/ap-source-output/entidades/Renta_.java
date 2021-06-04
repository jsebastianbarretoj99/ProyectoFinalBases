package entidades;

import entidades.Billete;
import entidades.Linea;
import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-04T09:43:56")
@StaticMetamodel(Renta.class)
public class Renta_ { 

    public static volatile ListAttribute<Renta, Linea> lineas;
    public static volatile SingularAttribute<Renta, Date> fecha;
    public static volatile SingularAttribute<Renta, Integer> parametroid;
    public static volatile SingularAttribute<Renta, Integer> numero;
    public static volatile SingularAttribute<Renta, Time> hora;
    public static volatile ListAttribute<Renta, Billete> pagoBilletes;

}