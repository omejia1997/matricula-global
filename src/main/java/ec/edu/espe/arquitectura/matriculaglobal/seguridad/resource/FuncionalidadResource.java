package ec.edu.espe.arquitectura.matriculaglobal.seguridad.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.service.FuncionalidadService;

@RestController
@RequestMapping(path = "/funcionalidad")
public class FuncionalidadResource {
    
    public FuncionalidadService funcionalidadService;

    public FuncionalidadResource(FuncionalidadService funcionalidadService) {
        this.funcionalidadService = funcionalidadService;
    }

    @GetMapping
    public ResponseEntity<List<Funcionalidad>> getFuncionalidadesActivos() {
        return ResponseEntity.ok(this.funcionalidadService.listarFuncionalidadesActivos());
    }
    
    @GetMapping("/codestado")
    public ResponseEntity<List<Funcionalidad>> getFuncionalidadPorCodModuloYEstado(@RequestParam("codigoModulo") String codigoModulo, @RequestParam("estado") String estado) {
        try {
            return ResponseEntity.ok(this.funcionalidadService.buscarCodModuloYEstado(codigoModulo, estado));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Funcionalidad funcionalidad) {
        try {
            this.funcionalidadService.crear(funcionalidad);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Funcionalidad> modificar(@RequestBody Funcionalidad funcionalidad) {
        try {
            this.funcionalidadService.modificar(funcionalidad);
            funcionalidad = this.funcionalidadService.obtenerPorCodigo(funcionalidad.getCodFuncionalidad());
            return ResponseEntity.ok(funcionalidad);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    } 
    
}
