package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Sede;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(InstitucionFisica.class)
public class InstitucionFisica_ { 

    public static volatile SingularAttribute<InstitucionFisica, String> ruc;
    public static volatile SingularAttribute<InstitucionFisica, String> razonSocial;
    public static volatile SingularAttribute<InstitucionFisica, String> audUsuario;
    public static volatile SingularAttribute<InstitucionFisica, Date> audFecha;
    public static volatile SingularAttribute<InstitucionFisica, Short> codInstitucion;
    public static volatile ListAttribute<InstitucionFisica, Sede> sedeList;
    public static volatile SingularAttribute<InstitucionFisica, String> dominio;
    public static volatile SingularAttribute<InstitucionFisica, String> nombreComercial;
    public static volatile SingularAttribute<InstitucionFisica, String> audIp;
    public static volatile SingularAttribute<InstitucionFisica, Integer> version;

}