package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
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

    public List<Prerequisito> buscarPorCodMateria(Integer codMateria) {
        return this.prerequisitoRepository.findByCodMateria(codMateria);
    }

    public List<Prerequisito> buscarPorMateriaYTipo(Integer codMateria, String tipo) {
        return this.prerequisitoRepository.findByCodMateriaAndTipo(codMateria, tipo);
    }

    public Prerequisito modificar(Prerequisito prerequisito) {
        Prerequisito prerequisitoDB = this.obtenerPorCodigo(prerequisito.getCodPrerequisito());
        prerequisitoDB.setTipo(prerequisito.getTipo());
        this.prerequisitoRepository.save(prerequisitoDB);
        return prerequisitoDB;
    }
    
}
