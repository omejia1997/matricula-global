package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, Date> fechaInicio;
    public static volatile SingularAttribute<Periodo, Integer> codPeriodo;
    public static volatile SingularAttribute<Periodo, String> nombre;
    public static volatile SingularAttribute<Periodo, String> nivel;
    public static volatile SingularAttribute<Periodo, Date> fechaFin;
    public static volatile SingularAttribute<Periodo, Short> parciales;

}