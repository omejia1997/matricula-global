package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Edificio;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.EdificioBloque;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.TipoAula;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile ListAttribute<Aula, NrcHorario> nrcHorarioList;
    public static volatile SingularAttribute<Aula, Short> piso;
    public static volatile SingularAttribute<Aula, Integer> codAula;
    public static volatile SingularAttribute<Aula, EdificioBloque> codEdificioBloque;
    public static volatile SingularAttribute<Aula, String> audUsuario;
    public static volatile SingularAttribute<Aula, String> codAlterno;
    public static volatile SingularAttribute<Aula, Date> audFecha;
    public static volatile SingularAttribute<Aula, Edificio> codEdificio;
    public static volatile SingularAttribute<Aula, String> audIp;
    public static volatile SingularAttribute<Aula, TipoAula> codTipoAula;
    public static volatile SingularAttribute<Aula, Integer> version;
    public static volatile SingularAttribute<Aula, Short> capacidad;

}