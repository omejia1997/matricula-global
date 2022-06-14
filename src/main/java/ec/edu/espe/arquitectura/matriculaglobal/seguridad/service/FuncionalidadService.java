package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.PerfilEstadoException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.FuncionalidadRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.ModuloRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Modulo;

@Service
public class FuncionalidadService {

    private final FuncionalidadRepository funcionalidadRepository;
    private final ModuloRepository moduloRepository;

    public FuncionalidadService(FuncionalidadRepository funcionalidadRepository, ModuloRepository moduloRepository) {
        this.funcionalidadRepository = funcionalidadRepository;
        this.moduloRepository = moduloRepository;
    }

    public Funcionalidad obtenerPorCodigo(Integer codigo) {
        Optional<Funcionalidad> moduloOpt = this.funcionalidadRepository.findById(codigo);
        if (moduloOpt.isPresent()) {
            return moduloOpt.get();
        } else {
            return null;
        }
    }

    public Funcionalidad obtenerPorCodigoYModuloCodigo(Integer codigo, String modCodigo) {
        Optional<Funcionalidad> funcionalidadOpt = this.funcionalidadRepository.findById(codigo);
        Optional<Modulo> moduloOpt = this.moduloRepository.findById(modCodigo);
        if (moduloOpt.isPresent() && funcionalidadOpt.isEmpty()) {
            return funcionalidadOpt.get();
        } else {
            return null;
        }
    }

    public List<Funcionalidad> buscarCodModuloYEstado(String codigoModulo, String estado) throws PerfilEstadoException {
        if(estado.equals(EstadosEnum.ACTIVO.getValor()) || estado.equals(EstadosEnum.INACTIVO.getValor())) 
            return funcionalidadRepository.findByCodModuloAndEstado(codigoModulo, estado);
        else
            throw new PerfilEstadoException("El estado de la funcionalidad es incorrecto");
    }

    public Funcionalidad crear(Funcionalidad funcionalidad) {
        funcionalidad.setEstado(EstadosEnum.ACTIVO.getValor());
        this.funcionalidadRepository.save(funcionalidad);
        return funcionalidad;
    }
    
    public void modificar(Funcionalidad funcionalidad) {
        Funcionalidad funcionalidadDB = this.obtenerPorCodigo(funcionalidad.getCodFuncionalidad());
        funcionalidadDB.setNombre(funcionalidad.getNombre());
        funcionalidadDB.setDescripcion(funcionalidad.getDescripcion());
        funcionalidadDB.setEstado(funcionalidad.getEstado());
        funcionalidadDB.setUrlPrincipal(funcionalidad.getUrlPrincipal());
        this.funcionalidadRepository.save(funcionalidadDB);
    }
    
    public List<Funcionalidad> listarFuncionalidadesActivos() {
        return this.funcionalidadRepository.findByEstadoOrderByNombre(EstadosEnum.ACTIVO.getValor());
    }
}
