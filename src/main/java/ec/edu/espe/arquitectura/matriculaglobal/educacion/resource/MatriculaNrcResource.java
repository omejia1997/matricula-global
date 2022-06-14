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

import ec.edu.espe.arquitectura.matriculaglobal.educacion.MatriculaCrear;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MatriculaNrcService;

@RestController
@RequestMapping(path = "/matriculanrc")
public class MatriculaNrcResource {

    private final MatriculaNrcService matriculaNrcService;

    public MatriculaNrcResource(MatriculaNrcService matriculaNrcService) {
        this.matriculaNrcService = matriculaNrcService;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaNrc>> getMatriculasEstado(@RequestParam("estado") String estado) {
        return ResponseEntity.ok(this.matriculaNrcService.buscarPorEstado(estado));
    }
    
    @GetMapping("/matricula")
    public ResponseEntity<List<MatriculaNrc>> buscarNrcMatriculaActivo(@RequestParam("codPersona") Integer codPersona) {
        return ResponseEntity.ok(this.matriculaNrcService.buscarNrcMatriculaActivo(codPersona));
    }

    @PutMapping
    public ResponseEntity<MatriculaNrc> modificar(@RequestBody MatriculaNrc matriculaNrc) {
        try { 
            this.matriculaNrcService.modificar(matriculaNrc);
            matriculaNrc = this.matriculaNrcService.obtenerPorCodigo(matriculaNrc.getPk());
            return ResponseEntity.ok(matriculaNrc);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody MatriculaCrear matriculaCrear) {
        try {
            this.matriculaNrcService.registrarMatriculaNrc(matriculaCrear.getMatriculaPK(), matriculaCrear.getNrcsPK());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
