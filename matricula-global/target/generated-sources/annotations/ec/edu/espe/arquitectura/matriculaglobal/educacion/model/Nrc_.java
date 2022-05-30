package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Periodo;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Nrc.class)
public class Nrc_ { 

    public static volatile SingularAttribute<Nrc, Short> cupoDisponible;
    public static volatile SingularAttribute<Nrc, Integer> codPersona;
    public static volatile SingularAttribute<Nrc, Persona> Persona;
    public static volatile SingularAttribute<Nrc, Periodo> periodo;
    public static volatile ListAttribute<Nrc, MatriculaNrc> matriculaNrc;
    public static volatile ListAttribute<Nrc, NrcHorario> nrcHorario;
    public static volatile SingularAttribute<Nrc, Short> cupoRegistrado;
    public static volatile SingularAttribute<Nrc, Integer> codPeriodo;
    public static volatile SingularAttribute<Nrc, Materia> materia;
    public static volatile SingularAttribute<Nrc, NrcPK> pk;
    public static volatile SingularAttribute<Nrc, String> nombre;
    public static volatile SingularAttribute<Nrc, Integer> codMateria;

}