package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidadPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(PerfilFuncionalidad.class)
public class PerfilFuncionalidad_ { 

    public static volatile SingularAttribute<PerfilFuncionalidad, String> audUsuario;
    public static volatile SingularAttribute<PerfilFuncionalidad, Date> audFecha;
    public static volatile SingularAttribute<PerfilFuncionalidad, Funcionalidad> funcionalidad;
    public static volatile SingularAttribute<PerfilFuncionalidad, String> audIp;
    public static volatile SingularAttribute<PerfilFuncionalidad, PerfilFuncionalidadPK> pk;
    public static volatile SingularAttribute<PerfilFuncionalidad, Integer> version;
    public static volatile SingularAttribute<PerfilFuncionalidad, Perfil> perfil;

}