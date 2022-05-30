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
public class DireccionPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Column(name = "sec_direccion", nullable = false)
    private short secDireccion;

    public DireccionPersonaPK() {
    }

    public DireccionPersonaPK(int codPersona, short secDireccion) {
        this.codPersona = codPersona;
        this.secDireccion = secDireccion;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public short getSecDireccion() {
        return secDireccion;
    }

    public void setSecDireccion(short secDireccion) {
        this.secDireccion = secDireccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (int) secDireccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    
        if (!(object instanceof DireccionPersonaPK)) {
            return false;
        }
        DireccionPersonaPK other = (DireccionPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if (this.secDireccion != other.secDireccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DireccionPersonaPK[ codPersona=" + codPersona + ", secDireccion=" + secDireccion + " ]";
    }
    
}
