package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Aula;
import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Edificio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-30T12:21:51")
@StaticMetamodel(EdificioBloque.class)
public class EdificioBloque_ { 

    public static volatile SingularAttribute<EdificioBloque, String> descripcion;
    public static volatile SingularAttribute<EdificioBloque, String> codEdificioBloque;
    public static volatile SingularAttribute<EdificioBloque, String> nombreBloque;
    public static volatile SingularAttribute<EdificioBloque, String> audUsuario;
    public static volatile SingularAttribute<EdificioBloque, Date> audFecha;
    public static volatile SingularAttribute<EdificioBloque, Edificio> codEdificio;
    public static volatile ListAttribute<EdificioBloque, Aula> aulaList;
    public static volatile SingularAttribute<EdificioBloque, String> audIp;
    public static volatile SingularAttribute<EdificioBloque, Integer> version;

}