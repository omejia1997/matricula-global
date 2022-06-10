package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MallaCarreraService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mallacarrera")
public class MallaCarreraResource {

    private final MallaCarreraService mallaCarreraService;

    public MallaCarreraResource(MallaCarreraService mallaCarreraService) {
        this.mallaCarreraService = mallaCarreraService;
    }

    @GetMapping
    public ResponseEntity<List<MallaCarrera>> getMallaPorCodigoCarrera(@RequestParam("codigo") Integer carrera) {
        return ResponseEntity.ok(this.mallaCarreraService.buscarPorCarrera(carrera));
    }

    @GetMapping
    public ResponseEntity<List<MallaCarrera>> getMallaPorCodigoCarreraYNivel(@RequestParam("codigo") Integer carrera, @RequestParam("nivel") Integer nivel ) {
        return ResponseEntity.ok(this.mallaCarreraService.buscarPorCarrerayNivel(carrera, nivel));
    }
    
}
