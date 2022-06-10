package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MateriaPK;

@Service
public class MateriaService {
    
    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public Materia obtenerPorCodigo(MateriaPK materiaPK) {
        Optional<Materia> materiaOpt = this.materiaRepository.findById(materiaPK);
        if (materiaOpt.isPresent()) {
            return materiaOpt.get();
        } else {
            return null;
        }
    }
    
}
