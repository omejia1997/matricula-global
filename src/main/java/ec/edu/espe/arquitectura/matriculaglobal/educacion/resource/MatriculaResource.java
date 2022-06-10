package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.MatriculaService;

@RestController
@RequestMapping(path = "/matricula")
public class MatriculaResource {

    private final MatriculaService matriculaService;

    public MatriculaResource(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }
    
}