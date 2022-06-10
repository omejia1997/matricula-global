package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.CarreraService;

@RestController
@RequestMapping(path = "/carrera")
public class CarreraResource {

    private final CarreraService carreraService;

    public CarreraResource(CarreraService carreraService) {
        this.carreraService = carreraService;
    }
    
    @GetMapping
    public ResponseEntity<List<Carrera>> getCarreraPorNombre(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(this.carreraService.buscarPorNombre(nombre));
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> getCarreraPorModalidad(@RequestParam("modalidad") String modalidad) {
        return ResponseEntity.ok(this.carreraService.buscarPorModalidad(modalidad));
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> getCarreraPorCodigo(@RequestParam("codigo") String codigo) {
        try {
            return ResponseEntity.ok(this.carreraService.buscarPorCodDepartamento(Integer.parseInt(codigo)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
