package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Funcionalidad.class)
public class Funcionalidad_ { 

    public static volatile SingularAttribute<Funcionalidad, String> descripcion;
    public static volatile SingularAttribute<Funcionalidad, String> estado;
    public static volatile SingularAttribute<Funcionalidad, String> audUsuario;
    public static volatile SingularAttribute<Funcionalidad, Date> audFecha;
    public static volatile SingularAttribute<Funcionalidad, Integer> codModulo;
    public static volatile ListAttribute<Funcionalidad, PerfilFuncionalidad> perfilFuncionalidadList;
    public static volatile SingularAttribute<Funcionalidad, String> audIp;
    public static volatile SingularAttribute<Funcionalidad, String> urlPrincipal;
    public static volatile SingularAttribute<Funcionalidad, Integer> codFuncionalidad;
    public static volatile SingularAttribute<Funcionalidad, String> nombre;
    public static volatile SingularAttribute<Funcionalidad, Integer> version;
    public static volatile SingularAttribute<Funcionalidad, Modulo> modulo;

}