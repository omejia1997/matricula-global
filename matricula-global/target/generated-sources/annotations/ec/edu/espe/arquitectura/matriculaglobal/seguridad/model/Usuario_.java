package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile SingularAttribute<Usuario, String> codUsuario;
    public static volatile SingularAttribute<Usuario, String> audUsuario;
    public static volatile SingularAttribute<Usuario, String> mail;
    public static volatile ListAttribute<Usuario, UsuarioPerfil> usuarioPerfilList;
    public static volatile SingularAttribute<Usuario, String> origen;
    public static volatile SingularAttribute<Usuario, Short> nroIntentosFallidos;
    public static volatile SingularAttribute<Usuario, Date> fechaUltimaSesion;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> version;
    public static volatile SingularAttribute<Usuario, Date> fechaCambioClave;
    public static volatile SingularAttribute<Usuario, Date> audFecha;
    public static volatile SingularAttribute<Usuario, Date> fechaCreacion;
    public static volatile SingularAttribute<Usuario, String> audIp;
    public static volatile SingularAttribute<Usuario, String> telefono;

}