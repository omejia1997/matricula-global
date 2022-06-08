package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.CambioClaveException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadoRegistroSesionEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.InicioSesionException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.UsuarioPerfilRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.RegistroSesion;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Usuario;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;
    private RegistroSesionRepository registroSesionRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository, RegistroSesionRepository registroSesionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
        this.registroSesionRepository = registroSesionRepository;
    }

    public Usuario buscarPorCodigo(String codigo) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(codigo);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            return null;
        }
    }

    public Usuario buscarPorMail(String mail) {
        Optional<Usuario>  usuarioOpt = this.usuarioRepository.findByMail(mail);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            return null;
        }
    }

    public Usuario buscarPorCodigoOMail(String valor) {
        Usuario usuario = this.buscarPorCodigo(valor);
        if (usuario == null) {
            usuario = this.buscarPorMail(valor);
        }
        return usuario;
    }

    public List<Usuario> buscarPorNombre(String nombrePattern) {
        return this.usuarioRepository.findByNombreLikeOrderByNombre("%" + nombrePattern + "%");
    }

    public List<Usuario> buscarPorNombreYEstado(String nombrePattern, EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByNombreLikeAndEstadoOrderByNombre(nombrePattern, estado.getValor());
    }

    public List<Usuario> buscarPorEstado(EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByEstado(estado.getValor());
    }

    public Usuario crear(Usuario usuario) {
        String clave = RandomStringUtils.randomAlphabetic(8);
        usuario.setClave(DigestUtils.sha256Hex(clave));
        usuario.setFechaCreacion(new Date());
        this.usuarioRepository.save(usuario);
        this.usuarioPerfilRepository.saveAll(usuario.getUsuarioPerfiles());
        return usuario;
    }

    public void cambiarClave(String codigoOMail, String claveAntigua, String claveNueva) throws CambioClaveException {
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if (usuario == null) {
            throw new CambioClaveException("No existe el usuario para el codigo o correo provisto");
        }
        claveAntigua = DigestUtils.sha256Hex(claveAntigua);
        if (!usuario.getClave().equals(claveAntigua)) {
            throw new CambioClaveException("La clave antigua no coincide");
        }
        usuario.setClave(DigestUtils.sha256Hex(claveNueva));
        usuario.setFechaCambioClave(new Date());
        this.usuarioRepository.save(usuario);
    }

    public Usuario iniciarSesion(String codigoOMail, String clave) throws InicioSesionException {
        Integer NROMAXINTENTOSFALLIDOS = 3;
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if(usuario == null){
            throw new InicioSesionException("Usuario no encontrado");
        } 
        if(usuario.getEstado().equals(EstadoPersonaEnum.ACTIVO.getValor()) || usuario.getEstado().equals(EstadoPersonaEnum.CREADO.getValor())){
            String ip = "127.0.0.1";
            RegistroSesion registroSesion = new RegistroSesion();
            registroSesion.setIpConexion(ip);
            registroSesion.setFechaConexion(new Date());
            registroSesion.setCodUsuario(usuario.getCodUsuario());
            clave = DigestUtils.sha256Hex(clave);
            if(!usuario.getClave().equals(clave)){
                usuario.setNroIntentosFallidos(usuario.getNroIntentosFallidos() + 1);
                if(usuario.getNroIntentosFallidos() == NROMAXINTENTOSFALLIDOS){
                    usuario.setEstado(EstadoPersonaEnum.BLOQUEADO.getValor());
                }
                this.usuarioRepository.save(usuario);
                registroSesion.setResultado(EstadoRegistroSesionEnum.FALLIDO.getValor());
                this.registroSesionRepository.save(registroSesion);
                throw new InicioSesionException("Clave incorrecta");
            }else{
                usuario.setFechaUltimaSesion(new Date());
                usuario.setNroIntentosFallidos(0);
                this.usuarioRepository.save(usuario);
                registroSesion.setResultado(EstadoRegistroSesionEnum.SATISFACTORIO.getValor());
                this.registroSesionRepository.save(registroSesion);
                return usuario;
            }    
        }else{
            throw new InicioSesionException("Usuario no activo");
        }
    }
}