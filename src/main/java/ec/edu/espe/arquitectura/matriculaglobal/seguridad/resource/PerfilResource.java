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

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.PerfilService;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilResource {

    private PerfilService perfilService;

    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }
    
    @GetMapping
    public ResponseEntity<List<Perfil>> getModulosActivos(@RequestParam("estado") String estado) {
        try {
            return ResponseEntity.ok(this.perfilService.listarPerfilesPorEstado(estado));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Perfil> crear(Perfil perfil) {
        perfil = this.perfilService.crear(perfil);
        return ResponseEntity.ok(perfil);
    }

    @PutMapping
    public ResponseEntity<Perfil> modificar(@RequestBody Perfil perfil) {
        try {
            this.perfilService.modificar(perfil);
            perfil = this.perfilService.obtenerPorCodigo(perfil.getCodPerfil());
            return ResponseEntity.ok(perfil);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    } 
    
}
