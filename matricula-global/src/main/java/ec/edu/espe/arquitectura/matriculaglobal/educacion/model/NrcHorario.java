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

import ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model.Aula;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "edu_nrc_horario")

public class NrcHorario implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    private NrcHorarioPK pk;
    @Column(name = "cod_aula", nullable = false, insertable = false ,updatable = false)
    private int codAula;
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "dia_semana", nullable = false, insertable = false ,updatable = false)
    private String diaSemana;
    @Column(name = "cod_materia", nullable = false, insertable = false ,updatable = false)
    private Integer codMateria;
    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumns({
            @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc nrc;
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aula aula;

    public NrcHorario() {
    }

    public NrcHorario(NrcHorarioPK nrcHorarioPK) {
        this.pk = nrcHorarioPK;
    }

    public NrcHorarioPK getPk() {
        return pk;
    }

    public void setPk(NrcHorarioPK nrcHorarioPK) {
        this.pk = nrcHorarioPK;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getCodAula() {
        return codAula;
    }

    public void setCodAula(int codAula) {
        this.codAula = codAula;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof NrcHorario)) {
            return false;
        }
        NrcHorario other = (NrcHorario) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ nrcHorarioPK=" + pk + " ]";
    }

}
