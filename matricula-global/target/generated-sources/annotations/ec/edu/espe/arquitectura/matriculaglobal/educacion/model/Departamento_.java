package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> descripcion;
    public static volatile ListAttribute<Departamento, Carrera> carreras;
    public static volatile SingularAttribute<Departamento, Integer> codDepartamento;
    public static volatile SingularAttribute<Departamento, String> siglas;
    public static volatile SingularAttribute<Departamento, String> nombre;

}