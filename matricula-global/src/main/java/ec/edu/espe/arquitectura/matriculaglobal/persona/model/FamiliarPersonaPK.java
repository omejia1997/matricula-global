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
public class FamiliarPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Column(name = "sec_familiar_persona", nullable = false)
    private short secFamiliarPersona;

    public FamiliarPersonaPK() {
    }

    public FamiliarPersonaPK(int codPersona, short secFamiliarPersona) {
        this.codPersona = codPersona;
        this.secFamiliarPersona = secFamiliarPersona;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public short getSecFamiliarPersona() {
        return secFamiliarPersona;
    }

    public void setSecFamiliarPersona(short secFamiliarPersona) {
        this.secFamiliarPersona = secFamiliarPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (int) secFamiliarPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FamiliarPersonaPK)) {
            return false;
        }
        FamiliarPersonaPK other = (FamiliarPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if (this.secFamiliarPersona != other.secFamiliarPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "familiarPersonaPK[ codPersona=" + codPersona + ", secFamiliarPersona=" + secFamiliarPersona + " ]";
    }
    
}
