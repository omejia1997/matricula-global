package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.Pais;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.DireccionPersona;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.DocumentoPersona;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.FamiliarPersona;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.HistTipoPersona;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.TipoDiscapacidad;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.TipoPersona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> estado;
    public static volatile SingularAttribute<Persona, String> audUsuario;
    public static volatile SingularAttribute<Persona, Integer> codPersona;
    public static volatile SingularAttribute<Persona, String> tipoIdentificacion;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, Short> porcentajeDiscapacidad;
    public static volatile SingularAttribute<Persona, TipoDiscapacidad> codTipoDiscapacidad;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> nombreCompleto;
    public static volatile SingularAttribute<Persona, String> nombre1;
    public static volatile ListAttribute<Persona, HistTipoPersona> histTipoPersonaList;
    public static volatile SingularAttribute<Persona, Pais> nacionalidad;
    public static volatile ListAttribute<Persona, DocumentoPersona> documentoPersonaList;
    public static volatile ListAttribute<Persona, DireccionPersona> direccionPersonaList;
    public static volatile SingularAttribute<Persona, Date> audFecha;
    public static volatile ListAttribute<Persona, FamiliarPersona> familiarPersonaList;
    public static volatile SingularAttribute<Persona, String> carnetConadis;
    public static volatile SingularAttribute<Persona, String> genero;
    public static volatile SingularAttribute<Persona, Pais> codPaisNacimiento;
    public static volatile SingularAttribute<Persona, String> requiereRepresentante;
    public static volatile SingularAttribute<Persona, String> codigoAlterno;
    public static volatile SingularAttribute<Persona, String> email;
    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile SingularAttribute<Persona, String> nombreComun;
    public static volatile ListAttribute<Persona, Matricula> matriculaList;
    public static volatile SingularAttribute<Persona, String> identificacion;
    public static volatile SingularAttribute<Persona, String> estadoCivil;
    public static volatile SingularAttribute<Persona, Integer> version;
    public static volatile SingularAttribute<Persona, String> extranjero;
    public static volatile SingularAttribute<Persona, String> emailAlterno;
    public static volatile SingularAttribute<Persona, String> discapacidad;
    public static volatile SingularAttribute<Persona, String> telefonoMovil;
    public static volatile SingularAttribute<Persona, String> audIp;
    public static volatile SingularAttribute<Persona, UbicacionGeografica> lugarNacimiento;
    public static volatile SingularAttribute<Persona, TipoPersona> codTipoPersona;

}