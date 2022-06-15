package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.math.BigDecimal;
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
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final PersonaRepository personaRepository;
    private final MatriculaNrcRepository matriculaNrcRepository;
    private final NrcRepository nrcRepository;
    private final CarreraRepository carreraRepository;
  

    public MatriculaService(MatriculaRepository matriculaRepository, PersonaRepository personaRepository,
            MatriculaNrcRepository matriculaNrcRepository, NrcRepository nrcRepository,
            CarreraRepository carreraRepository) {
        this.matriculaRepository = matriculaRepository;
        this.personaRepository = personaRepository;
        this.matriculaNrcRepository = matriculaNrcRepository;
        this.nrcRepository = nrcRepository;
        this.carreraRepository = carreraRepository;
    }

    public Matricula obtenerPorCodigo(MatriculaPK matriculapk) {
        Optional<Matricula> matrOpt = this.matriculaRepository.findById(matriculapk);
        if (matrOpt.isPresent()) {
            return matrOpt.get();
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

    private void insertarMatriculaNrc(Integer codCarrera,Integer codPeriodo, MatriculaPK pkMatricula, List<NrcPK> pksNrc, Integer tipoMatricula, BigDecimal numCreditos){
        BigDecimal CREDITOS_MINIMOS = new BigDecimal(18);
        Matricula matriculaDB = this.obtenerMatriculaPorCodigo(pkMatricula);
        
        if(matriculaDB==null){
            matriculaDB = new Matricula(pkMatricula);
            matriculaDB.setCodCarrera(codCarrera);
            matriculaDB.setCodPeriodo(codPeriodo);
            matriculaDB.setTipo(tipoMatricula.toString());
            matriculaDB.setFecha(new Date());
            matriculaDB.setCosto(new BigDecimal(0));
            this.matriculaRepository.save(matriculaDB);
        }
        
        Carrera carreraDB = this.obtenerCarreraPorCodigo(codCarrera);
        BigDecimal precioCreditoDB = carreraDB.getPrecioCredito();
        
        for(NrcPK pkNrc : pksNrc){
            Nrc nrcDB = this.obtenerNrcPorCodigo(pkNrc);
            if(nrcDB.getCupoDisponible()>0){
                Materia materia = nrcDB.getMateria();
                BigDecimal numeroCreditos = materia.getCreditos();
                numCreditos.add(numeroCreditos);
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
        if(numCreditos.compareTo(CREDITOS_MINIMOS)==1){
            matriculaDB.setCosto(new BigDecimal(0));
        }
        this.matriculaRepository.save(matriculaDB);
    }

    public void crear(Integer codCarrera,MatriculaPK pkMatricula, List<NrcPK> pksNrc) throws MatriculaNrcException{
        Boolean check = false;
        Integer MATRICULAS_MAXIMAS = 2;
        Integer codPeriodo=0;
        Integer tipoMatricula=0;
        BigDecimal numeroCreditos = new BigDecimal(0);
        Persona persona = this.obtenerPorCodigoPersona(pkMatricula.getCodPersona());
        if(persona.getEstado().equals(EstadosEnum.INACTIVO.getValor()))
            throw new MatriculaNrcException("Actualmente se encuentra Inactivo");
        if(!persona.getCodTipoPersona().equals(TipoPersonaEnum.ESTUDIANTE.getValor()) ){
            throw new MatriculaNrcException("No es un Estudiante y no se puede matricular");
        } 
        for(NrcPK pkNrcVal : pksNrc){
            List <MatriculaNrc> matNrcAux = this.matriculaNrcRepository.findByPkCodPersonaAndPkCodMateria(pkMatricula.getCodPersona(), pkNrcVal.getCodMateria());
            if(matNrcAux!=null){
                for(MatriculaNrc m:matNrcAux){
                    numeroCreditos.add(m.getNrc().getMateria().getCreditos());
                }
            }
            if(matNrcAux.size()>tipoMatricula)
                tipoMatricula = matNrcAux.size();
            codPeriodo = pkNrcVal.getCodPeriodo();
            if(matNrcAux.size() == MATRICULAS_MAXIMAS){
                check = true;
                if(check){
                    pksNrc.clear();
                    check = false;
                }
                pksNrc.add(pkNrcVal);
            }
        }

        this.insertarMatriculaNrc(codCarrera,codPeriodo,pkMatricula, pksNrc,tipoMatricula,numeroCreditos);
    }
}
