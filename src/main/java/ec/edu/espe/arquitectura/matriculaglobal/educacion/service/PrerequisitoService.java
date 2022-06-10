package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.PrerequisitoRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Prerequisito;

@Service
public class PrerequisitoService {

    private final PrerequisitoRepository prerequisitoRepository;

    public PrerequisitoService(PrerequisitoRepository prerequisitoRepository) {
        this.prerequisitoRepository = prerequisitoRepository;
    }
    
    public Prerequisito obtenerPorCodigo(Integer codigo) {
        Optional<Prerequisito> periodOpt = this.prerequisitoRepository.findById(codigo);
        if (periodOpt.isPresent()) {
            return periodOpt.get();
        } else {
            return null;
        }
    }
    
}
