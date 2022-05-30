package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfilPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(UsuarioPerfil.class)
public class UsuarioPerfil_ { 

    public static volatile SingularAttribute<UsuarioPerfil, String> audUsuario;
    public static volatile SingularAttribute<UsuarioPerfil, Date> audFecha;
    public static volatile SingularAttribute<UsuarioPerfil, String> audIp;
    public static volatile SingularAttribute<UsuarioPerfil, Usuario> usuario;
    public static volatile SingularAttribute<UsuarioPerfil, UsuarioPerfilPK> pk;
    public static volatile SingularAttribute<UsuarioPerfil, Integer> version;
    public static volatile SingularAttribute<UsuarioPerfil, Perfil> perfil;

}