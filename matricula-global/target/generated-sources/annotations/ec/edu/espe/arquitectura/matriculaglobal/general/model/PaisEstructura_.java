package ec.edu.espe.arquitectura.matriculaglobal.general.model;

import ec.edu.espe.arquitectura.matriculaglobal.general.model.Pais;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.PaisEstructuraPK;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(PaisEstructura.class)
public class PaisEstructura_ { 

    public static volatile SingularAttribute<PaisEstructura, String> audUsuario;
    public static volatile SingularAttribute<PaisEstructura, Date> audFecha;
    public static volatile SingularAttribute<PaisEstructura, String> audIp;
    public static volatile SingularAttribute<PaisEstructura, PaisEstructuraPK> pk;
    public static volatile SingularAttribute<PaisEstructura, String> nombre;
    public static volatile SingularAttribute<PaisEstructura, Integer> version;
    public static volatile ListAttribute<PaisEstructura, UbicacionGeografica> ubicacionGeograficaList;
    public static volatile SingularAttribute<PaisEstructura, Pais> pais;

}