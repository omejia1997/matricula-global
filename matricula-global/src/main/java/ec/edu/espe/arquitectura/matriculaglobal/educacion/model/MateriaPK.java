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
public class MateriaPK implements Serializable {

    @Column(name = "cod_materia", nullable = false)
    private int codMateria;
    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;

    public MateriaPK() {
    }

    public MateriaPK(int codMateria, int codDepartamento) {
        this.codMateria = codMateria;
        this.codDepartamento = codDepartamento;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codMateria;
        hash += (int) codDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MateriaPK)) {
            return false;
        }
        MateriaPK other = (MateriaPK) object;
        if (this.codMateria != other.codMateria) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMateria=" + codMateria + ", codDepartamento=" + codDepartamento + " ]";
    }
    
}
