package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.PeriodoService;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.PrerequisitoService;

@RestController
@RequestMapping(path = "/prerrequisito")
public class PrerrequisitoResource {
    
    private final PrerequisitoService prerequisitoService;

    public PrerrequisitoResource(PrerequisitoService prerequisitoService) {
        this.prerequisitoService = prerequisitoService;
    }

}
