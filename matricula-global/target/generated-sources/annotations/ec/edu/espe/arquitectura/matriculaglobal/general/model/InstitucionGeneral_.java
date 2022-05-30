package ec.edu.espe.arquitectura.matriculaglobal.general.model;

import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(InstitucionGeneral.class)
public class InstitucionGeneral_ { 

    public static volatile SingularAttribute<InstitucionGeneral, String> ruc;
    public static volatile SingularAttribute<InstitucionGeneral, String> razonSocial;
    public static volatile SingularAttribute<InstitucionGeneral, String> urlSistema;
    public static volatile SingularAttribute<InstitucionGeneral, String> dominio;
    public static volatile SingularAttribute<InstitucionGeneral, UbicacionGeografica> ubicacionGeoInt;
    public static volatile SingularAttribute<InstitucionGeneral, String> direccion;
    public static volatile SingularAttribute<InstitucionGeneral, String> nombreComercial;
    public static volatile SingularAttribute<InstitucionGeneral, String> urlInfo;
    public static volatile SingularAttribute<InstitucionGeneral, Integer> codUbicacionGeoInt;
    public static volatile SingularAttribute<InstitucionGeneral, Integer> version;

}