package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Departamento;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Carrera.class)
public class Carrera_ { 

    public static volatile SingularAttribute<Carrera, String> grado;
    public static volatile ListAttribute<Carrera, Matricula> matriculaList;
    public static volatile SingularAttribute<Carrera, String> nombre;
    public static volatile SingularAttribute<Carrera, Integer> totalSemestres;
    public static volatile ListAttribute<Carrera, MallaCarrera> mallaCarrera;
    public static volatile SingularAttribute<Carrera, Integer> codCarrera;
    public static volatile SingularAttribute<Carrera, String> modalidad;
    public static volatile SingularAttribute<Carrera, BigDecimal> totalHoras;
    public static volatile SingularAttribute<Carrera, String> siglas;
    public static volatile SingularAttribute<Carrera, Departamento> departamento;
    public static volatile SingularAttribute<Carrera, BigDecimal> totalCreditos;
    public static volatile SingularAttribute<Carrera, BigDecimal> precioCredito;
    public static volatile SingularAttribute<Carrera, String> nivel;
    public static volatile SingularAttribute<Carrera, String> perfilProfesional;

}