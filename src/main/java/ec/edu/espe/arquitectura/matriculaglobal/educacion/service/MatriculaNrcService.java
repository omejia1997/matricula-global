package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.MatriculaNrcException;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrcPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.matriculaglobal.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;

@Service
public class MatriculaNrcService {

    private final MatriculaNrcRepository matriculaNrcRepository;
    private final MatriculaRepository matriculaRepository;
    private final PersonaRepository personaRepository;
    private final NrcRepository nrcRepository;
    private final CarreraRepository carreraRepository;

    public MatriculaNrcService(MatriculaNrcRepository matriculaNrcRepository, PersonaRepository personaRepository, NrcRepository nrcRepository , MatriculaRepository matriculaRepository, CarreraRepository carreraRepository) {
        this.matriculaNrcRepository = matriculaNrcRepository;
        this.personaRepository = personaRepository;
        this.nrcRepository = nrcRepository;
        this.matriculaRepository = matriculaRepository;
        this.carreraRepository = carreraRepository;
    }

    public MatriculaNrc obtenerPorCodigo(MatriculaNrcPK matriculaNrcPK) {
        Optional<MatriculaNrc> matrNrcOpt = this.matriculaNrcRepository.findById(matriculaNrcPK);
        if (matrNrcOpt.isPresent()) {
            return matrNrcOpt.get();
        } else {
            return null;
        }
    }

    public Matricula obtenerMatriculaPorCodigo(MatriculaPK matriculaPK) {
        Optional<Matricula> matrOpt = this.matriculaRepository.findById(matriculaPK);
        if (matrOpt.isPresent()) {
            return matrOpt.get();
        } else {
            return null;
        }
    }

    public Carrera obtenerCarreraPorCodigo(Integer codCarrera) {
        Optional<Carrera> carrOpt = this.carreraRepository.findById(codCarrera);
        if (carrOpt.isPresent()) {
            return carrOpt.get();
        } else {
            return null;
        }
    }

    public List<MatriculaNrc> buscarPorEstado(String estado) {
        return this.matriculaNrcRepository.findByEstado(estado);
    }

    public List<MatriculaNrc> buscarNrcMatriculaActivo(Integer codPersona) {
        return this.matriculaNrcRepository.findByPkCodPersonaAndEstado(codPersona, EstadosEnum.ACTIVO.getValor());
    }

    public Persona obtenerPorCodigoPersona(Integer codPersona) {
        Optional<Persona> personaOpt = this.personaRepository.findById(codPersona);
        if (personaOpt.isPresent()) {
            return personaOpt.get();
        } else {
            return null;
        }
    }

    public Nrc obtenerNrcPorCodigo(NrcPK nrcPK) {
        Optional<Nrc> nrcOpt = this.nrcRepository.findById(nrcPK);
        if (nrcOpt.isPresent()) {
            return nrcOpt.get();
        } else {
            return null;
        }
    }

    public void crear(MatriculaNrc matriculaNrc){
        this.matriculaNrcRepository.save(matriculaNrc);
    }

    public void modificar(MatriculaNrc matriculaNrc) {

        MatriculaNrc matriculaNrcDB = this.obtenerPorCodigo(matriculaNrc.getPk());
        matriculaNrcDB.setEstado(matriculaNrc.getEstado());
        matriculaNrcDB.setCosto(matriculaNrc.getCosto());
        matriculaNrcDB.setNumero(matriculaNrc.getNumero());
        this.matriculaNrcRepository.save(matriculaNrcDB);
    }
    
    private void insertarMatriculaNrc(MatriculaPK pkMatricula, List<NrcPK> pksNrc){
        Matricula matriculaDB = this.obtenerMatriculaPorCodigo(pkMatricula);
        Carrera carreraDB = this.obtenerCarreraPorCodigo(matriculaDB.getCodCarrera());
        BigDecimal precioCreditoDB = carreraDB.getPrecioCredito();
        for(NrcPK pkNrc : pksNrc){
            Nrc nrcDB = this.obtenerNrcPorCodigo(pkNrc);
            if(nrcDB.getCupoDisponible()>0){
                Materia materia = nrcDB.getMateria();
                BigDecimal numeroCreditos = materia.getCreditos();
                MatriculaNrcPK pk = new MatriculaNrcPK(pkNrc.getCodNrc(),pkNrc.getCodPeriodo(), pkNrc.getCodDepartamento(), pkNrc.getCodMateria(), pkMatricula.getCodMatricula(), pkMatricula.getCodPersona());
                MatriculaNrc matriculaNrc = new MatriculaNrc(pk);
                matriculaNrc.setEstado(EstadosEnum.ACTIVO.getValor());
                List <MatriculaNrc> matNrcAux = this.matriculaNrcRepository.findByPkCodPersonaAndPkCodMateria(pkMatricula.getCodPersona(), pkNrc.getCodMateria());
                matriculaNrc.setNumero(matNrcAux.size() + 1);
                matriculaNrc.setCosto(precioCreditoDB.multiply(numeroCreditos));
                matriculaDB.setCosto(matriculaDB.getCosto().add(matriculaNrc.getCosto()));
                this.matriculaNrcRepository.save(matriculaNrc);
                nrcDB.setCupoDisponible(nrcDB.getCupoDisponible()-1);
                nrcDB.setCupoRegistrado(nrcDB.getCupoRegistrado()+1);
                this.nrcRepository.save(nrcDB);
            }
        }
        this.matriculaRepository.save(matriculaDB);
    }

    public void registrarMatriculaNrc(MatriculaPK pkMatricula, List<NrcPK> pksNrc) throws MatriculaNrcException{
        Boolean check = false;
        Integer MATRICULAS_MAXIMAS = 2;
        Persona persona = this.obtenerPorCodigoPersona(pkMatricula.getCodPersona());
        if(persona.getEstado().equals(EstadosEnum.INACTIVO.getValor()))
            throw new MatriculaNrcException("Actualmente se encuentra Inactivo");
        if(!persona.getCodTipoPersona().equals(TipoPersonaEnum.ESTUDIANTE.getValor()) ){
            throw new MatriculaNrcException("No es un Estudiante y no se puede matricular");
        } 
        for(NrcPK pkNrcVal : pksNrc){
            List <MatriculaNrc> matNrcAux = this.matriculaNrcRepository.findByPkCodPersonaAndPkCodMateria(pkMatricula.getCodPersona(), pkNrcVal.getCodMateria());
            if(matNrcAux.size() == MATRICULAS_MAXIMAS){
                check = true;
                if(check){
                    pksNrc.clear();
                    check = false;
                }
                pksNrc.add(pkNrcVal);
            }
        }
        this.insertarMatriculaNrc(pkMatricula, pksNrc);
    }

}
