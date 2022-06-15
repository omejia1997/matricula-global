package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.CalificacionException;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.CalificacionRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.CalificacionPK;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion obtenerPorCodigo(CalificacionPK calificacionPK) {
        Optional<Calificacion> califOpt = this.calificacionRepository.findById(calificacionPK);
        if (califOpt.isPresent()) {
            return califOpt.get();
        } else {
            return null;
        }
    }

    public List<Calificacion> buscarPorCodPersonaOrdenadoPorNrc(Integer codPersona, Integer codNrc) {
        return this.calificacionRepository.findByPkCodPersonaAndCodPeriodoOrderByPkCodNrc(codPersona, codNrc);
        
    }

    public List<Calificacion> buscarPorCodPersonaYCodNrc(Integer codPersona, Integer codNrc) {
        return this.calificacionRepository.findByPkCodPersonaAndPkCodNrc(codPersona, codNrc);
    }

    public void crear(Calificacion calificacion) throws CalificacionException {
        calificacion.setPromedio(this.promediarCalificacion(calificacion.getPk()));
        this.calificacionRepository.save(calificacion);
    }

    public Calificacion modificar(Calificacion calificacion) throws CalificacionException {
        Calificacion calificacionDB = this.obtenerPorCodigo(calificacion.getPk());
        calificacionDB.setNota1(calificacion.getNota1());
        calificacionDB.setNota2(calificacion.getNota2());
        calificacionDB.setNota3(calificacion.getNota3());
        calificacionDB.setNota4(calificacion.getNota4());
        calificacionDB.setNota5(calificacion.getNota5());
        calificacionDB.setNota6(calificacion.getNota6());
        calificacionDB.setNota7(calificacion.getNota7());
        calificacionDB.setNota8(calificacion.getNota8());
        calificacionDB.setNota9(calificacion.getNota9());
        calificacionDB.setNota10(calificacion.getNota10());
        calificacionDB.setObservacion(calificacion.getObservacion());
        calificacionDB.setPromedio(this.promediarCalificacion(calificacion.getPk()));
        this.calificacionRepository.save(calificacionDB);
        return calificacionDB;
    }

    public BigDecimal promediarCalificacion(CalificacionPK calificacionPK) throws CalificacionException {
        Calificacion calificacion = this.obtenerPorCodigo(calificacionPK);
        BigDecimal sumadorNotas = new BigDecimal(0);
        Integer divisorPromedio = 0;
        if(calificacion.getNota1() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota1());
        }
        if(calificacion.getNota2() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota2());
        }
        if(calificacion.getNota3() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota3());
        }
        if(calificacion.getNota4() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota4());
        }
        if(calificacion.getNota5() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota5());
        }
        if(calificacion.getNota6() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota6());
        }
        if(calificacion.getNota7() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota7());
        }
        if(calificacion.getNota8() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota8());
        }
        if(calificacion.getNota9() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota9());
        }
        if(calificacion.getNota10() != null){ 
            divisorPromedio++;
            sumadorNotas = sumadorNotas.add(calificacion.getNota10());
        }
        if(divisorPromedio == 0){
            throw new CalificacionException("No se puede promediar la calificacion porque no hay notas");
        }
        BigDecimal promedio = sumadorNotas.divide(new BigDecimal(divisorPromedio), 2, RoundingMode.HALF_UP);
        calificacion.setPromedio(promedio);
        this.calificacionRepository.save(calificacion);
        return calificacion.getPromedio();
    }
}
