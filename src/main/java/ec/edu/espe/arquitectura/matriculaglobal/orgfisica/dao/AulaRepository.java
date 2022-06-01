package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.dao;

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
    List<Aula> findByCodTipoAula(String codTipoAula);
    List<Aula> findByCodEdificio(String codEdificio);
    List<Aula> findByCodEdificioBloque(String codEdificioBloque);
}
