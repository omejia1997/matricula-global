package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import ec.edu.espe.arquitectura.matriculaglobal.persona.model.DocumentoPersonaPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.TipoDocumento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(DocumentoPersona.class)
public class DocumentoPersona_ { 

    public static volatile SingularAttribute<DocumentoPersona, Date> fechaCaducidad;
    public static volatile SingularAttribute<DocumentoPersona, String> estado;
    public static volatile SingularAttribute<DocumentoPersona, String> digitalizado;
    public static volatile SingularAttribute<DocumentoPersona, String> audUsuario;
    public static volatile SingularAttribute<DocumentoPersona, Persona> persona;
    public static volatile SingularAttribute<DocumentoPersona, Date> fechaRegistro;
    public static volatile SingularAttribute<DocumentoPersona, Date> fechaEmision;
    public static volatile SingularAttribute<DocumentoPersona, Integer> version;
    public static volatile SingularAttribute<DocumentoPersona, String> url;
    public static volatile SingularAttribute<DocumentoPersona, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<DocumentoPersona, Date> audFecha;
    public static volatile SingularAttribute<DocumentoPersona, String> archivado;
    public static volatile SingularAttribute<DocumentoPersona, String> audIp;
    public static volatile SingularAttribute<DocumentoPersona, DocumentoPersonaPK> pk;

}