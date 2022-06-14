package ec.edu.espe.arquitectura.matriculaglobal.seguridad.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.UsuarioPerfilPK;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.UsuarioPerfilService;

@RestController
@RequestMapping(path = "/usuarioperfil")
public class UsuarioPerfilResource {
    UsuarioPerfilService usuarioPerfilService;

    public UsuarioPerfilResource(UsuarioPerfilService usuarioPerfilService) {
        this.usuarioPerfilService = usuarioPerfilService;
    }

    @PostMapping
    public ResponseEntity<String> asignarPerfil(@RequestParam("codigoUsuario") String codigoUsuario, @RequestParam("codigoPerfiles") List<String> codigoPerfiles, @RequestBody UsuarioPerfil usuarioPerfil) {
        try {
            this.usuarioPerfilService.asignarPerfil(codigoUsuario, codigoPerfiles, usuarioPerfil);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarUsuarioPerfil(@RequestBody List<UsuarioPerfilPK> perfilesUsuario){
        try {
            this.usuarioPerfilService.eliminarUsuarioPerfil(perfilesUsuario);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
       
}
