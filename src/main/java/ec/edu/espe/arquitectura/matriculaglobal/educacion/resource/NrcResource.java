package ec.edu.espe.arquitectura.matriculaglobal.educacion.resource;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.service.NrcService;

@Service
public class NrcResource {

    private final NrcService nrcService;

    public NrcResource(NrcService nrcService) {
        this.nrcService = nrcService;
    }

}
