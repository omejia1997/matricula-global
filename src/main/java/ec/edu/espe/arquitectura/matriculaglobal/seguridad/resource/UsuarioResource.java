package ec.edu.espe.arquitectura.matriculaglobal.seguridad.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {
    
    private UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Usuario>> buscarPorNombre(@RequestParam("nombre") String nombrePattern){
        List<Usuario> usuarios = this.usuarioService.buscarPorNombre(nombrePattern);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/mail")
    public ResponseEntity<Usuario> buscarPorMail(@RequestParam("mail") String mail){
        try {
            Usuario usuario = this.usuarioService.buscarPorMail(mail);
            System.out.println(usuario.toString());
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Usuario>> buscarPorEstado(@RequestParam("estado") String estado){
        List<Usuario> usuarios = this.usuarioService.buscarPorEstado(estado);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/nomestado")
    public ResponseEntity<List<Usuario>> buscarPorNombreYEstado(@RequestParam("nombre") String nombrePattern, @RequestParam("estado") String estado){
        List<Usuario> usuarios = this.usuarioService.buscarPorNombreYEstado(nombrePattern, estado);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioPerfil>> buscarPorCodUsuario(@RequestParam("codUsuario") String codUsuario){
        try {
            List<UsuarioPerfil> perfilesUsuario = this.usuarioService.buscarPerfilesUsuario(codUsuario);
            return ResponseEntity.ok(perfilesUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        try{
            this.usuarioService.crear(usuario);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping ("/cambiarclave")
    public ResponseEntity<String> cambiarClave(@RequestParam("codigoOMail") String codigoOMail, @RequestParam("claveAntigua") String claveAntigua, @RequestParam("claveNueva") String claveNueva) {
        try{
            this.usuarioService.cambiarClave(codigoOMail, claveAntigua, claveNueva);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping ("/iniciarsesion")
    public ResponseEntity<Usuario> iniciarSesion(@RequestParam("codigoOMail") String codigoOMail, @RequestParam("clave") String clave) {
        try{
            Usuario usuario = new Usuario();
            usuario = this.usuarioService.iniciarSesion(codigoOMail, clave);
            return ResponseEntity.ok(usuario);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario) {
        try {
            this.usuarioService.modificar(usuario);
            usuario = this.usuarioService.buscarPorCodigo(usuario.getCodUsuario());
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    } 

    @PutMapping("/modificarestado")
    public ResponseEntity<Usuario> modificarEstado(@RequestBody Usuario usuario) {
        try {
            this.usuarioService.modificarEstado(usuario);
            usuario = this.usuarioService.buscarPorCodigo(usuario.getCodUsuario());
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    } 
}
