package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import ec.edu.espe.arquitectura.matriculaglobal.persona.model.FamiliarPersonaPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(FamiliarPersona.class)
public class FamiliarPersona_ { 

    public static volatile SingularAttribute<FamiliarPersona, String> audUsuario;
    public static volatile SingularAttribute<FamiliarPersona, Persona> persona;
    public static volatile SingularAttribute<FamiliarPersona, Date> audFecha;
    public static volatile SingularAttribute<FamiliarPersona, String> tipoIdentificacion;
    public static volatile SingularAttribute<FamiliarPersona, Date> fechaNacimiento;
    public static volatile SingularAttribute<FamiliarPersona, String> identificacion;
    public static volatile SingularAttribute<FamiliarPersona, String> tipoFamiliar;
    public static volatile SingularAttribute<FamiliarPersona, String> audIp;
    public static volatile SingularAttribute<FamiliarPersona, FamiliarPersonaPK> pk;
    public static volatile SingularAttribute<FamiliarPersona, String> telefono;
    public static volatile SingularAttribute<FamiliarPersona, String> nombre;
    public static volatile SingularAttribute<FamiliarPersona, Integer> version;

}