package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrcPK;

@Service
public class MatriculaNrcService {

    private final MatriculaNrcRepository matriculaNrcRepository;

    public MatriculaNrcService(MatriculaNrcRepository matriculaNrcRepository) {
        this.matriculaNrcRepository = matriculaNrcRepository;
    }

    public MatriculaNrc obtenerPorCodigo(MatriculaNrcPK matriculaNrcPK) {
        Optional<MatriculaNrc> matrNrcOpt = this.matriculaNrcRepository.findById(matriculaNrcPK);
        if (matrNrcOpt.isPresent()) {
            return matrNrcOpt.get();
        } else {
            return null;
        }
    }

    public List<MatriculaNrc> buscarPorEstado(String estado) {
        return this.buscarPorEstado(estado);
    }
    
}
