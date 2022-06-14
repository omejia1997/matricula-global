package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorarioPK;

@Service
public class NrcHorarioService {
    
    private final NrcHorarioRepository nrcHorarioRepository;

    public NrcHorarioService(NrcHorarioRepository nrcHorarioRepository) {
        this.nrcHorarioRepository = nrcHorarioRepository;
    }

    public NrcHorario obtenerPorCodigo(NrcHorarioPK nrcHorarioPK) {
        Optional<NrcHorario> nrcHorOpt = this.nrcHorarioRepository.findById(nrcHorarioPK);
        if (nrcHorOpt.isPresent()) {
            return nrcHorOpt.get();
        } else {
            return null;
        }
    }

    public List<NrcHorario> buscarporCodNrcYCodPeriodo(Integer codNrc, Integer codPeriodo) {
        return this.nrcHorarioRepository.findByPkCodNrcAndPkCodPeriodo(codNrc, codPeriodo);
    }

    public void crear(NrcHorario nrcHorario, Date horaInicio, Date horaFin) {
        nrcHorario.getPk().setDiaSemana(nrcHorario.getPk().getDiaSemana().toUpperCase());
        nrcHorario.setHoraInicio(horaInicio);
        nrcHorario.setHoraFin(horaFin);
        this.nrcHorarioRepository.save(nrcHorario);
    }

    public NrcHorario modificar(NrcHorario nrcHorario, Date horaInicio, Date horaFin) {
        nrcHorario.getPk().setDiaSemana(nrcHorario.getPk().getDiaSemana().toUpperCase());;
        NrcHorario nrcHorarioDB = this.obtenerPorCodigo(nrcHorario.getPk());
        nrcHorarioDB.setHoraInicio(horaInicio);
        nrcHorarioDB.setHoraFin(horaFin);
        this.nrcHorarioRepository.save(nrcHorarioDB);
        return nrcHorarioDB;
    }
}
