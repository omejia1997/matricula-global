package ec.edu.espe.arquitectura.matriculaglobal.educacion;

import java.util.List;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;

public class MatriculaCrear {
    private MatriculaPK matriculaPK;
    private  List<NrcPK> nrcsPK;
    
    public MatriculaCrear() {
    }

    public MatriculaCrear(MatriculaPK matriculaPK, List<NrcPK> nrcsPK) {
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
}
