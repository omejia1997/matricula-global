package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, String> estado;
    public static volatile SingularAttribute<Perfil, String> audUsuario;
    public static volatile SingularAttribute<Perfil, String> codPerfil;
    public static volatile SingularAttribute<Perfil, Date> audFecha;
    public static volatile ListAttribute<Perfil, UsuarioPerfil> usuarioPerfilList;
    public static volatile ListAttribute<Perfil, PerfilFuncionalidad> perfilFuncionalidadList;
    public static volatile SingularAttribute<Perfil, String> audIp;
    public static volatile SingularAttribute<Perfil, String> nombre;
    public static volatile SingularAttribute<Perfil, Integer> version;

}