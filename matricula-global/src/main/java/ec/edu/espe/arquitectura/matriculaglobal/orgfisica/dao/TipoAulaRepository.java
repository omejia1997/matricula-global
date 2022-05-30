package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.dao;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.TipoAula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoAulaRepository extends JpaRepository<TipoAula, String> {
    List<TipoAula> findByDescripcion(String descripcion);
}
