package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
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

    public List<Calificacion> buscarPorCodPersonaOrdenadoPorNrc(Integer codPersona, Integer codNrc) {
        return this.calificacionRepository.findByPkCodPersonaAndCodPeriodoOrderByPkCodNrc(codPersona, codNrc);
        
    }

    public List<Calificacion> buscarPorCodPersonaYCodNrc(Integer codPersona, Integer codNrc) {
        return this.calificacionRepository.findByPkCodPersonaAndPkCodNrc(codPersona, codNrc);
    }

    public void crear(Calificacion calificacion) {
        this.calificacionRepository.save(calificacion);
    }

    public Calificacion modificar(Calificacion calificacion) {
        Calificacion calificacionDB = this.obtenerPorCodigo(calificacion.getPk());
        calificacionDB.setNota1(calificacion.getNota1());
        calificacionDB.setNota2(calificacion.getNota2());
        calificacionDB.setNota3(calificacion.getNota3());
        calificacionDB.setNota4(calificacion.getNota4());
        calificacionDB.setNota5(calificacion.getNota5());
        calificacionDB.setNota6(calificacion.getNota6());
        calificacionDB.setNota7(calificacion.getNota7());
        calificacionDB.setNota8(calificacion.getNota8());
        calificacionDB.setNota9(calificacion.getNota9());
        calificacionDB.setNota10(calificacion.getNota10());
        calificacionDB.setPromedio(calificacion.getPromedio());
        calificacionDB.setObservacion(calificacion.getObservacion());
        this.calificacionRepository.save(calificacionDB);
        return calificacionDB;
    }
}
