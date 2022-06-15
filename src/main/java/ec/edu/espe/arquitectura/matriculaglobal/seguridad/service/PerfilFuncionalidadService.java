package ec.edu.espe.arquitectura.matriculaglobal.seguridad.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.matriculaglobal.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.PerfilException;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.FuncionalidadRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidad;
import ec.edu.espe.arquitectura.matriculaglobal.seguridad.model.PerfilFuncionalidadPK;

@Service
public class PerfilFuncionalidadService {
    private FuncionalidadRepository funcionalidadRepository;
    private PerfilFuncionalidadRepository perfilFuncionalidadRepository;
    private PerfilRepository perfilRepository;

    public PerfilFuncionalidadService(FuncionalidadRepository funcionalidadRepository, PerfilFuncionalidadRepository perfilFuncionalidadRepository, PerfilRepository perfilRepository) {
        this.funcionalidadRepository = funcionalidadRepository;
        this.perfilFuncionalidadRepository = perfilFuncionalidadRepository;
        this.perfilRepository = perfilRepository;
    }

    public Perfil obtenerPerfilPorCodigo(String codigo) {
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()) {
            return perfilOpt.get();
        } else {
            return null;
        }
    }

    public Funcionalidad buscarFuncionalidadPorCodigo(Integer codigo) {
        Optional<Funcionalidad> funcionalidadOpt = this.funcionalidadRepository.findById(codigo);
        if (funcionalidadOpt.isPresent()) {
            return funcionalidadOpt.get();
        } else {
            return null;
        }
    }

    public void asignarFuncionalidad(String codigoPerfil, List<Integer> codigoFuncionalidades, PerfilFuncionalidad perfilFuncionalidad) throws PerfilException, UnknownHostException{
        Perfil perfil = this.obtenerPerfilPorCodigo(codigoPerfil);
        if(perfil == null){
            throw new PerfilException("Perfil no encontrado");
        } 
        for(Integer codigo : codigoFuncionalidades){
            Funcionalidad funcionalidad = this.buscarFuncionalidadPorCodigo(codigo);
            if(funcionalidad != null){
                if(funcionalidad.getEstado().equals(EstadosEnum.ACTIVO.getValor())){
                    PerfilFuncionalidad perFunTemp = new PerfilFuncionalidad();
                    perFunTemp.setAudFecha(new Date());
                    perFunTemp.setAudIp(InetAddress.getLocalHost().getHostAddress());
                    perFunTemp.setAudUsuario(perfilFuncionalidad.getAudUsuario());
                    PerfilFuncionalidadPK pk = new PerfilFuncionalidadPK();
                    pk.setCodFuncionalidad(funcionalidad.getCodFuncionalidad());
                    pk.setCodPerfil(codigoPerfil);
                    perFunTemp.setPerfilFuncionalidadPK(pk);
                    this.perfilFuncionalidadRepository.save(perFunTemp);
                }
            }
        }
    }
    
    public void eliminarPerfilFuncionalidad (List<PerfilFuncionalidadPK> funcionalidadesPerfil){
        this.perfilFuncionalidadRepository.deleteAllById(funcionalidadesPerfil);
    }
}