package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrcPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(MatriculaNrc.class)
public class MatriculaNrc_ { 

    public static volatile SingularAttribute<MatriculaNrc, String> estado;
    public static volatile SingularAttribute<MatriculaNrc, Short> numero;
    public static volatile SingularAttribute<MatriculaNrc, BigDecimal> costo;
    public static volatile ListAttribute<MatriculaNrc, Calificacion> calificaciones;
    public static volatile SingularAttribute<MatriculaNrc, Matricula> matricula;
    public static volatile SingularAttribute<MatriculaNrc, MatriculaNrcPK> pk;
    public static volatile SingularAttribute<MatriculaNrc, Nrc> nrc;

}