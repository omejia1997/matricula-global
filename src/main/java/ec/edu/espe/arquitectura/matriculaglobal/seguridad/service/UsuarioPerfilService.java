package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.PerfilException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.UsuarioPerfilRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfilPK;

@Service
public class UsuarioPerfilService {
    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;
    private PerfilRepository perfilRepository;

    public UsuarioPerfilService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
        this.perfilRepository = perfilRepository;
    }

    public Usuario buscarUsuarioPorCodigo(String codigo) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(codigo);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            return null;
        }
    }

    public Perfil obtenerPerfilPorCodigo(String codigo) {
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()) {
            return perfilOpt.get();
        } else {
            return null;
        }
    }
    
    public void asignarPerfil(String codigoUsuario, List<String> codigoPerfiles, UsuarioPerfil usuarioPerfil) throws PerfilException{
        Usuario usuario = this.buscarUsuarioPorCodigo(codigoUsuario);
        if(usuario == null){
            throw new PerfilException("Usuario no encontrado");
        } 
        for(String codigo : codigoPerfiles){
            Perfil perfil = this.obtenerPerfilPorCodigo(codigo);
            if(perfil != null){
                if(perfil.getEstado().equals(EstadosEnum.ACTIVO.getValor())){
                    UsuarioPerfil userPerTemp = new UsuarioPerfil();
                    userPerTemp.setAudFecha(usuarioPerfil.getAudFecha());
                    userPerTemp.setAudIp(usuarioPerfil.getAudIp());
                    userPerTemp.setAudUsuario(usuarioPerfil.getAudUsuario());
                    UsuarioPerfilPK pk = new UsuarioPerfilPK();
                    pk.setCodPerfil(perfil.getCodPerfil());
                    pk.setCodUsuario(codigoUsuario);
                    userPerTemp.setUsuarioPerfilPK(pk);
                    this.usuarioPerfilRepository.save(userPerTemp);
                }
            }
        }
    }
    
    public void eliminarUsuarioPerfil(List<UsuarioPerfilPK> perfilesUsuario){
        this.usuarioPerfilRepository.deleteAllById(perfilesUsuario);
    }
}
