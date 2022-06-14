/*
 * Copyright 2022 User.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "edu_matricula")

public class Matricula implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    private MatriculaPK pk;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "costo", nullable = false)
    private BigDecimal costo;
    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;
    @Column(name = "cod_carrera", nullable = false)
    private Integer codCarrera;
    @JsonIgnore
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false, insertable = false ,updatable = false)
    @ManyToOne(optional = false)
    private Carrera carrera;
    @JsonIgnore
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false ,updatable = false)
    @OneToOne(optional = false)
    private Periodo periodo;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<MatriculaNrc> matriculaNrc;

    public Matricula() {
    }

    public Matricula(MatriculaPK pk) {
        this.pk = pk;
    }

    public MatriculaPK getPk() {
        return pk;
    }

    public void setPk(MatriculaPK pk) {
        this.pk = pk;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public List<MatriculaNrc> getMatriculaNrc() {
        return matriculaNrc;
    }

    public void setMatriculaNrc(List<MatriculaNrc> matriculaNrcList) {
        this.matriculaNrc = matriculaNrcList;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ matriculaPK=" + pk + " ]";
    }
    
}
