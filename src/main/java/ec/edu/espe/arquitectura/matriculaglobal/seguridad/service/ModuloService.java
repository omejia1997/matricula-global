package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.ModuloRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Modulo;

@Service
public class ModuloService {
    
    private ModuloRepository moduloRepository;
    
    public ModuloService(ModuloRepository moduloRespository) {
        this.moduloRepository = moduloRespository;
    }

    public Modulo obtenerPorCodigo(String codigo) {
        Optional<Modulo>  moduloOpt = this.moduloRepository.findById(codigo);
        if (moduloOpt.isPresent()) {
            return moduloOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Modulo modulo) {
        modulo.setEstado(EstadosEnum.INACTIVO.getValor());
        this.moduloRepository.save(modulo);
    }

    public void modificar(Modulo modulo) {
        Modulo moduloDB = this.obtenerPorCodigo(modulo.getCodModulo());
        moduloDB.setNombre(modulo.getNombre());
        moduloDB.setEstado(modulo.getEstado());
        this.moduloRepository.save(moduloDB);
    }

    public List<Modulo> listarModulosActivos() {
        return this.moduloRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }
}
