package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
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

    public List<Materia> buscarPorCodDepartamento(Integer codDepartamento) {
        return this.materiaRepository.findByPkCodDepartamentoOrderByNombre(codDepartamento);
    }

    public List<Materia> buscarPorNombre(String nombrePattern) {
        return this.materiaRepository.findByNombreLikeOrderByNombre("%" + nombrePattern.toUpperCase() + "%");
    }
    
    public void crear(Materia materia) {
        materia.setNombre(materia.getNombre().toUpperCase());
        this.materiaRepository.save(materia);
    }

    public Materia modificar(Materia materia) {
        Materia materiaDB = this.obtenerPorCodigo(materia.getPk());
        materiaDB.setNombre(materia.getNombre());
        materiaDB.setCreditos(materia.getCreditos());
        materiaDB.setHoras(materia.getHoras());
        materiaDB.setPonderacion(materia.getPonderacion());
        this.materiaRepository.save(materiaDB);
        return materiaDB;
    }
}
