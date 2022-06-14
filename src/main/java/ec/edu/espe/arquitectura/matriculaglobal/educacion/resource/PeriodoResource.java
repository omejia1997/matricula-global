package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Periodo;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.PeriodoService;

@RestController
@RequestMapping(path = "/periodo")
public class PeriodoResource {

    private final PeriodoService periodoService;

    public PeriodoResource(PeriodoService periodoService) {
        this.periodoService = periodoService;
    } 

    @GetMapping("/nombre")
    public ResponseEntity<List<Periodo>> getPeriodoPorNombre(@RequestParam("nombre") String nombrePattern) {
        return ResponseEntity.ok(this.periodoService.buscarPorNombre(nombrePattern));
    }

    @GetMapping("/nivel")
    public ResponseEntity<List<Periodo>> buscarPorNivel(@RequestParam("nivel") String nivel) {
        return ResponseEntity.ok(this.periodoService.buscarPorNivel(nivel));
    }

    @GetMapping("/parciales")
    public ResponseEntity<List<Periodo>> buscarPorParciales(@RequestParam("integer") Integer parciales) {
        return ResponseEntity.ok(this.periodoService.buscarPorParciales(parciales));
    }


}
