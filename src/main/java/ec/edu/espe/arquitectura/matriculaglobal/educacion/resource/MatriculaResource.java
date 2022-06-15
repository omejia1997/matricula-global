package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MatriculaService;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;

@RestController
@RequestMapping(path = "/matricula")
public class MatriculaResource {

    private final MatriculaService matriculaService;

    public MatriculaResource(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getMatriculaPorTipo(@RequestParam("tipo") String tipo) {
        try {
            return ResponseEntity.ok(this.matriculaService.buscarPorTipo(tipo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Matricula>> getMatriculaPorFecha(@RequestParam("fecha") String fecha) {
        return ResponseEntity.ok(this.matriculaService.buscarPorFecha(fecha));
    }

    @GetMapping("/persona")
    public ResponseEntity<List<Matricula>> getMatriculaPorCodPersona(@RequestParam("persona") Integer persona) {
        return ResponseEntity.ok(this.matriculaService.buscarPorCodPersona(persona));
    }


    @GetMapping("/personaperiodo")
    public ResponseEntity<List<Matricula>> buscarPorCodPersonaYCodPeriodo(@RequestParam("persona") Integer persona, @RequestParam("periodo") Integer periodo) {
        return ResponseEntity.ok(this.matriculaService.buscarPorCodPersonaYCodPeriodo(persona, periodo));
    }

    @GetMapping("/carreraperiodo")
    public ResponseEntity<List<Persona>> getEstudiantesPorCarreraYPeriodo(@RequestParam("codCarrera") Integer codCarrera,@RequestParam("codPeriodo") Integer codPeriodo) {
        try {
            return ResponseEntity.ok(this.matriculaService.buscarAlumnosMatriculadosPorCarreraYPeriodo(codCarrera,codPeriodo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody MatriculaCrear matriculaCrear) {
        try {
            this.matriculaService.crear(matriculaCrear.getCodCarrera(),matriculaCrear.getMatriculaPK(), matriculaCrear.getNrcsPK());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}