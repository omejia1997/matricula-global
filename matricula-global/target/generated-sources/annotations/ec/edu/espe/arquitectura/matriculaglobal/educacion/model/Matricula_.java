package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Periodo;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Date> fecha;
    public static volatile SingularAttribute<Matricula, String> tipo;
    public static volatile SingularAttribute<Matricula, Persona> persona;
    public static volatile SingularAttribute<Matricula, Integer> codPersona;
    public static volatile SingularAttribute<Matricula, Double> costo;
    public static volatile SingularAttribute<Matricula, Integer> codCarrera;
    public static volatile SingularAttribute<Matricula, Carrera> Carrera;
    public static volatile ListAttribute<Matricula, MatriculaNrc> matriculaNrc;
    public static volatile SingularAttribute<Matricula, Integer> codPeriodo;
    public static volatile SingularAttribute<Matricula, MatriculaPK> pk;
    public static volatile SingularAttribute<Matricula, Periodo> Periodo;

}