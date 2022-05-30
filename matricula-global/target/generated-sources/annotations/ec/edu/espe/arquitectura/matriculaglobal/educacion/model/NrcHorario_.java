package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorarioPK;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Aula;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(NrcHorario.class)
public class NrcHorario_ { 

    public static volatile SingularAttribute<NrcHorario, Date> horaFin;
    public static volatile SingularAttribute<NrcHorario, Integer> codAula;
    public static volatile SingularAttribute<NrcHorario, String> diaSemana;
    public static volatile SingularAttribute<NrcHorario, Aula> aula;
    public static volatile SingularAttribute<NrcHorario, NrcHorarioPK> pk;
    public static volatile SingularAttribute<NrcHorario, Integer> codMateria;
    public static volatile SingularAttribute<NrcHorario, Date> horaInicio;
    public static volatile SingularAttribute<NrcHorario, Nrc> nrc;

}