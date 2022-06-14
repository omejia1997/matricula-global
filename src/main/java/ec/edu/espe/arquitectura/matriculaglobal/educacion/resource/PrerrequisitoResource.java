package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Prerequisito;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.PrerequisitoService;

@RestController
@RequestMapping(path = "/prerrequisito")
public class PrerrequisitoResource {
    
    private final PrerequisitoService prerequisitoService;

    public PrerrequisitoResource(PrerequisitoService prerequisitoService) {
        this.prerequisitoService = prerequisitoService;
    }

    @GetMapping("/materia")
    public ResponseEntity<List<Prerequisito>> getPrerrequisitoPorCodMateria(@RequestParam("materia") Integer codMateria) {
        return ResponseEntity.ok(this.prerequisitoService.buscarPorCodMateria(codMateria));
    }

    @GetMapping("/nivel")
    public ResponseEntity<List<Prerequisito>> buscarPrerrequisitoPorCodMateria(@RequestParam("materia") Integer codMateria, @RequestParam("tipo") String tipo) {
        return ResponseEntity.ok(this.prerequisitoService.buscarPorMateriaYTipo(codMateria, tipo));
    }

    @PutMapping
    public ResponseEntity<Prerequisito> modificar(@RequestBody Prerequisito prerequisito) {
        try {
            this.prerequisitoService.modificar(prerequisito);
            prerequisito = this.prerequisitoService.obtenerPorCodigo(prerequisito.getCodPrerequisito());
            return ResponseEntity.ok(prerequisito);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
