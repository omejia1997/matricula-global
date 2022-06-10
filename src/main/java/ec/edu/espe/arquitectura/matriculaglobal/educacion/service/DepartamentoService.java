package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.DepartamentoRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Departamento;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Departamento obtenerPorCodigo(Integer codigo) {
        Optional<Departamento> deparOpt = this.departamentoRepository.findById(codigo);
        if (deparOpt.isPresent()) {
            return deparOpt.get();
        } else {
            return null;
        }
    }

    public List<Departamento> buscarPorNombre(String nombrePattern) {
        return this.departamentoRepository.findByNombreLikeOrderByNombre("%" + nombrePattern + "%");
    }

    public List<Departamento> buscarPorSiglas(String siglasPattern) {
        return this.departamentoRepository.findBySiglasLikeOrderBySiglas("%" + siglasPattern + "%");
    }

    
}
