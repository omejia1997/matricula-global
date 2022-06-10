package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula obtenerPorCodigo(MatriculaPK matriculapk) {
        Optional<Matricula> matrOpt = this.matriculaRepository.findById(matriculapk);
        if (matrOpt.isPresent()) {
            return matrOpt.get();
        } else {
            return null;
        }
    }
    
}
