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

@Entity
@Table(name = "edu_malla_carrera")

public class MallaCarrera implements Serializable {

    private static final long serialVersionUID = 12345L;
    @Id
    @Column(name = "cod_materiacarrera", nullable = false)
    private Integer codMateriacarrera;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "cod_carrera", nullable = false, insertable = false ,updatable = false)
    private Integer codCarrera;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private Carrera carrera;

    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private Materia materia;

    public MallaCarrera() {
    }

    public MallaCarrera(Integer codMateriacarrera) {
        this.codMateriacarrera = codMateriacarrera;
    }

    public Integer getCodMateriacarrera() {
        return codMateriacarrera;
    }

    public void setCodMateriacarrera(Integer codMateriacarrera) {
        this.codMateriacarrera = codMateriacarrera;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera codCarrera) {
        this.carrera = codCarrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateriacarrera != null ? codMateriacarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MallaCarrera)) {
            return false;
        }
        MallaCarrera other = (MallaCarrera) object;
        if ((this.codMateriacarrera == null && other.codMateriacarrera != null) || (this.codMateriacarrera != null && !this.codMateriacarrera.equals(other.codMateriacarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMateriacarrera=" + codMateriacarrera + " ]";
    }
    
}
