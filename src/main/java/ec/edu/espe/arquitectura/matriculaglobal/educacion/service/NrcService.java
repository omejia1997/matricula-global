package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.CalificacionException;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;

@Service
public class NrcService {

    private final NrcRepository nrcRepository;
    private final MatriculaNrcRepository matriculaNrcRepository;
    private final PersonaRepository personaRepository;

    public NrcService(NrcRepository nrcRepository, MatriculaNrcRepository matriculaNrcRepository, PersonaRepository personaRepository) {
        this.nrcRepository = nrcRepository;
        this.matriculaNrcRepository = matriculaNrcRepository;
        this.personaRepository = personaRepository;
    }

    public Nrc obtenerPorCodigo(NrcPK nrcPk) {
        Optional<Nrc> nrcOpt = this.nrcRepository.findById(nrcPk);
        if (nrcOpt.isPresent()) {
            return nrcOpt.get();
        } else {
            return null;
        }
    }

    public Persona obtenerPorCodigoPersona(Integer codPersona) {
        Optional<Persona> personaOpt = this.personaRepository.findById(codPersona);
        if (personaOpt.isPresent()) {
            return personaOpt.get();
        } else {
            return null;
        }
    }

    public List<Nrc> buscarPorCodNrcYCupoDisp(Integer codNrc, Integer cupo) {
        return this.nrcRepository.findByPkCodNrcAndCupoDisponibleIsGreaterThan(codNrc, cupo);
    }

    public List<Nrc> buscarPorCodDocente(Integer codDocente) {
        return this.nrcRepository.findByCodDocente(codDocente);
    }

    public List<Nrc> buscarPorCodPeriodoYCodMateria(Integer codPeriodo, Integer codMateria) {
        return this.nrcRepository.findByPkCodPeriodoAndPkCodMateria(codPeriodo, codMateria);
    }

    public void crear(Nrc nrc) throws CalificacionException {
        Nrc nrcDB = this.obtenerPorCodigo(nrc.getPk());
        if(nrcDB != null) {
            throw new CalificacionException("Nrc existente");
        }
        Persona persona = this.obtenerPorCodigoPersona(nrc.getCodDocente());
        if (persona == null) {
            throw new CalificacionException("Docente no existe");
        }
        if(persona.getCodTipoPersona().equals(TipoPersonaEnum.ESTUDIANTE.getValor()) || persona.getCodTipoPersona().equals(TipoPersonaEnum.SERVIDORPUBLICO.getValor())) {
            throw new CalificacionException("Se debe asignar unicamente un docente");
        }
        nrc.setNombre(persona.getNombreComun());
        this.nrcRepository.save(nrc);
    }

    public Nrc modificar(Nrc nrc) throws CalificacionException {
        Nrc nrcDB = this.obtenerPorCodigo(nrc.getPk());
        if(nrcDB == null) {
            throw new CalificacionException("Nrc no existente");
        }
        Persona persona = this.obtenerPorCodigoPersona(nrc.getCodDocente());
        if (persona == null) {
            throw new CalificacionException("Docente no existe");
        }
        if(persona.getCodTipoPersona().equals(TipoPersonaEnum.ESTUDIANTE.getValor()) || persona.getCodTipoPersona().equals(TipoPersonaEnum.SERVIDORPUBLICO.getValor())) {
            throw new CalificacionException("Se debe asignar unicamente un docente");
        }
        nrcDB.setCupoDisponible(nrc.getCupoDisponible());
        nrcDB.setCupoRegistrado(0);
        nrcDB.setNombre(persona.getNombreComun());
        this.nrcRepository.save(nrcDB);
        return nrcDB;
    }
        
    public List<Persona> buscarAlumnosDeNrc(NrcPK nrcPk) throws CalificacionException {
        Nrc nrc = this.obtenerPorCodigo(nrcPk);
        if (nrc == null) {
            throw new CalificacionException("Nrc no encontrado");
        }
        List<MatriculaNrc> matriculasNrcs = this.matriculaNrcRepository.findByPkCodNrcAndPkCodPeriodoAndPkCodDepartamentoAndPkCodMateriaOrderByPkCodPersona(nrcPk.getCodNrc(), nrcPk.getCodPeriodo(), nrcPk.getCodDepartamento(), nrcPk.getCodMateria());
        if (matriculasNrcs.isEmpty()) {
            throw new CalificacionException("No hay alumnos en este Nrc");
        }
        List<Persona> personas = new ArrayList<>();
        for (MatriculaNrc matriculaNrc : matriculasNrcs) {
            Persona persona = this.obtenerPorCodigoPersona(matriculaNrc.getPk().getCodPersona());
            personas.add(persona);
        }
        return personas;
    }
}
