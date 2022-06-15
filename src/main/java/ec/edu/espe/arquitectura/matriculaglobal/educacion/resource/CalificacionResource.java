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

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.CalificacionPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.CalificacionService;

@RestController
@RequestMapping(path = "/calificacion")
public class CalificacionResource {

    private final CalificacionService calificacionService;

    public CalificacionResource(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @GetMapping("/personanrcorder")
    public ResponseEntity<List<Calificacion>> getCalificacionPorPersonayPeriodo(@RequestParam("persona") Integer persona, @RequestParam("nrc") Integer nrc) {
        return ResponseEntity.ok(this.calificacionService.buscarPorCodPersonaOrdenadoPorNrc(persona, nrc));
    }

    @GetMapping("/personanrc")
    public ResponseEntity<List<Calificacion>> getCalificacionPorPersonaYNrc(@RequestParam("persona") Integer persona, @RequestParam("nrc") Integer nrc) {
        return ResponseEntity.ok(this.calificacionService.buscarPorCodPersonaYCodNrc(persona, nrc));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Calificacion calificacion) {
        try {
            this.calificacionService.crear(calificacion);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<Calificacion> modificar(@RequestBody Calificacion calificacion) {
        try {
            this.calificacionService.modificar(calificacion);
            calificacion = this.calificacionService.obtenerPorCodigo(calificacion.getPk());
            return ResponseEntity.ok(calificacion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/promediar")
    public ResponseEntity<Calificacion> promediarCalificacion(@RequestBody CalificacionPK calificacionPk) {
        try {
            this.calificacionService.promediarCalificacion(calificacionPk);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
