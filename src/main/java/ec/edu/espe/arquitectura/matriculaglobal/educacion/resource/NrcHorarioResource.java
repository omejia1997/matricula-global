package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.NrcHorarioService;

@RestController
@RequestMapping(path = "/nrchorarios")
public class NrcHorarioResource {

    private final NrcHorarioService nrcHorarioService;

    public NrcHorarioResource(NrcHorarioService nrcHorarioService) {
        this.nrcHorarioService = nrcHorarioService;
    }

    @GetMapping
    public ResponseEntity<List<NrcHorario>> getHorarioPorNrcYPeriodo(@RequestParam("nrc") Integer nrc, @RequestParam("periodo") Integer periodo) {
        try {
            return ResponseEntity.ok(this.nrcHorarioService.buscarporCodNrcYCodPeriodo(nrc, periodo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody NrcHorario nrcHorario, @RequestParam("horaInicio") @DateTimeFormat(pattern="HH:mm:ss") Date horaInicio, @RequestParam("horaFin") @DateTimeFormat(pattern="HH:mm:ss") Date horaFin) {
        try {
            this.nrcHorarioService.crear(nrcHorario, horaInicio, horaFin);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<NrcHorario> modificar(@RequestBody NrcHorario nrcHorario, @RequestParam("horaInicio") @DateTimeFormat(pattern="HH:mm:ss") Date horaInicio, @RequestParam("horaFin") @DateTimeFormat(pattern="HH:mm:ss") Date horaFin) {
        try {
            this.nrcHorarioService.modificar(nrcHorario, horaInicio, horaFin);
            nrcHorario = this.nrcHorarioService.obtenerPorCodigo(nrcHorario.getPk());
            return ResponseEntity.ok(nrcHorario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
