package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.PeriodoService;

@RestController
@RequestMapping(path = "/periodo")
public class PeriodoResource {

    private final PeriodoService periodoService;

    public PeriodoResource(PeriodoService periodoService) {
        this.periodoService = periodoService;
    } 

}
