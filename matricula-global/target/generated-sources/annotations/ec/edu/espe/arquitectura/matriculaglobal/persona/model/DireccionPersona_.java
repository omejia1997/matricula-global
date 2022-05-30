package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import ec.edu.espe.arquitectura.matriculaglobal.persona.model.DireccionPersonaPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(DireccionPersona.class)
public class DireccionPersona_ { 

    public static volatile SingularAttribute<DireccionPersona, String> barrio;
    public static volatile SingularAttribute<DireccionPersona, String> audUsuario;
    public static volatile SingularAttribute<DireccionPersona, Persona> persona;
    public static volatile SingularAttribute<DireccionPersona, String> direccionAdicional;
    public static volatile SingularAttribute<DireccionPersona, String> callePrincipal;
    public static volatile SingularAttribute<DireccionPersona, String> numeracion;
    public static volatile SingularAttribute<DireccionPersona, Integer> version;
    public static volatile SingularAttribute<DireccionPersona, String> principal;
    public static volatile SingularAttribute<DireccionPersona, Integer> codOrgGeoDireccion;
    public static volatile SingularAttribute<DireccionPersona, Date> audFecha;
    public static volatile SingularAttribute<DireccionPersona, String> audIp;
    public static volatile SingularAttribute<DireccionPersona, DireccionPersonaPK> pk;
    public static volatile SingularAttribute<DireccionPersona, String> telefono;
    public static volatile SingularAttribute<DireccionPersona, String> calleSecundaria;
    public static volatile SingularAttribute<DireccionPersona, String> codTipoDireccion;
    public static volatile SingularAttribute<DireccionPersona, String> referencia;

}