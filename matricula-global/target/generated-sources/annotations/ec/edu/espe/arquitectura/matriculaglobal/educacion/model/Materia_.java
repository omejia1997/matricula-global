package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Prerequisito;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, BigDecimal> horas;
    public static volatile SingularAttribute<Materia, BigDecimal> ponderacion;
    public static volatile ListAttribute<Materia, MallaCarrera> carreras;
    public static volatile ListAttribute<Materia, Nrc> nrcs;
    public static volatile SingularAttribute<Materia, MateriaPK> pk;
    public static volatile SingularAttribute<Materia, BigDecimal> creditos;
    public static volatile SingularAttribute<Materia, String> nombre;
    public static volatile ListAttribute<Materia, Prerequisito> prerequisitos;

}