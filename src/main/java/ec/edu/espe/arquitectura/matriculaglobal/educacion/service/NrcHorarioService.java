package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorarioPK;

@Service
public class NrcHorarioService {
    
    private final NrcHorarioRepository nrcHorarioRepository;

    public NrcHorarioService(NrcHorarioRepository nrcHorarioRepository) {
        this.nrcHorarioRepository = nrcHorarioRepository;
    }

    public NrcHorario obtenerPorCodigo(NrcHorarioPK nrcHorarioPK) {
        Optional<NrcHorario> nrcHorOpt = this.nrcHorarioRepository.findById(nrcHorarioPK);
        if (nrcHorOpt.isPresent()) {
            return nrcHorOpt.get();
        } else {
            return null;
        }
    }

}
