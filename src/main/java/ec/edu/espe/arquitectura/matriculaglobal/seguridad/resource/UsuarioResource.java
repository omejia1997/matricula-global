package ec.edu.espe.arquitectura.matriculaglobal.seguridad.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {
    
    private UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(Usuario usuario) {
        usuario = this.usuarioService.crear(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping 
    public ResponseEntity<Usuario> iniciarSesion(@RequestParam("valor") String valor, @RequestParam("clave") String clave) {
        try{
            Usuario usuario = new Usuario();
            usuario = this.usuarioService.iniciarSesion(valor, clave);
            return ResponseEntity.ok(usuario);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
