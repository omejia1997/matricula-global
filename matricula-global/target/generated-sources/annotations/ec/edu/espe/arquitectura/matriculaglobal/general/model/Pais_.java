package ec.edu.espe.arquitectura.matriculaglobal.general.model;

import ec.edu.espe.arquitectura.matriculaglobal.general.model.PaisEstructura;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> porOmision;
    public static volatile SingularAttribute<Pais, String> audUsuario;
    public static volatile SingularAttribute<Pais, Date> audFecha;
    public static volatile ListAttribute<Pais, PaisEstructura> paisEstructuraList;
    public static volatile SingularAttribute<Pais, String> codigoTelefonico;
    public static volatile SingularAttribute<Pais, String> codPais;
    public static volatile SingularAttribute<Pais, String> audIp;
    public static volatile SingularAttribute<Pais, String> nombre;
    public static volatile SingularAttribute<Pais, Integer> version;
    public static volatile ListAttribute<Pais, UbicacionGeografica> ubicacionGeograficaList;
    public static volatile SingularAttribute<Pais, String> nacionalidad;

}