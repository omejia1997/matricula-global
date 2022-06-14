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
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.PerfilService;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilResource {

    private PerfilService perfilService;

    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Perfil>> getPerfilesActivos() {
        return ResponseEntity.ok(this.perfilService.listarPerfilesActivos());
    }

    @GetMapping
    public ResponseEntity<List<PerfilFuncionalidad>> buscarFuncionalidadesPerfil(@RequestParam("codPerfil") String codPerfil){
        try {
            List<PerfilFuncionalidad> perfilesUsuario = this.perfilService.buscarFuncionalidadesPerfil(codPerfil);
            return ResponseEntity.ok(perfilesUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Perfil> crear(@RequestBody Perfil perfil) {
        try {
            perfil = this.perfilService.crear(perfil);
            return ResponseEntity.ok(perfil);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
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
