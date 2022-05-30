package ec.edu.espe.arquitectura.matriculaglobal.general.model;

import ec.edu.espe.arquitectura.matriculaglobal.general.model.InstitucionGeneral;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.Pais;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.PaisEstructura;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(UbicacionGeografica.class)
public class UbicacionGeografica_ { 

    public static volatile SingularAttribute<UbicacionGeografica, String> audUsuario;
    public static volatile SingularAttribute<UbicacionGeografica, String> codigoPostal;
    public static volatile ListAttribute<UbicacionGeografica, InstitucionGeneral> institucionList;
    public static volatile SingularAttribute<UbicacionGeografica, String> codUbicacionGeografica;
    public static volatile SingularAttribute<UbicacionGeografica, String> codigoAreaTelefono;
    public static volatile SingularAttribute<UbicacionGeografica, String> codPais;
    public static volatile SingularAttribute<UbicacionGeografica, PaisEstructura> paisEstructura;
    public static volatile SingularAttribute<UbicacionGeografica, String> nombre;
    public static volatile SingularAttribute<UbicacionGeografica, Integer> version;
    public static volatile ListAttribute<UbicacionGeografica, UbicacionGeografica> ubicacionGeograficaList;
    public static volatile SingularAttribute<UbicacionGeografica, Pais> pais;
    public static volatile SingularAttribute<UbicacionGeografica, Date> audFecha;
    public static volatile SingularAttribute<UbicacionGeografica, String> audIp;
    public static volatile SingularAttribute<UbicacionGeografica, String> codigoAlterno;
    public static volatile SingularAttribute<UbicacionGeografica, Integer> codUbicacionGeoInt;
    public static volatile SingularAttribute<UbicacionGeografica, Short> nivel;
    public static volatile SingularAttribute<UbicacionGeografica, Integer> codUbicacionGeoPadre;
    public static volatile SingularAttribute<UbicacionGeografica, UbicacionGeografica> ubicacionGeoPadre;

}