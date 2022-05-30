package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(RegistroSesion.class)
public class RegistroSesion_ { 

    public static volatile SingularAttribute<RegistroSesion, String> codUsuario;
    public static volatile SingularAttribute<RegistroSesion, String> ipConexion;
    public static volatile SingularAttribute<RegistroSesion, String> resultado;
    public static volatile SingularAttribute<RegistroSesion, Integer> secuencia;
    public static volatile SingularAttribute<RegistroSesion, String> error;
    public static volatile SingularAttribute<RegistroSesion, Date> fechaConexion;

}