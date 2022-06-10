package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.CalificacionRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.CalificacionPK;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion obtenerPorCodigo(CalificacionPK calificacionPK) {
        Optional<Calificacion> califOpt = this.calificacionRepository.findById(calificacionPK);
        if (califOpt.isPresent()) {
            return califOpt.get();
        } else {
            return null;
        }
    }


}
