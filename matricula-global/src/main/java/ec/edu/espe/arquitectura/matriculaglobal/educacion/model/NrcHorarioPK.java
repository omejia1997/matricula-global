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
import javax.persistence.*;

@Embeddable
public class NrcHorarioPK implements Serializable {

    
    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;
    
    @Column(name = "cod_periodo", nullable = false)
    private int codPeriodo;
    
    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;
    
    @Column(name = "cod_materia", nullable = false)
    private int codMateria;
    
    @Column(name = "cod_aula", nullable = false)
    private int codAula;
    
    @Column(name = "dia_semana", nullable = false, length = 25)
    private String diaSemana;

    public NrcHorarioPK() {
    }

    public short getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(short codNrc) {
        this.codNrc = codNrc;
    }

    public int getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(int codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        hash += (int) codAula;
        hash += (diaSemana != null ? diaSemana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof NrcHorarioPK)) {
            return false;
        }
        NrcHorarioPK other = (NrcHorarioPK) object;
        if (this.codNrc != other.codNrc) {
            return false;
        }
        if (this.codPeriodo != other.codPeriodo) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        if (this.codMateria != other.codMateria) {
            return false;
        }
        if (this.codAula != other.codAula) {
            return false;
        }
        if ((this.diaSemana == null && other.diaSemana != null) || (this.diaSemana != null && !this.diaSemana.equals(other.diaSemana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + ", codAula=" + codAula + ", diaSemana=" + diaSemana + " ]";
    }
    
}
