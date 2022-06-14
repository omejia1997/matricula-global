package ec.edu.espe.arquitectura.matriculaglobal.seguridad.resource;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidadPK;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.PerfilFuncionalidadService;

@RestController
@RequestMapping(path = "/perfilfuncionalidad")
public class PerfilFuncionalidadResource {
    PerfilFuncionalidadService perfilFuncionalidadService;

    public PerfilFuncionalidadResource(PerfilFuncionalidadService perfilFuncionalidadService) {
        this.perfilFuncionalidadService = perfilFuncionalidadService;
    }

    @PostMapping
    public ResponseEntity<String> asignarFuncionalidad(@RequestParam("codigoPerfil") String codigoPerfil, @RequestParam("codigoFuncionalidades") List<Integer> codigoFuncionalidades, @RequestBody PerfilFuncionalidad perfilFuncionalidad) {
        try {
            this.perfilFuncionalidadService.asignarFuncionalidad(codigoPerfil, codigoFuncionalidades, perfilFuncionalidad);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarPerfilUsuario(@RequestBody List<PerfilFuncionalidadPK> funcionalidadesPerfil){
        try {
            this.perfilFuncionalidadService.eliminarPerfilFuncionalidad(funcionalidadesPerfil);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
