package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MateriaService;

@RestController
@RequestMapping(path = "/materia")
public class MateriaResource {

    private final MateriaService materiaService;

    public MateriaResource(MateriaService materiaService) {
        this.materiaService = materiaService;
    }
    
}
