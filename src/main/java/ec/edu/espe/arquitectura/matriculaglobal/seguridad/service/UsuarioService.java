package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.CambioClaveException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadoRegistroSesionEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.InicioSesionException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.UsuarioException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.RegistroSesion;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfil;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RegistroSesionRepository registroSesionRepository;
    private JavaMailSender mailSender;

    public UsuarioService(UsuarioRepository usuarioRepository, RegistroSesionRepository registroSesionRepository,
            JavaMailSender mailSender) {
        this.usuarioRepository = usuarioRepository;
        this.registroSesionRepository = registroSesionRepository;
        this.mailSender = mailSender;
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
        return this.usuarioRepository.findByMail(mail);
    }

    public Usuario buscarPorCodigoOMail(String valor) {
        Usuario usuario = this.buscarPorCodigo(valor);
        if (usuario == null) {
            usuario = this.buscarPorMail(valor);
        }
        return usuario;
    }

    public List<Usuario> buscarPorNombre(String nombrePattern) {
        return this.usuarioRepository.findByNombreLikeOrderByNombre("%" + nombrePattern.toUpperCase() + "%");
    }

    public List<Usuario> buscarPorNombreYEstado(String nombrePattern, String estado) {
        return this.usuarioRepository.findByNombreLikeAndEstadoOrderByNombre("%" + nombrePattern.toUpperCase() + "%", estado);
    }

    public List<Usuario> buscarPorEstado(String estado) {
        return this.usuarioRepository.findByEstado(estado);
    }

    public void crear(Usuario usuario) {
        String clave = RandomStringUtils.randomAlphabetic(8);
        usuario.setClave(DigestUtils.sha256Hex(clave));
        usuario.setFechaCreacion(new Date());
        usuario.setEstado(EstadoPersonaEnum.CREADO.getValor());
        usuario.setNroIntentosFallidos(0);
        usuario.setNombre(usuario.getNombre().toUpperCase());
        this.usuarioRepository.save(usuario);
        this.enviarClaveUsuario(usuario, clave);
    }

    public void enviarClaveUsuario (Usuario usuario, String clave){
        SimpleMailMessage email = new SimpleMailMessage();
        String asunto = "Registro exitoso";
        String contenido = usuario.getNombre() + ", tu clave generada es: " + clave;

        email.setTo(usuario.getMail());
        email.setSubject(asunto);
        email.setText(contenido);

        mailSender.send(email);
    }

    public Usuario modificar(Usuario usuario) {
        Usuario usuarioDB = this.buscarPorCodigo(usuario.getCodUsuario());
        usuarioDB.setTelefono(usuario.getTelefono());
        this.usuarioRepository.save(usuarioDB);
        return usuarioDB;
    }

    public Usuario modificarEstado(Usuario usuario) {
        Usuario usuarioDB = this.buscarPorCodigo(usuario.getCodUsuario());
        usuarioDB.setEstado(usuario.getEstado());
        this.usuarioRepository.save(usuarioDB);
        return usuarioDB;
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
        usuario.setEstado(EstadoPersonaEnum.ACTIVO.getValor());
        usuario.setFechaCambioClave(new Date());
        this.usuarioRepository.save(usuario);
    }

    public Usuario iniciarSesion(String codigoOMail, String clave) throws InicioSesionException, UnknownHostException {
        Integer NROMAXINTENTOSFALLIDOS = 3;
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if(usuario == null){
            throw new InicioSesionException("Usuario no encontrado");
        } 
        if(usuario.getEstado().equals(EstadoPersonaEnum.ACTIVO.getValor()) || usuario.getEstado().equals(EstadoPersonaEnum.CREADO.getValor())){
            String ip = InetAddress.getLocalHost().getHostAddress();
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
                usuario.setClave("");
                return usuario;
            }    
        }else{
            throw new InicioSesionException("Usuario no activo");
        }
    }
    
    public List<UsuarioPerfil> buscarPerfilesUsuario(String codUsuario) throws UsuarioException{
        Usuario usuarioDB = this.buscarPorCodigo(codUsuario);
        if(usuarioDB.getEstado().equals(EstadoPersonaEnum.INACTIVO.getValor())||usuarioDB.getEstado().equals(EstadoPersonaEnum.SUSPENDIDO.getValor())){
            throw new UsuarioException("Usuario inactivo o suspendido");
        }
        return usuarioDB.getUsuarioPerfiles();
    }
}