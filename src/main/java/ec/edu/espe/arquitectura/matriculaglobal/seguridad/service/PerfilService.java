package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.PerfilException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidad;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil obtenerPorCodigo(String codigo) {
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()) {
            return perfilOpt.get();
        } else {
            return null;
        }
    }

    public List<Perfil> listarPerfilesActivos() {
        return this.perfilRepository.findByEstado(EstadosEnum.ACTIVO.getValor());  
    }

    public Perfil crear(Perfil perfil) throws UnknownHostException {
        perfil.setEstado(EstadosEnum.ACTIVO.getValor());
        perfil.setAudFecha(new Date());
        perfil.setAudIp(InetAddress.getLocalHost().getHostAddress());
        this.perfilRepository.save(perfil);
        return perfil;
    }
    
    public void modificar(Perfil perfil) {
        Perfil perfilDB = this.obtenerPorCodigo(perfil.getCodPerfil());
        perfilDB.setNombre(perfil.getNombre());
        perfilDB.setEstado(perfil.getEstado());
        this.perfilRepository.save(perfilDB);
    }

    public List<PerfilFuncionalidad> buscarFuncionalidadesPerfil(String codPerfil) throws PerfilException{
        Perfil perfilDB=this.obtenerPorCodigo(codPerfil);
        if (perfilDB.getEstado().equals(EstadosEnum.INACTIVO.getValor())){
            throw new PerfilException("El perfil no est?? activo");
        }
        return perfilDB.getPerfilFuncionalidadList();   
    }

}
