package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.NrcHorarioService;

@RestController
@RequestMapping(path = "/nrchorarios")
public class NrcHorarioResource {

    private final NrcHorarioService nrcHorarioService;

    public NrcHorarioResource(NrcHorarioService nrcHorarioService) {
        this.nrcHorarioService = nrcHorarioService;
    }

}
