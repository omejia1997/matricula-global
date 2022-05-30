package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Funcionalidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Modulo.class)
public class Modulo_ { 

    public static volatile SingularAttribute<Modulo, String> estado;
    public static volatile SingularAttribute<Modulo, String> codModulo;
    public static volatile ListAttribute<Modulo, Funcionalidad> funcionalidadList;
    public static volatile SingularAttribute<Modulo, String> nombre;
    public static volatile SingularAttribute<Modulo, Integer> version;

}