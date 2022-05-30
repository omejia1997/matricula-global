package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Aula;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.EdificioBloque;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Sede;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Edificio.class)
public class Edificio_ { 

    public static volatile SingularAttribute<Edificio, String> descripcion;
    public static volatile SingularAttribute<Edificio, String> manejaBloques;
    public static volatile SingularAttribute<Edificio, String> audUsuario;
    public static volatile SingularAttribute<Edificio, String> codAlterno;
    public static volatile SingularAttribute<Edificio, Short> pisos;
    public static volatile SingularAttribute<Edificio, String> direccion;
    public static volatile ListAttribute<Edificio, EdificioBloque> edificioBloqueList;
    public static volatile SingularAttribute<Edificio, String> comentario;
    public static volatile SingularAttribute<Edificio, String> nombre;
    public static volatile SingularAttribute<Edificio, Integer> version;
    public static volatile SingularAttribute<Edificio, Sede> codSede;
    public static volatile SingularAttribute<Edificio, String> codEdificio;
    public static volatile SingularAttribute<Edificio, Date> audFecha;
    public static volatile ListAttribute<Edificio, Aula> aulaList;
    public static volatile SingularAttribute<Edificio, String> poseeAulas;
    public static volatile SingularAttribute<Edificio, String> audIp;

}