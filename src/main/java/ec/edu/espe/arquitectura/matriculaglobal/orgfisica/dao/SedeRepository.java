package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.dao;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Sede;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeRepository extends JpaRepository<Sede, String> {
    List<Sede> findByCodInstitucion(String codInstitucion);
}
