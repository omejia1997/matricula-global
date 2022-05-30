package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import ec.edu.espe.arquitectura.matriculaglobal.persona.model.HistTipoPersonaPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.TipoPersona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(HistTipoPersona.class)
public class HistTipoPersona_ { 

    public static volatile SingularAttribute<HistTipoPersona, String> audUsuario;
    public static volatile SingularAttribute<HistTipoPersona, Persona> persona;
    public static volatile SingularAttribute<HistTipoPersona, TipoPersona> tipoPersona;
    public static volatile SingularAttribute<HistTipoPersona, Date> audFecha;
    public static volatile SingularAttribute<HistTipoPersona, Date> fechaInicio;
    public static volatile SingularAttribute<HistTipoPersona, String> codUsuarioFin;
    public static volatile SingularAttribute<HistTipoPersona, String> audIp;
    public static volatile SingularAttribute<HistTipoPersona, HistTipoPersonaPK> pk;
    public static volatile SingularAttribute<HistTipoPersona, String> codUsuarioIni;
    public static volatile SingularAttribute<HistTipoPersona, Date> fechaFin;
    public static volatile SingularAttribute<HistTipoPersona, Integer> version;

}