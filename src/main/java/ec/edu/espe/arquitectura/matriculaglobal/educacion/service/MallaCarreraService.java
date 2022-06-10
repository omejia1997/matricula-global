package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MallaCarreraRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MallaCarrera;

@Service
public class MallaCarreraService {

    private MallaCarreraRepository mallaCarreraRepository;

    public MallaCarreraService(MallaCarreraRepository mallaCarreraRepository) {
        this.mallaCarreraRepository = mallaCarreraRepository;
    }

    public MallaCarrera obtenerPorCodigo(Integer codigo) {
        Optional<MallaCarrera> mallaCarreraOpt = this.mallaCarreraRepository.findById(codigo);
        if (mallaCarreraOpt.isPresent()) {
            return mallaCarreraOpt.get();
        } else {
            return null;
        }
    }

    public List<MallaCarrera> buscarPorCarrera(Integer carrera) {
        return mallaCarreraRepository.findByCodCarreraOrderByNivel(carrera);
    }

    public List<MallaCarrera> buscarPorCarrerayNivel(Integer carrera, Integer nivel) {
        return mallaCarreraRepository.findByCodCarreraAndNivel(carrera, nivel);
    }
}
