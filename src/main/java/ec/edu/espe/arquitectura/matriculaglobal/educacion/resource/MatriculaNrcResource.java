package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MatriculaNrcService;

@RestController
@RequestMapping(path = "/materianrc")
public class MatriculaNrcResource {

    private final MatriculaNrcService matriculaNrcService;

    public MatriculaNrcResource(MatriculaNrcService matriculaNrcService) {
        this.matriculaNrcService = matriculaNrcService;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaNrc>> getNombres(@RequestParam("estado") String estado) {
        return ResponseEntity.ok(this.matriculaNrcService.buscarPorEstado(estado));
    }
    
}
