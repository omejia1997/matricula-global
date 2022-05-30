package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Edificio;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.InstitucionFisica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Sede.class)
public class Sede_ { 

    public static volatile SingularAttribute<Sede, String> codSede;
    public static volatile SingularAttribute<Sede, String> audUsuario;
    public static volatile SingularAttribute<Sede, Date> audFecha;
    public static volatile SingularAttribute<Sede, InstitucionFisica> codInstitucion;
    public static volatile SingularAttribute<Sede, String> direccion;
    public static volatile SingularAttribute<Sede, String> esPrincipal;
    public static volatile SingularAttribute<Sede, String> audIp;
    public static volatile ListAttribute<Sede, Edificio> edificioList;
    public static volatile SingularAttribute<Sede, String> nombre;
    public static volatile SingularAttribute<Sede, Integer> version;

}