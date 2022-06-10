package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;

@Service
public class NrcService {

    private final NrcRepository nrcRepository;

    public NrcService(NrcRepository nrcRepository) {
        this.nrcRepository = nrcRepository;
    }

    public Nrc obtenerPorCodigo(NrcPK nrcPk) {
        Optional<Nrc> nrcOpt = this.nrcRepository.findById(nrcPk);
        if (nrcOpt.isPresent()) {
            return nrcOpt.get();
        } else {
            return null;
        }
    }

}
