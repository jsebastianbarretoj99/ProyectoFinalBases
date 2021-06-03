package entidades;

import entidades.Linea;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T03:15:14")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile CollectionAttribute<Carro, Linea> lineaCollection;
    public static volatile SingularAttribute<Carro, Integer> precio;
    public static volatile SingularAttribute<Carro, Integer> puestos;
    public static volatile SingularAttribute<Carro, Integer> unidadesdisponibles;
    public static volatile SingularAttribute<Carro, Integer> id;
    public static volatile SingularAttribute<Carro, String> placa;

}