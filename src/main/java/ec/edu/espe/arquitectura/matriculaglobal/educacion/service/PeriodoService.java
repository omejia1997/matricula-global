package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
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

    public List<Periodo> buscarPorNombre(String nombrePattern) {
        return this.periodoRepository.findByNombreLikeOrderByFechaInicio("%" + nombrePattern + "%");
    }

    public List<Periodo> buscarPorNivel(String nivel) {
        return this.periodoRepository.findByNivelOrderByNombre(nivel);
    }

    public List<Periodo> buscarPorParciales(Integer parciales) {
        return this.periodoRepository.findByParciales(parciales);
    }

    
}
