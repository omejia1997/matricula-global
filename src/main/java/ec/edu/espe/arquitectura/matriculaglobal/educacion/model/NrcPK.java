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
public class NrcPK implements Serializable {

    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;

    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;

    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;

    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;

    public NrcPK() {
    }
    public Integer getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(Integer codNrc) {
        this.codNrc = codNrc;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof NrcPK)) {
            return false;
        }
        NrcPK other = (NrcPK) object;
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
        return true;
    }

    @Override
    public String toString() {
        return "[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + " ]";
    }

}
