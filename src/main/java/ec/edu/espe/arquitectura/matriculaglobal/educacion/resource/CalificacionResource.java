package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.CalificacionService;

@RestController
@RequestMapping(path = "/calificacion")
public class CalificacionResource {

    private final CalificacionService calificacionService;

    public CalificacionResource(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    

}
