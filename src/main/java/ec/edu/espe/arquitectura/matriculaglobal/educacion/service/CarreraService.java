package ec.edu.espe.arquitectura.matriculaglobal.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.NivelCarreraEnum;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.NivelCarreraException;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public Carrera obtenerPorCodigo(Integer codigo) {
        Optional<Carrera> carrOpt = this.carreraRepository.findById(codigo);
        if (carrOpt.isPresent()) {
            return carrOpt.get();
        } else {
            return null;
        }
    }

    public List<Carrera> buscarPorNivel(String nivel) throws NivelCarreraException {
        if(nivel.equals(NivelCarreraEnum.PREGRADO.getTexto()) || nivel.equals(NivelCarreraEnum.LINEA.getTexto()) || nivel.equals(NivelCarreraEnum.SUFICIENCIA.getTexto())) 
            return carreraRepository.findByNivelOrderByNombre(nivel);
        else
            throw new NivelCarreraException("El nivel especificado no exciste");
    }

    public List<Carrera> buscarPorNombre(String nombre) {
        return carreraRepository.findByNombreLikeOrderByNivel(nombre);
    }

    public List<Carrera> buscarPorModalidad(String modalidad) {
        return carreraRepository.findByModalidadOrderByNombre(modalidad);
    }

    public List<Carrera> buscarPorCodDepartamento(Integer codigo) {
        return carreraRepository.findByCodDepartamentoOrderByNombre(codigo);
    }

    
}
