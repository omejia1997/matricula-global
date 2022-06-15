package ec.edu.espe.arquitectura.matriculaglobal.educacion;

import java.util.List;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;

public class MatriculaCrear {
    private Integer codCarrera; 
    private MatriculaPK matriculaPK;
    private List<NrcPK> nrcsPK;
    
    public MatriculaCrear() {
    }

    public MatriculaCrear(Integer codCarrera, MatriculaPK matriculaPK, List<NrcPK> nrcsPK) {
        this.codCarrera = codCarrera;
        this.matriculaPK = matriculaPK;
        this.nrcsPK = nrcsPK;
    }

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public List<NrcPK> getNrcsPK() {
        return nrcsPK;
    }

    public void setNrcsPK(List<NrcPK> nrcsPK) {
        this.nrcsPK = nrcsPK;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }
}
