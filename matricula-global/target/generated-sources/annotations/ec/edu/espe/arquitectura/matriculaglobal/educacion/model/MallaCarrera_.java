package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(MallaCarrera.class)
public class MallaCarrera_ { 

    public static volatile SingularAttribute<MallaCarrera, Integer> codMateriacarrera;
    public static volatile SingularAttribute<MallaCarrera, Integer> codCarrera;
    public static volatile SingularAttribute<MallaCarrera, Materia> materia;
    public static volatile SingularAttribute<MallaCarrera, Carrera> carrera;
    public static volatile SingularAttribute<MallaCarrera, Integer> nivel;

}