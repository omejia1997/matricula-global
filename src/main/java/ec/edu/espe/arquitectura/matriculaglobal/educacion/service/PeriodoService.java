package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Periodo;

@Service
public class PeriodoService {

    private final PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    public Periodo obtenerPorCodigo(Integer codigo) {
        Optional<Periodo> periodOpt = this.periodoRepository.findById(codigo);
        if (periodOpt.isPresent()) {
            return periodOpt.get();
        } else {
            return null;
        }
    }
    
}
