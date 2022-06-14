package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MateriaService;

@RestController
@RequestMapping(path = "/materia")
public class MateriaResource {

    private final MateriaService materiaService;

    public MateriaResource(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<Materia>> getMateriaPorCodDepartamento(@RequestParam("codDepartamento") Integer codDepartamento) {
        return ResponseEntity.ok(this.materiaService.buscarPorCodDepartamento(codDepartamento));
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Materia>> getMateriaPorNombre(@RequestParam("nombre") String nombrePattern) {
        return ResponseEntity.ok(this.materiaService.buscarPorNombre(nombrePattern));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Materia materia) {
        try {
            this.materiaService.crear(materia);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Materia> modificar(@RequestBody Materia materia) {
        try {
            this.materiaService.modificar(materia);
            materia = this.materiaService.obtenerPorCodigo(materia.getPk());
            return ResponseEntity.ok(materia);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
