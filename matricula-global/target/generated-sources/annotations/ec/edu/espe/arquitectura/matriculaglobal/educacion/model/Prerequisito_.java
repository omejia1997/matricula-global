package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Prerequisito.class)
public class Prerequisito_ { 

    public static volatile SingularAttribute<Prerequisito, String> tipo;
    public static volatile SingularAttribute<Prerequisito, Integer> codPrerequisito;
    public static volatile SingularAttribute<Prerequisito, Materia> materia;
    public static volatile SingularAttribute<Prerequisito, Integer> codMateria;
    public static volatile SingularAttribute<Prerequisito, Materia> prerequisito;

}