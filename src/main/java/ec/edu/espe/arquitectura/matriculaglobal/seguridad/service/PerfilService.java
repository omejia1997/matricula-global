package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.PerfilEstadoException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    
    private final PerfilRepository perfilRepository;
    private final PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    public PerfilService(PerfilRepository perfilRepository, PerfilFuncionalidadRepository perfilFuncionalidadRepository) {
        this.perfilRepository = perfilRepository;
        this.perfilFuncionalidadRepository = perfilFuncionalidadRepository;
    }

    public Perfil obtenerPorCodigo(String codigo) {
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()) {
            return perfilOpt.get();
        } else {
            return null;
        }
    }

    public List<Perfil> listarPerfilesPorEstado(String estado) throws PerfilEstadoException {
        if(estado.equals(EstadosEnum.ACTIVO.getValor()) || estado.equals(EstadosEnum.INACTIVO.getValor())) 
            return this.perfilRepository.findByEstado(estado);
        else
            throw new PerfilEstadoException("El estado del perfil es incorrecto");
    }

    public Perfil crear(Perfil perfil) {
        this.perfilRepository.save(perfil);
        this.perfilFuncionalidadRepository.saveAll(perfil.getPerfilFuncionalidadList());
        return perfil;
    }
    
    public void modificar(Perfil perfil) {
        Perfil perfilDB = this.obtenerPorCodigo(perfil.getCodPerfil());
        perfilDB.setNombre(perfil.getNombre());
        perfilDB.setEstado(perfil.getEstado());
        this.perfilRepository.save(perfil);
    }

}
