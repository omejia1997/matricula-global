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
package ec.edu.espe.arquitectura.matriculaglobal.general.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class PaisEstructuraPK implements Serializable {

    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Column(name = "nivel", nullable = false)
    private short nivel;

    public PaisEstructuraPK() {
    }

    public PaisEstructuraPK(String codPais, short nivel) {
        this.codPais = codPais;
        this.nivel = nivel;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        hash += (int) nivel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PaisEstructuraPK)) {
            return false;
        }
        PaisEstructuraPK other = (PaisEstructuraPK) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPais=" + codPais + ", nivel=" + nivel + " ]";
    }
    
}
