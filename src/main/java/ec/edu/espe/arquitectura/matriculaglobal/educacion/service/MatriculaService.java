package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.MatriculaNrcException;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.MatriculaTipoEnum;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.MatriculaTipoException;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final PersonaRepository personaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, PersonaRepository personaRepository) {
        this.matriculaRepository = matriculaRepository;
        this.personaRepository = personaRepository;
    }

    public Matricula obtenerPorCodigo(MatriculaPK matriculapk) {
        Optional<Matricula> matrOpt = this.matriculaRepository.findById(matriculapk);
        if (matrOpt.isPresent()) {
            return matrOpt.get();
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

    public List<Matricula> buscarPorTipo(String tipo) throws MatriculaTipoException {
        if(Integer.parseInt(tipo) == MatriculaTipoEnum.PRIMERA.getValor() || Integer.parseInt(tipo) == MatriculaTipoEnum.SEGUNDA.getValor() || Integer.parseInt(tipo) == MatriculaTipoEnum.TERCERA.getValor())
            return matriculaRepository.findByTipo(tipo);
        else
            throw new MatriculaTipoException("El nivel especificado no exciste");
    }

    public List<Matricula> buscarPorFecha(String fecha) {
        Date fechaDb = new Date();
        try{
            fechaDb = new SimpleDateFormat("yyyy-MM-DD").parse(fecha);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return this.matriculaRepository.findByFechaGreaterThan(fechaDb);
    }

    public List<Matricula> buscarPorCodPersona(Integer codPersona) {
        return this.matriculaRepository.findByPkCodPersonaOrderByCodPeriodo(codPersona);
    }

    public List<Matricula> buscarPorCodPersonaYCodPeriodo(Integer codPersona, Integer codPeriodo) {
        return this.matriculaRepository.findByPkCodPersonaAndCodPeriodo(codPersona, codPeriodo);
    }
    
    public List<Persona> buscarAlumnosMatriculadosPorCarreraYPeriodo(Integer codCarrera,Integer codPeriodo){
        List<Matricula> matriculasPeriodo=this.matriculaRepository.findByCodCarreraAndCodPeriodo(codCarrera, codPeriodo);
        List<Persona> personas = new ArrayList<>();
        for(Matricula m: matriculasPeriodo){
            System.out.println("\n"+m.getPk().getCodPersona());
            Persona persona = this.obtenerPorCodigoPersona(m.getPk().getCodPersona());
            personas.add(persona);
        }
        return personas;
    }

    public void crear(Matricula matricula) throws MatriculaNrcException {
        Persona persona = this.obtenerPorCodigoPersona(matricula.getPk().getCodPersona());
        if(persona.getEstado().equals(EstadosEnum.INACTIVO.getValor()))
            throw new MatriculaNrcException("Actualmente se encuentra Inactivo");
        if(!persona.getCodTipoPersona().equals(TipoPersonaEnum.ESTUDIANTE.getValor()) ){
            throw new MatriculaNrcException("No es un Estudiante y no se puede matricular");
        } 
        matricula.setFecha(new Date());
        this.matriculaRepository.save(matricula);
    }
}
