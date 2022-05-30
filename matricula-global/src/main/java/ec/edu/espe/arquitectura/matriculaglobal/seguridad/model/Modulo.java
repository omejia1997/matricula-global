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
package ec.edu.espe.arquitectura.matriculaglobal.seguridad.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "seg_modulo")

public class Modulo implements Serializable {

    private static final long serialVersionUID = 1324321L;
    @Id
    @Column(name = "cod_modulo", nullable = false, length = 16)
    private String codModulo;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codModulo")
    private List<Funcionalidad> funcionalidadList;

    public Modulo() {
    }

    public Modulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Funcionalidad> getFuncionalidadList() {
        return funcionalidadList;
    }

    public void setFuncionalidadList(List<Funcionalidad> funcionalidadList) {
        this.funcionalidadList = funcionalidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codModulo=" + codModulo + " ]";
    }
    
}
