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

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.NrcService;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;

@RestController
@RequestMapping(path = "/nrc")
public class NrcResource {

    private final NrcService nrcService;

    public NrcResource(NrcService nrcService) {
        this.nrcService = nrcService;
    }

    @GetMapping("/docente")
    public ResponseEntity<List<Nrc>> getNrcPorDocente(@RequestParam("coddocente") Integer codDocente) {
        try {
            return ResponseEntity.ok(this.nrcService.buscarPorCodDocente(codDocente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/cupodisp")
    public ResponseEntity<List<Nrc>> buscarPorCodNrcYCupoDisp(@RequestParam("codnrc") Integer codNrc, @RequestParam("cupo") Integer cupo) {
        try {
            return ResponseEntity.ok(this.nrcService.buscarPorCodNrcYCupoDisp(codNrc, cupo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/periodomateria")
    public ResponseEntity<List<Nrc>> buscarPorCodMateriaYCodPeriodo(@RequestParam("codperiodo") Integer codPeriodo, @RequestParam("codmateria") Integer codMateria) {
        try {
            return ResponseEntity.ok(this.nrcService.buscarPorCodPeriodoYCodMateria(codPeriodo, codMateria));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Nrc nrc) {
        try {
            this.nrcService.crear(nrc);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Nrc> modificar(@RequestBody Nrc nrc) {
        try {
            this.nrcService.modificar(nrc);
            nrc = this.nrcService.obtenerPorCodigo(nrc.getPk());
            return ResponseEntity.ok(nrc);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/alumnosnrc")
    public ResponseEntity<List<Persona>> getAlumnosDeNrc(@RequestBody NrcPK nrcPk) {
        try {
            return ResponseEntity.ok(this.nrcService.buscarAlumnosDeNrc(nrcPk));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
