package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Departamento;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.DepartamentoService;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoResource {

    private final DepartamentoService departamentoService;

    public DepartamentoResource(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Departamento>> getNombres(@RequestParam("patron") String nombrePatron) {
        return ResponseEntity.ok(this.departamentoService.buscarPorNombre(nombrePatron));
    }

    @GetMapping("/siglas")
    public ResponseEntity<List<Departamento>> getSiglas(@RequestParam("patron") String siglasPatron) {
        return ResponseEntity.ok(this.departamentoService.buscarPorSiglas(siglasPatron));
    }

}
