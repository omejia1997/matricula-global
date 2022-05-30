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
package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class HistTipoPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Column(name = "cod_tipo_persona", nullable = false, length = 3)
    private String codTipoPersona;

    public HistTipoPersonaPK() {
    }

    public HistTipoPersonaPK(int codPersona, String codTipoPersona) {
        this.codPersona = codPersona;
        this.codTipoPersona = codTipoPersona;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (codTipoPersona != null ? codTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HistTipoPersonaPK)) {
            return false;
        }
        HistTipoPersonaPK other = (HistTipoPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if ((this.codTipoPersona == null && other.codTipoPersona != null) || (this.codTipoPersona != null && !this.codTipoPersona.equals(other.codTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "histTipoPersonaPK[ codPersona=" + codPersona + ", codTipoPersona=" + codTipoPersona + " ]";
    }
    
}
